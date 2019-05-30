

# JavaScript

* JavaScript : 라이브스크립트라는 이름에서 최종적으로 자바스크립트가 되었다. 동적인 웹페이지 제작에 사용되는 언어이며 정적인 웹페이지를 생산하는 HTML을 보완한다. OOP언어로 넷스케이프 -> ECMA로 바뀌면서 오픈언어가 되었다.
* Java : 범용 언어이면서 OOP언어이다. 썬마이크로시스템즈 -> Oracle로 바뀌었다.

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

---

## 1.2 데이터 타입

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

- undefined : 타입명 또는 값으로 쓰인다.

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
  	document.write("<li>"+(v1+10)+"</li>");	//NaN(Not a Number)이 나온다!!
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

---

## 1.3 연산자

* A == B : A와 B의 데이터 값이 같은지 비교한다.

* A === B : A와 B의 데이터 형이 같은지 비교한다.

* 식1&&식2&&식3

* 식1||식2||식3

  ``` javascript
  <script>
      /* 연산결과가 true 아니면 false가 된다. */ 
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
  
  <pre> /* pre태그로 묶어주면 writeln의 개행문자가 줄바꿈 기능을 갖게 된다. */
      <script> //if문과 삼항 연산자를 쓰지 않고 출력할 수 있다. 
      	var num=5;
  		//num이 짝수이면 "xx는 짝수"
  		//num이 홀수이면 "xx는 홀수"
  		num%2 == 0 **&&** document.writeln(num+"는 짝수");	//앞의 식이 참이면 두 번째 식 수행
  		num%2 == 0 || document.writeln(num+"는 홀수");	//앞의 식이 거짓이면 두 번째 식을 수행	
      </script>
  </pre>
  ```
  
  
  
* 브라우저 : GUI(Graphic User Interface) 모드 제공

---

## 1.4 제어문

* for, while, do~while, if, switch, break, continue
* **0, null, undefined** : **false로 간주**된다. ex) if(num % 2) 의 값이 1이면 true 0이면 false이다.

## 1.5 배열

* 배열 생성 방법

  (1) 배열 리터럴 : var 변수명 = **[값1, 값2, 값3 ... 값n]**;

  (2) 표준 API로 객체를 생성하여 만드는 방법 : **Array()** 라는 생성자 함수 활용(java의 class와 비슷)

  ​																		  var 변수명 = new Array(값1, 값2, 값3 ... 값n);

* 특징

  (1) 하나의 배열에 저장되는 데이터 타입의 제한이 없다. ex) var array=[10, '가나다', true, 3.5]

  (2) 배열이 생성된 이후에도 배열의 크기를 변경할 수 있다. (java의 arrayList와 비슷)

  (3) 인덱스는 0부터 시작한다.

  (4) length 라는 속성을 사용하여 배열의 크기를 알 수 있다.

* 배열 리터럴

  ``` javascript
  <script>
  	var a1 = [];
  	document.write("<h3>"+typeof a1+"</h3>"); //object
  	document.write("<h3>"+Array.isArray(a1)+"</h3>"); //true 
  	document.write("<h3>"+ a1.length +"</h3>"); //0
  	document.write("<h3>"+a1[0]+"</h3>"); //undefined
  </script>
  ```

* Java enhanced for문과의 차이

  (1) : 대신 in을 사용한다.

  (2) undefined 값은 무시하고 유효한 값만 출력한다.

  (3) 원소값이 아닌 인덱스값을 가져온다. (이유 : 일반 자바스크립트 객체에서도 사용 가능하기 때문이다.)

  ``` javascript
  <script>
  	a1[4] = 100; //방 5개를 만든다.
  	document.write("<h3>"+ a1.length +"</h3>");	//5
  	for(var i=0;i<a1.length;i++)
  		document.write("<h4>"+ a1[i] +"</h4>");	//1~4 방은 값이 없으므로 undefined가 출력된다. 
  	for(var i in a1) //enhanced for문	
  		document.write("<h4>"+ a1[i] +"</h4>");
  	var a2 = [10, '가나다', true, 3.5];
  	for(var i in a2)	
  		document.write("<h4>"+ typeof a2[i]+" : "+a2[i] +"</h4>");
  </script>
  ```

* Array() 생성자 함수 이용한 배열 생성

  ``` javascript
  <script>
      var a1 = new Array(); //[ ]
  	var a2 = new Array(10);	//배열의 크기
  	var a3 = new Array('가'); //원소값
  	var a4 = new Array(10,20); //원소값
  	var a5 = new Array(1,2,3,4,5); //원소값
  </script>
  ```

* 배열 객체의 주요 메서드 

  배열 객체와 관련된 다양한 메서드를 갖고 있다. [w3schools-배열객체 메서드](<https://www.w3schools.com/jsref/jsref_obj_array.asp>)

  * **sort()** : 기본 문자열 기반의 정렬을 한다.

    ``` javascript
    var ary=[30,11,5,27,9];
    	document.write(ary+"<br>");
    	var ary2=ary.sort(function(a, b){return a-b;}); //숫자기반의 오름차순 정렬을 해준다.
    	document.write(ary+"<br>");
    	document.write(ary2+"<br>");
    ```

  * **push()** : 배열의 끝에 값을 넣는다.

    ``` javascript
    <script>
    var ary5=[]; 
    	ary5.push(100);
    	ary5.push(200);
    	ary5.push(500);
    	ary5.push(600,700,800);
    	document.write(ary5+"<br>");
    </script>
    ```

---

## 1.6 함수 정의

* 함수 정의 방법

  (1) 선언적 함수 정의 방법(명시적 함수 정의)

  ​		function myFunction([매개변수 리스트]){

  ​					:

  ​			[return 리턴값]

  ​		}

  ​		리턴값 없이 리턴했을 경우 : undefined 가 리턴된다.

  

  - 사용방법

  ​		함수명();

  ​		var v = 함수명();

  ​		함수명(아규먼트리스트);

  ``` javascript
  <script>
  	function f1(){
  		document.write("f1() 호출<br>");
  	} 
  	function f2(p1, p2){
  		document.write('f2() 호출 : '+(p1+p2)+'<br>');
  	} 
  	f1();
  	f2(10,20); // argument를 주지 않으면 NaN값을 출력한다.
  	document.write('<hr>');
  	var result1=f1();
  	var result2=f2(100,200);
  	document.write("result1 : "+result1+", result2 : "+result2+"<br>");
  	if(!result1) //true : undefined 값을 boolean값으로 바꾸면 false이다.
  		document.write("리턴값이 없군요!!!");
  	document.write('<hr>');
  	f1(100);
  	f2(100);
  </script>
  ```

  

  (2) 표현식 함수 정의 방법

  ​		function([매개변수 리스트]){

  ​					:

  ​		}

  * 사용방법

  ​		var 함수명 = function ([매개변수리스트]){

  ​							 }

  ​		f1(function () {..........} )		

  ``` javascript
  <script>
  function clickProcess(p) {
  	if (typeof p == "number") { //""인용부호를 써서 문자열형식으로 비교해야한다. 
  		alert("숫자 전달!!");
  	} else if (typeof p == "string") {
  		alert("문자열 전달!!");
  	} else if (typeof p == "boolean") {
  		alert("논리값 전달!!");
  	} else if (typeof p == "function") {
  		alert("함수 전달!!");
  	} else if (typeof p == "object") {
  		if (Array.isArray(p))
  			alert("배열객체 전달!!");
  		else 
  			alert("객체 전달!!");
  	} else if (typeof p == "undefined") {  // p == undefined 
  		alert("전달된 아규먼트 없음!!");
  	}	
  }
  </script>
  ```

* 

* 호출시 아규먼트의 갯수가 제한없는 함수를 만들고 싶을 때는 

  function out() {

  ​	arguments //지역변수

  }

  함수가 호출되는 시점에 arguments라는 지역변수가 자동으로 초기화된다.

  함수 호출시 전달되는 아규먼트들을 유사배열 객체에 담아서 arguments 변수에 할당한다.

  

  ``` javascript
  <script>
  	function out(){
  		document.write("아규먼트 갯수 : "+arguments.length+"<br>");
  		for(var i=0;i<arguments.length;i++)
  			console.log(arguments[i]);
  		console.log("-------------------------------------------");
  	}
  	out(); out(10); out(10,20); out('a','b','c'); out(1,2,3,4,5,6,7,8);
  </script>
  ```

  





