# Comparable Comparator 차이

> Comparable과 Comparator는 모두 인터페이스이다. 즉, 사용하고자 한다면 인터페이스 내에 선언된 메소드를 '반드시 구현' 해야 한다.
> Comparable은 compareTo(T o) 메소드를, Comparator는 compare(T o1, T o2)메소드를 구현해야 한다.

## Comparable과 Comparator를 쓰는 이유
> java 기본 자료형(primitive type)은 쉽게 비교가 가능하지만 새로운 클래스 객체 등 기본 자료형이 아닌 자료형들은 비교가 어렵기 때문이다.

## 차이점
> Comparable은 "자기 자신과 매개변수 객체를 비교"하는 것이고, Comparator는 "두 매개변수 객체를 비교"하는 것이다.
> Comparable은 lang 패키지에 있기 때문에 import 해줄 필요 없지만, Comparator는 util 패키지에 있다.


# Comparable

Comparable을 사용하기 위해서는 해당 인터페이스를 implements 한 다음 compareTo를 overide하여 사용한다.
예시는 다음과 같다.

````java
class Student implements Comparable<Student> {

    int age;			// 나이
    int classNumber;	// 학급

    Student(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

    @Override
    public int compareTo(Student o) {

        // 자기자신의 age가 o의 age보다 크다면 양수
        if(this.age > o.age) {
            return 1;
        }
        // 자기 자신의 age와 o의 age가 같다면 0
        else if(this.age == o.age) {
            return 0;
        }
        // 자기 자신의 age가 o의 age보다 작다면 음수
        else {
            return -1;
        }
    }
}
````

-> compareTo의 반환 타입을 보면 int이다. 따라서 위처럼 if 비교문으로 비교하고 반환값을 지정해 줄 수 있지만

````java
@Override
class Student implements Comparable<Student> {

    int age;			// 나이
    int classNumber;	// 학급

    Student(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

    @Override
    public int compareTo(Student o) {

        /*
         * 만약 자신의 age가 o의 age보다 크다면 양수가 반환 될 것이고,
         * 같다면 0을, 작다면 음수를 반환할 것이다.
         */
        return this.age - o.age;
    }
}
````

다음과 같이 두 값의 차를 반환해버리면 번거로운 조건식 없이 3개의 조건을 만족할 수 있다.

단, 두 값의 차가 int형의 범위를 넘어가서는 안된다. 주어진 범위를 넘어가버리면 underflow 혹은 overflow가 발생되므로
값의 차를 주의해야한다.


# Comparator

파라미터로 들어오는 두 매개변수 객체를 비교한다.

````java
import java.util.Comparator;	// import 필요
public class ClassName implements Comparator<Type> {
	// 필수 구현 부분
	@Override
	public int compare(Type o1, Type o2) {
		/*
		 비교 구현
		 */
	}
}
````

예시를 들면 다음과 같다.

````java
import java.util.Comparator;	// import 필요
class Student implements Comparator<Student> {

    int age;			// 나이
    int classNumber;	// 학급

    Student(int age, int classNumber) {
        this.age = age;
        this.classNumber = classNumber;
    }

    @Override
    public int compare(Student o1, Student o2) {

        /*
         * 만약 o1의 classNumber가 o2의 classNumber보다 크다면 양수가 반환 될 것이고,
         * 같다면 0을, 작다면 음수를 반환할 것이다.
         */
        return o1.classNumber - o2.classNumber;
    }
} 
````

## Comparator 활용하기

Comparator를 활용하기 위해서는 결국 compare 메소드를 활용하기 위한 객체가 필요하다.
예를 들면, 다음과 같은 상황이 온다는 것이다.

````java
public class Test {
	public static void main(String[] args)  {
 
		Student a = new Student(17, 2);	// 17살 2반
		Student b = new Student(18, 1);	// 18살 1반
		Student c = new Student(15, 3);	// 15살 3반
			
		//          ⋁
		int isBig = a.compare(a, b);
        //           ⋁
		int isBig2 = a.compare(b, c);
		//           ⋁
		int isBig3 = b.compare(a, c);
	}
}
````

이러한 문제를 해결하기 위해서, 익명 객체를 활용하면 된다.

````java
import java.util.Comparator;
 
public class Test {
	public static void main(String[] args) {
    
		// 익명 객체 구현방법 1
		Comparator<Student> comp1 = new Comparator<Student>() {
			@Override
			public int compare(Student o1, Student o2) {
				return o1.classNumber - o2.classNumber;
			}
		};
	}
 
	// 익명 객체 구현 2
	public static Comparator<Student> comp2 = new Comparator<Student>() {
		@Override
		public int compare(Student o1, Student o2) {
			return o1.classNumber - o2.classNumber;
		}
	};
}
 
 
// 외부에서 익명 객체로 Comparator가 생성되기 때문에 클래스에서 Comparator을 구현 할 필요가 없어진다.
class Student {
 
	int age;			// 나이
	int classNumber;	// 학급
	
	Student(int age, int classNumber) {
		this.age = age;
		this.classNumber = classNumber;
	}
 
}
````

즉, 이전에 a.compare(b,c) 이런식이 아니라, 위에서 생성한 익명객체를 가리키는 comp를 통해
comp.compare(b,c) 이런 식으로 해주면 된다.




