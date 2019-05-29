# JavaScript

​	Java : 범용 언어이다. OOP언어이다. 썬마이크로시스템즈 -> Oracle

​	JavaScript : 동적인 웹페이지 제작에 사용되는 언어이다. OOP언어이다. 넷스케이프 -> ECMA(오픈언어가 되었다.)    정적인 웹페이지를 생산하는 HTML을 보완하는 프로그래밍 언어이다. 라이브스크립트라는 이름이었다.

css와 동일하게 HTML

## 1.1 JavaScript 구문 정리

- 데이터 타입, 변수 생성 방법
- 연산자
- 제어문
- 배열
- 함수 - 객체 상관없이 호출한다.
- 객체 생성
  - 객체 리터럴
  - 클래스
- 주요 API - 내장함수, 내장객체, BOM, **DOM**

- 주석 : 
  - 한줄 주석 
  - 다중 주석 : /* 주석내용 */

## 1.2 자바스크립트의 데이터 타입

자바스크립트는 변수 선언할 때 타입을 제한하지 않는다. 어떤 값을 넣는냐에 따라 타입이 정해진다.

- number

- string 

  ```javascript
  v1 = 123;
  document.writeln(v1+45+"<br>");	//168
  v1 = '123';
  document.writeln(v1+45+"<br>");	//12345
  ```

- boolean

- undefined : 타입명으로도 쓰이고 값으로도 쓰인다.

- object

- function

  ```javascript
  //자바스크립트의 데이터타입 체크(1)
  <script>
  	document.write("<h2>"+typeof 100+"</h2>");	//number
  	document.write("<h2>"+typeof 3.14+"</h2>");	//number
  	document.write("<h2>"+typeof '가'+"</h2>");	//string
  	document.write("<h2>"+typeof "abc"+"</h2>"); //string
  	document.write("<h2>"+typeof '100'+"</h2>"); //string
  	document.write("<h2>"+typeof true+"</h2>"); //boolean
  	document.write("<h2>"+typeof undefined+"</h2>"); //undefined
  </script>
  
  //자바스크립트의 데이터타입 체크(2)
  <script>
      var v1;
  	document.write("<li>"+v1+"</li>");	//undefined - 값으로 쓰임
  	document.write("<li>"+ typeof v1+"</li>");	//undefined - 타입으로 쓰임
  	document.write("<li>"+(v1+10)+"</li>");	//undefined -> NaN(Not a Number)이 나온다!!
  	v1 = 100;
  	document.write("<li>"+v1+"</li>");	//100
  	document.write("<li>"+ typeof v1+"</li>");	//number
  	document.write("<li>"+(v1+10)+"</li>");	//110
  	v1 = true;
  	document.write("<li>"+v1+"</li>");	//true
  	document.write("<li>"+ typeof v1+"</li>");	//boolean
  	document.write("<li>"+(v1+10)+"</li>");	//true -> 11 - true면 1 false면 0으로 바뀐다.
  	v1 = "가나다";
  	document.write("<li>"+v1+"</li>");	//가나다
  	document.write("<li>"+ typeof v1+"</li>");	//string
  	document.write("<li>"+(v1+10)+"</li>");	//가나다10
  </script>
  ```

## 1.3 자바스크립트의 연산자

* 식1&&식2&&식3

* 식1||식2||식3

  ``` javascript
  <script>
      /* 연산결과가 true 아니면 false가 된다. */ 
  	/* pre태그로 묶어주면 writeln의 개행문자가 줄바꿈 기능을 갖게 된다. */
  	document.writeln(10>5);	//true	
  	document.writeln("abc">"ABC");	//true - 다른 문자부터 비교한다.
  	var str="가나다";
  	document.writeln(str == "가나다");
  	document.writeln(true == 1);	//true -> true를 1로 변환해서 비교한다.
  	document.writeln("100" == 100);	//true -> string으로 형변환해서 비교한다.
  	document.writeln(true === 1);	//false
  	document.writeln("100" === 100);	//false
  	/* 산술연산자 */
  	document.writeln(10/3);	//3.333... -> 자바스크립트는 실수로 만든다.
  </script>
  
  <pre>
      <script>	/* if문과 삼항 연산자를 쓰지 않고 출력할 수 있다. */
      	var num=5;
  		//num이 짝수이면 "xx는 짝수"
  		//num이 홀수이면 "xx는 홀수"
  		num%2 == 0 && document.writeln(num+"는 짝수");	
  		/* and는 앞의 식이 참이어야 두 번째 식을 수행한다.  */
  		num%2 == 0 || document.writeln(num+"는 홀수");	
  		/* or는 앞의 식이 거짓이어야 두 번째 식을 수행한다. */	
      </script>
  </pre>
  ```

  

* 브라우저 : GUI(Graphic User Interface) 모드 제공



