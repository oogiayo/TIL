# 20.08.09 입력 시간초과 문제

## 1. JAVA Input/Output 관련 모듈

> bj_11723_집합 문제를 풀면서, '시간초과' 문제가 발생했다.
> 해결 방법은 Input/Output 시간을 단축하는 것이었다.

#### 1.1 `java.io`

- `java.util.scanner` 모듈의 Scanner보다 빠르다고 한다.

- 한 줄(Line) 단위로 input 받는 듯!
- 출력은 append로 모았다가 한 번에 하는 듯!



#### 1.2 모듈 사용 방법

- 모듈 불러오기
  - `java.io.BufferedReader`	 
  - `java.io.IOException`
    - 이거는 main 옆에다가 `throws IOException ` 사용하던데.. 뭔지 더 공부해야겠다 ㅠㅠ
  - `java.io.InputStreamReader`



- 함수 사용 (입력)

  ```java
  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
  ```

  - 한 줄 String 받기

    ```
    String A = bf.readLine();
    ```

  - Integer 받기

    ```java
    int A = Integer.valueOf(bf.readLine());
    ```

  - 한 줄 split해서 array로 받기

    ```java
    String[] line = bf.readLine().split(" ")
    ```

  

- 함수 사용 (출력)

  ```java
  StringBuilder sb = new StringBuilder();
  ```

  - 출력할 StringBuilder에 넣기

    ```java
    sb.append("1\n");
    ```

  - 최종적으로 출력하기

    > Sysout으로 출력하면 된다!

    ```java
    System.out.print(sb);
    ```

    

#### 1.1 사용 예시

```java
// BJ_11723_집합

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int M = Integer.valueOf(bf.readLine());
		int S = 0;
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<M; i++) {
			String[] line = bf.readLine().split(" ");
			if(line[0].equals("all")) {
			 	S = 1048575;
			}
			else if(line[0].equals("empty")) {
				S = 0;
			}
			else {
				int x = Integer.valueOf(line[1]);
				if(line[0].equals("add")) {
					S |= (1<<x-1);
				}
				if(line[0].equals("remove")) {
					S &= ~(1<<x-1);
				}
				if(line[0].equals("check")) {
					if((S&(1<<x-1))==0) {
						sb.append("0\n");
					}
					else {
						sb.append("1\n");
					}
				}
				if(line[0].equals("toggle")) {
					if((S&(1<<x-1))==0) {
						S |= (1<<x-1);
					}
					else {
						S &= ~(1<<x-1);
					}
				}
			}
		}
		System.out.print(sb);
	}
}//end of class
```



#### 1.4 사용 후기 / 느낀점

- 앞으로 코딩Test / 역량Test에서 꼭 필요하고 익숙해져야 할 기능들이긴 하지만.. 뭔가 아직까지는 어렵고 생소하게 느껴진다. 개인시간 할애해서 Java 열심히 공부하자~! 개발자가 되어야지 욱아 ^^