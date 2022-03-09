# Iterator
> 자바의 컬렉션 프레임워크에서 컬렉션에 저장되어 있는 요소들을 읽어오는 방법을 표준화 하였는데 그 중 하나가 Iterator이다.

## Iterator 인터페이스
````java
public interface Iterator {

boolean hasNext();

Object next();

void remove();

}

````

1. hasNext() : 읽어 올 요소가 남아있는지 확인하는 메소드
2. next() : 읽어 올 요소가 남아있는지 확인하는 메소드
3. remove() : next()로 읽어 온 요소를 삭제한다. next()를 호출한 다음에 remove()를 호출해야 한다.
