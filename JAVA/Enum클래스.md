# Enum Class
> 우리는 흔히 상수를 정의할 때 final static string 같은 방식으로 상수를 정의한다. 하지만 이렇게 상수를 정의하는 경우 다양한 문제가 발생할 수 있다.
> 이러한 문제점들을 보완하기 위해 자바 1.5부터 새롭게 추가되었다.
> Enum은 열거형이라고 불리며, 서로 연관된 상수들의 집합을 의미한다.

## Enum의 장점
1. 코드가 단순해지며, 가독성이 좋다.
2. 인스턴스 생성과 상속을 방지하여 상수값의 타입 안정성이 보장된다.
3. enum class를 사용해 새로운 상수들의 타입을 정의함으로써 정의한 타입 이외의 타입을 가진 데이터값을 컴파일시 체크한다.
4. 케워드 enum을 사용하기 때문에 구현 의도가 열거임을 분명히 할 수 있다.

````java
public class EnumExample {
	// 기존에 상수를 정의하는 방법
	public static final String MALE = "MALE";
	public static final String FEMALE = "FEMALE";

	public static void main(String[] args) {
		String gender1;
		gender1 = EnumExample.MALE;
		gender1 = EnumExample.FEMALE;
		// MALE, FEMALE이 아닌 상수 값이 할당 될 때 //컴파일시 에러가 나지 않음. -> 문제점 발생.
		gender1 = "boy";
		Gender gender2;
		gender2 = Gender.MALE;
		gender2 = Gender.FEMAL;
		// 컴파일 시 의도하지 않는 상수 값을 체크할 수 있음.
		// Enum으로 정의한 상수값만 할당 받을 수 있음.
		gender2 = "boy";
	}
}

// enum class를 이용해 Gender라는 새로운 상수들의 타입을 정의한다.
enum Gender { 
	MALE,
	FEMAL; 
}
````
gender1 변수에 "boy"라는 값이 할당되었을 때, 따로 유효성을 검사하는 로직이 들어가있지 않다면 자바 컴파일 시 문제점을 발견할 수 없어 엉뚱한 결과값을 얻을 수 있다.

이러한 문제를 해결하기 위해 Enum을 사용한다.

gender2 = Gender.MALE;
gender2 = Gender.FEMAL;

위와 같이 Gender 타입으로 선언된 gender2는 인스턴스를 따로 생성하지도 않고 바로 MALE, FEMAL에 접근했는데,
내부적으로 생략되었을 뿐 다음 class와 같다.

````java
class Gender{
	public static final Gender MALE = new Gender();
	public static final Gender FEMALE = new Gender();
}
````

따라서 Enum class로 선언한 gender2는 

gender2 = "boy"

로 할당하려고 할 시 컴파일에러가 발생되어 기대하지 않는 상수값이 들어가는 문제를 먼저 체크할 수 있다.


