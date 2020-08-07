# 20.08.07 LinkedList

### 1.1 리스트(List)

> 순서를 가진 데이터의 집합을 가리키는 추상자료형(Abstract Data Type)

- 구현방법에 따른 분류

  - 순차 리스트
    - 배열을 기반으로 구현된 리스트
  - 연결 리스트
    - 메모리의 동적할당을 기반으로 구현된 리스트
      (동적할당 : new ~~작업 = 객체를 생성해)

  

### 1.2 순차 리스트

- 순차 리스트의 문제점
  - 자료의 삽입/삭제 연산에서 연속적인 메모리 배열을 위해 원소들을 이동시켜야함.
  - 배열의 크기가 정해져있는 경우, 
    - 실제로 사용될 메모리보다 크게 할당하여 메모리의 낭비를 초래할 수 있다.
    -  할당된 메모리보다 더 많은 자료를 사용할 때 새롭게 배열을 만들어 작업해야하는 경우 발생



### 1.3 연결 리스트(Linked List)

- 특성

  - 자료의 논리적인 순서와 메모리 상의 물리적 순서가 일치하지 않고,
    개별적으로 위치하고 있는 원소의 레퍼런스를 연결하여 하나의 전체적인 자료구조를 이룬다.
  - 링크를 통해 원소에 접근하므로, 순차 리스트처럼 물리적 순서 맞추는 작업 X
  - 자료구조의 크기를 동적으로 조정할 수 있어 메모리의 효율적 사용 가능

- 기본 구조

  - 노드(Node)

    > 하나의 원소에 필요한 데이터를 갖고 있는 자료 단위

    - 구성요소

      1) 데이터 필드

      	- 원소의 값을 저장하는 자료구조
      	- 저장할 원소의 종류나 크기에 따라 구조를 정의하여 사용

      2) 링크 필드

      - 다음 노드의 주소를 저장하는 자료구조

  - 헤드(Head)

    > 리스트의 처음 노드를 가리키는 레퍼런스

- 연결 구조

  - node가 하나의 링크 필드에 의해 다음 node와 연결되는 구조
  - Head가 가장 앞의 node를 가리키고, 링크필드가 연속적으로 다음 node를 가리킨다.
  - 최종적으로 링크필드가 NULL을 가리키는 node가 리스트의 가장 마지막 node이다.

```pseudocode
# 첫 번째 노드로 삽입하는 알고리즘
addtoFirst(L, i)
		new <= createNode();
		new.data = i;
		new.link = L;
		L = new;
end addtoFirst()
```

```pseudocode
# 가운데 노드로 삽입하는 알고리즘
add(L, pre, i)
		new <= createNode()
		new.data = i;
		if (L=NULL) then{
				L = new;
				new.link = NULL;
		}
		else{
				new.link = pre.link
				pre.link = new;
		}
end add()
```

```pseudocode
addtoLast(L, i)
		new <= createNode()
		new.data = i;
		new.link = NULL;
		if (L=NULL) then{
				L = new;
				return;
		}
		temp = L;
		while (temp.link != NULL) do
                temp = temp.link;
        temp.link = new;
end addtoLast()
```



### 1.4 이중 연결 리스트(Doubly Linked List)

> 양쪽 방향으로 순회할 수 있도록 노드를 연결한 리스트
>
> 두 개의 링크 필드와 한 개의 데이터필드로 구성