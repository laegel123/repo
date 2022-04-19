## 이진탐색트리란?
> 이진탐색트리란 다음과 같은 특징을 갖는 이진트리를 말한다.
(*이진트리 : 각 노드의 자식 노드가 2개인 트리)

1. 각 노드에 중복되지 않는 키가 있다.
2. 루트 노드의 왼쪽 서브 트리는 해당 노드의 키보다 작은 키를 갖는 노드들로 이루어져 있다.
3. 루트 노드의 오른쪽 서브 트리는 해당 노드의 키보다 큰 키를 갖는 노드들로 이루어져 있다.
4. 좌우 서브 트리도 모두 이진 탐색 트리여야 한다.

예시)
![img.png](../../../Etc/Img/binarySearchTree01.png)


### 특징
이진탐색트리는 기존 이진트리보다 탐색 속도가 빠르다. 이진탐색트리의 탐색 연산은 높이가 h라면
O(h) 의 시간 복잡도를 갖는다.


### 탐색 과정
> 이진탐색트리의 탐색은 다음과 같은 과정을 거친다.

1. 루트 노드의 키와 찾고자 하는 값을 비교한다. 찾고자 하는 값이라면 탐색을 종료한다.
2. 찾고자 하는 값이 루트 노드의 키보다 작다면 왼쪽 서브 트리로 탐색을 진행한다.
3. 찾고자 하는 값이 루트 노드의 키보다 크다면 오른쪽 서브 트리로 탐색을 진행한다.

![img.png](../../../Etc/Img/binarySearchTree02.png)

해당 예시를 보면 시간복잡도는 최대 o(h)인 것을 알 수 있다.

### 이진탐색트리 탐색 소스코드



### 삽입
> 이진탐색트리의 삽입은 다음과 같은 과정을 거친다.

1. 삽입할 값을 루트 노드와 비교해 같다면 오류를 발생시킨다. (중복값 허용 x)
2. 삽입할 값이 루트 노드의 키보다 작다면 왼쪽 서브 트리를 탐색해서 비어있다면 추가하고, 비어있지 않다면
    다시 값을 비교한다.
3. 삽입할 값이 루트 노드의 키보다 크다면 오른쪽 서브 트리를 탐색해서 비어있다면 추가하고, 비어있지 않다면
    다시 값을 비교한다.

### 삭제
> 이진탐색트리의 삭제는 삽입보다 조금 더 복잡하다. 이진탐색트리에서 특정 노드를 삭제할 때 아래와 같은 3가지 상황을 나누어 구현해야한다.

1. 삭제하려는 노드가 단말노드인 경우
2. 삭제하려는 노드의 서브 트리가 하나인 경우
3. 삭제하려는 노드의 서브 트리가 두 개인 경우

1) 삭제할 노드의 부모 노드가 있다면 부모노드의 자식노드를 null로 만들고, 삭제할 노드를 삭제해주면 된다.

2) 삭제할 노드의 자식노드를 삭제할 노드의 부모노드가 가리키게 하고 해당 노드를 삭제하면 된다.

3-1) 
https://code-lab1.tistory.com/10