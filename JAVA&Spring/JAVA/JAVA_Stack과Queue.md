# 20.08.05 Java Algorithm

## 1. 스택(Stack)

- #### 스택의 특성

  - 물건을 쌓아 올리듯 자료를 쌓아 올린 형태의 자료구조이다.

  - 스택에 저장된 자료는 __선형구조__를 가진다.

    - 선형구조 : 자료 간의 관계가 1대1의 관계를 갖는다.
    - 비선형구조 : 자료 간의 관계가 1대N의 관계를 갖는다(ex. 트리구조)

  - 스택에 자료를 삽입하거나 스택에서 자료를 꺼낼 수 있다.

  - 후입선출(LIFO, Last-In-First-Out)

    - 마지막에 삽입한 자료를 가장 먼저 꺼낸다.

    

- #### 자료구조

  > 자료를 선형으로 저장할 저장소

  - 스택에서 마지막 삽입된 원소의 위치를 `top`이라 부른다.

  - 연산

    - 삽입 `push` : 저장소에 자료를 저장한다.
    - 삭제 `pop` : 저장소에서 자료를 꺼낸다. 삽입한 자료의 역순이다.

    - `isEmpty` : 스택이 공백인지 아닌지 확인하는 연산
    - `peek` : 스택의 __top__에 있는 __items(원소)__를 반환하는 연산. 원소제거X

    

- Stack 코드 예시)

  ```java
  import java.util.Stack;
  
  public class St1_StackAPITest {
      public static void main(String[] args){
          Stack<String> stack = new Stack<String>();
  //        stack.push("이동욱");
  //        stack.pop();
  //        stack.peek();
  //        stack.size();
      }
  }
  ```

  - `Ctrl` + `Shift` + `O` : 현재 사용하는 기능의 패키지를 추가 & 사용안하고있는데 불러온 패키지 제거 (정리)

    

- Stack 응용 예시)
  - 브라우저 구현

    > 표준 웹 브라우저는 방문한 페이지 내에서 이전, 이후 페이지를 방문하는 기능이 있다.

    - Backward Stack과 Forward Stack으로 구성.
      - V(isit) : url로 방문
      - B(ack) : 뒤로
      - F(orward) : 앞으로



## 2. 큐(Queue)

> 선형자료구조
>
> 선입선출구조(FIFO, FIrst-In-First-Out)

- 삽입은 enQueue, 삭제는 deQueue
- `java.util.Queue` 
  - 큐에 필요한 연산을 선언해놓은 __인터페이스__(클래스 아님)
  - LinkedList 클래스를 __구현체__로 많이 사용



- #### 우선순위 큐(Priority Queue)

  - 우선순위를 가진 항목들을 저장하는 큐
  - __우선순위가 높은 순서대로__ 먼저 나가게 된다.
    (우리가 결정할 수 있음)
  - `java.util.PriorityQueue`
    - 구현체이다. 
    - Heap 자료구조 (Tree 기반)
      - 최대 Heap
        - 가장 큰 값을 기준으로 먼저 나옴
      - 최소 Heap
        - 가장 작은 값을 기준으로 먼저 나옴
  - 힙(Heap)
    - 완전 이진 트리로 구현된 자료구조
    - 가장 큰(or 작은) 노드가 항상 Root에 존재한다.
    - 힙의 키를 우선순위로 활용하여 PriorityQueue 구현