추상클래스가 무엇이고 왜 사용하는 지 본질적인 개념부터 알아보자.

# 추상클래스란
실체클래스(객체를 직접 생성할 수 있는 클래스) 들의 공통적인 특성들을 추출해서 선언한 클래스이다. 
여기서 추상클래스와 실체클래스는 상속적인 관계를 가지고 있다.

## 특징
1. 추상클래스 -> 실체클래스의 공통적인 부분(변수, 메소드) 를 추출해서 선언한 클래스이다.
2. 추상클래스는 실체성이 없고 구체적이지 않기 때문에 객체를 생성할 수 없다.
3. 추상클래스는 실체클래스와 상속 관계이다.

## 용도
1. 공통된 필드와 메소드를 통일할 목적.
  -> 필드와 메소드 이름을 통일하여 유지보수성을 높이고 통일성을 유지할 수 있다.
  
2. 실체클래스 구현 시, 시간절약.

3. 규격에 맞는 실체클래스 구현.


> 소스 수정 시 다른 소스의 영향도를 적게 가져가면서 변화에는 유연하게 만들기 위해 추상클래스를 사용하기도 한다.
> 규격에 맞게 소스가 구현되어 있기 때문에 해당 규격에 대한 구현부만 수정하면 손 쉽게 수정이 가능하기 때문이다.


## 문법
```java
public abstract class 클래스명 {
  // 필드
  // 생성자
  // 메소드
  // 추상메소드
}
```

------------

## 예제

```java
public abstract class Animal {
  public String kind;
  public void breath() {
    System.out.println("breath");
  }
  
  // 추상 메소드
  public abstract void sound();
}
```

> 여기서 이 추상 클래스를 상속받는 실체 클래스들은 반드시 sound()라는 추상 메소드를 상속받아 재정의(오버라이딩) 해야한다.


```java
public class Dog extends Animal {
  public Dog() {
    this.kind = "포유류";
  }
  
  @Override
  public void sound() {
    System.out.println("멍멍!");
  }
}
```

> extends 키워드를 통해, Animal 추상클래스를 상속받은 Dog 클래스이다.
> 여기서 Cat클래스를 생성하여 Animal 클래스를 상속받는다면 오버라이딩 하는 추상 메소드 부분은 달라질 수 있으므로, 다형성이 발생된다는 사실을 알 수 있다.
> 다형성 : 같은 기능인데 다른 결과를 도출할 수 있음.


또한, 추상클래스 변수에 추상클래스를 상속받아 구현한 실체클래스 인스턴스를 주입하면 해당 추상클래스 변수는 자동 타입변환을 발생시켜
실체클래스 인스턴스처럼 사용할 수 있다. 이를 타입의 다형성이라고 한다.

아래 예시를 보면,

```java
public class AnimalExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Dog dog = new Dog();
		Cat cat = new Cat();
		
		dog.sound();
		cat.sound();
		
		Animal animal = null;
		
		animal = new Dog(); //자동 타입변환
		animal.sound(); //Dog에 구현된 Sound()메서드 실행
		
		animal = new Cat(); //자동 타입변환
		animal.sound(); //Cat에 구현된 Sound()메서드 실행
		
		
		animalSound(new Dog()); //자동 타입변환 (매개변수도 가능)
		animalSound(new Cat()); //자동 타입변환 (매개변수도 가능)
	}
	//자동 타입변환 : 추상클래스 타입 변수는 추상클래스를 상속받은 실체클래스의 타입으로 자동 타입변환이 된다. 
	private static void animalSound(Animal animal) {
		animal.sound();
	}
}
```

> 타입의 다형성은 animalSound라는 메소드를 통해 매개변수도 타입의 다형성(자동 타입변환)을 보여줄 수 있음을 확인할 수 있다.



