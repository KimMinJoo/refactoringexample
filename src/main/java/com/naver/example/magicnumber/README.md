## 매직넘버를 기호 상수로 치환

소스코드에 특정한 숫자(magic number)를 직접 적는건 좋지 않은 코딩스타일이다.<br>

### 1. 매직넘버의 경우 의미를 파악하기 힘들다.
예를들어 입력가능한 문자열 길이가 100자 제한이라고 해보자.<br>
그냥 100으로 했을 땐 의미를 파악하기 힘들다. 하지만 MAX_INPUT_LENGTH라는 변수를 선언해 100이란 값을 넣어주면 파악하기가 더 쉬워진다.<br>
```java
//매직넘버를 사용한 경우
public class MagicNumber {
	public boolean checkLength(String targetStr) {
		return targetStr.length() <= 100;
	}
}

//기호상수를 사용한 경우
public class MagicNumber {
	private static final int MAX_LENGTH = 100;

	public boolean checkLength(String targetStr) {
		return targetStr.length() <= MAX_LENGTH;
	}
}
```

### 2. 매직넘버의 경우 수정이 힘들다.
현재는 문자열의 제한길이가 100이지만 나중에 사양이 변하게되어 200이 될 수도 있다.
100이란 매직넘버의 경우 소스코드 이곳저곳에 박혀있을 수 있다.
그리고 그 100이란 숫자가 항상 문자열의 제한길이라는 보장이없다.
따라서 100이란 숫자를 편집기를 이용해서 전부 200으로 바꿀 수 없고, 일일히 찾아서 바꾸어 주어야 한다.

## Magic Number Refactoring Example
```java
public class RefactoringPrev {
	private final String _name;
	
	public RefactoringPrev(String name) {
		this._name = name;
	}
	
	public void order(int command) {
		if (command ==0) {
			System.out.println(this._name + " walks.");
		} else if (command == 1) {
			System.out.println(this._name + " stops.");
		} else if (command == 2) {
			System.out.println(this._name + " jumps.");
		} else {
			System.out.println("Command eroor. command = " + command);
		}
	}
}
```
위의 코드느느 명령어가 0이면 걷고, 1이면 멈추고, 2이면 점프하는 코드이다.(0,1,2 이외의 코드는 에러)<br>
이때 0, 1, 2 라는 코드는 프로그래머의 임의로 정한 숫자이기 때문에 조건문만 봤을때 어떤 조건인지 유추하기가 힘들다.<br>
실행을 한다고 치면 아래와 같을것 이다.

```java
public class RefactoringPrevTest {
	@Test
	public void test() {
		RefactoringPrev robot = new RefactoringPrev("Prev");
		robot.order(0); //walk
		robot.order(1); //stop
		robot.order(2); //jump
		robot.order(3); //error
	}
}
```