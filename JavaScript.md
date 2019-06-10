

# JavaScript

* JavaScript : 라이브스크립트라는 이름에서 최종적으로 자바스크립트가 되었다. 동적인 웹페이지 제작에 사용되는 언어이며 정적인 웹페이지를 생산하는 HTML을 보완한다. OOP언어로 넷스케이프 -> ECMA로 바뀌면서 오픈언어가 되었다.
* Java : 범용 언어이면서 OOP언어이다. 썬마이크로시스템즈 -> Oracle로 바뀌었다.


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

- 주석 
  - 한줄 주석 
  - 다중 주석 : /* 주석내용 */

---

## 1.2 변수 생성 방법, 데이터 타입

*  변수 생성 방법

  (1) 변수명의 맨 앞에는 숫자가 올 수 없다.

  (2) 영문, _(밑줄 문자), $만 사용 가능하다.

  (3) **대소문자를 구분**한다.

* 데이터타입

​	변수 선언할 때 타입을 제한하지 않는다. 어떤 값을 넣는냐에 따라 타입이 정해진다.

- number

- string : " "(큰따옴표), ' '(작은따옴표) 모두 사용가능하다.

  ```javascript
  v1 = 123; //number
  document.writeln(v1+45+"<br>");	//168
  v1 = '123'; //string
  document.writeln(v1+45+"<br>");	//12345
  ```

- boolean

- null

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

관계 연산자

* A == B : A와 B의 **데이터 값**이 같은지 비교한다.
* A === B : A와 B의 **데이터 형**이 같은지 비교한다.

조건(삼항) 연산자

* (조건식)? A : B; 

논리 연산자

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
  		num%2 == 0 && document.writeln(num+"는 짝수");	//앞의 식이 참이면 두 번째 식 수행
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

  (1) for(int data : array)에서 : 대신 for(int data in array) in을 사용한다.

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
    	document.write(ary5+"<br>"); //100,200,500,600,700,800
    </script>
    ```

---

## 1.6 함수 정의

* 함수 정의 방법

  (1) **선언적 함수** 정의 방법(명시적 함수 정의)

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
  	document.write("result1 : "+result1+", result2 : "+result2+"<br>"); //undefined
  	if(!result1) //true : undefined 값을 boolean값으로 바꾸면 false이다.
  		document.write("리턴값이 없군요!!!");
  	document.write('<hr>');
  	f1(100);
  	f2(100);
  </script>
  ```

  

  (2) **표현식 함수** 정의 방법

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
  		if (Array.isArray(p)) //배열이면 true 아니면 false
  			alert("배열객체 전달!!");
  		else 
  			alert("객체 전달!!");
  	} else if (typeof p == "undefined") {  // p == undefined 와 같이 값만 비교가능 
  		alert("전달된 아규먼트 없음!!");
  	}	
  }
  </script>
  ```

  

  (3) 가변 아규먼트

* 호출시 아규먼트의 갯수가 제한없는 함수를 만들고 싶을 때는 다음과 같이 함수를 정의한다.

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
  	//아규먼트 갯수 : 0
  	//아규먼트 갯수 : 1
  	//아규먼트 갯수 : 2
  	//아규먼트 갯수 : 3
  	//아규먼트 갯수 : 8
  </script>
  ```



* 함수의 아규먼트 처리

    * 아규먼트로 함수 전달하기(=고차함수)

      (1) 방법 : 익명함수, 함수표현식, 함수리터럴 방법

      (2) 방법 : 함수 선언식 활용

      (3) 방법 : 함수를 변수에 담아 사용하는 방법

    * 함수와 메서드의 차이
      * 함수 : 단독으로 호출 가능하다.
      * 메서드 : 객체 생성을 통해 호출 가능하다. 

  ``` javascript
  <script>
    output("둘리");
    output(function (param) {console.log(param);}); //(1)방법
    function myAlert(param){ //(2)방법
    	window.alert(param); //경고창
    } 
    output(myAlert);
    var myAlert2 = function (param){ //(3)방법
    	window.alert(param); //경고창
    }
    output(myAlert2); //myAlert2 함수 자체를 전달하겠다는 것이므로 함수이름만 전달해야한다!!!
    function output(p){ //코드를 읽을 때 함수정의와 전역변수를 제일 먼저 읽는다.
    	if(typeof p == "function")
    		p("ㅋㅋㅋ");
    	else
    		document.write("<h2>ㅋㅋㅋ : "+p+"</h2><br>");
    }
    </script>
  ```

  

---

## 1.7 객체

OBP(Object Based Programming) -> OOP(Object Oriented Programming)

* 객체 생성 방법

  (1) 객체 리터럴

  (2) 생성자 함수 (자바의 클래스와 유사함)

* 객체 리터럴 : 1번만 객체를 만들어 사용할 경우

  {}

  {속성명 : 속성값, 속성명 : 속성값 ...} : 속성값으로는 숫자, 문자열, 논리값, 배열, 함수(메서드)
  * 객체의 멤버 접근 방법

    (1) 멤버 연산자 : .

    (2) 인덱싱 방법 : ['속성명']

    ​	obj.name, obj['name']

    ​	obj.project, obj['project']

    ​	obj.study()

    ​	obj.eat('딸기')

  ``` javascript
  <script src="util.js"></script>
  <script>
  var obj = {
  			name : "듀크", //멤버변수
  			eat : function(food){ //객체 메서드
  			write(this.name+"가 "+food+"를 먹어요.","h3"); //this를 생략해서는 안된다. 
               }  					//this를 사용하지 않으면 window객체의 name을 사용한다...
  		 }
  obj.eat("바나나"); //듀크가 바나나를 먹어요.			
  obj.eat("딸기"); //듀크가 딸기를 먹어요.		
  hr()
  write(typeof obj,"h2"); //Object
  obj.project="자바스크립트";
  obj.study=function(){
  	write(this.name+"는 "+this.project+"를 공부해요.","h3");
  }
  obj.study();
  for(var key in obj){ //key에는 obj가 갖고 있는 속성명(문자열형식)이 대입된다.
  	write(key+ " : "+obj[key],"h3"); // obj[key] 대신 obj.key를 사용하면 객체 obj의 속성 key라는 									    문자열을 찾기에 undefined 오류가 난다.
  }
  delete obj.study; //obj가 가지고 있는 study속성을 없애라는 것이다.
  hr();
  for(var key in obj){ 
  	write(key+ " : "+obj[key],"h3");
  }
  </script>
  ```

  ``` javascript
  //util.js
  function write(content, tag){
  	document.write("<"+tag+">"+content+"</"+tag+">");
  }
  function hr(){
  	document.write("<hr>");
  }
  ```

* 생성자 함수(클래스+생성메서드)

  객체를 초기화하는 역할의 함수이다. (객체를 초기화한다는 것은 비어있는 객체에 멤버를 넣어주는 역할을 말한다.)

  사용방법 : new와 함께 호출된다. (new 다음에 호출하지 않으면 이상해진다...)

  이름을 정할 때 첫 글자를 대문자로 한다. 

* 객체 리터럴 방식과 생성자 함수 방식의 비교

  

* | 객체리터럴 방식                                              | 생성자 함수 방식                                             |
  | ------------------------------------------------------------ | ------------------------------------------------------------ |
  | -객체 리터럴 방식은 하나의 객체만을 만들 수 있게 된다. (싱글톤 객체)<br/>-prototype 속성 사용이 불가하다. | -동일한 속성 사양을 갖는 객체들을 여러개 생성하는 것이 가능하다.<br/>-prototype 속성 사용이 가능하다.<br/>-정적 멤버를 정의할 수 있다.<br/>-캡슐화나 정적 멤버와 같은 OOP 구문을 적용하여 객체를 생성하는 것이 가능하다. |

  

* prototype

  생성자 함수에는 멤버변수 초기화만 구현하고, 프로토타입에는 메서드를 초기화한다.

  객체리터럴 방식은 prototype 속성 사용이 불가하다.

  ``` javascript
  <script>
  function Student(p1,p2,p3,p4){ 
  								this.name = p1, 
  								this.kor = p2, 
  								this.eng = p3,
  								this.math = p4				
  }
  Student.prototype.getSum = function(){ //생성자 함수에 의해서 자동으로 만들어진다.
  	return this.kor+this.eng+this.math;  //메모리 구조를 효율적으로 사용한다.
  };
  Student.prototype.getAvg = function(){
  	return this.getSum()/3; 
  };
  Student.prototype.toString = function(){
  	return this.name+"학생의 총점은 "+this.getSum()+"입니다.";
  };
  
  var student=new Student("둘리", 90, 80, 95);
  var student1=new Student("또치", 80, 90,80);
  var student2=new Student("도우너", 85, 70, 80);
  
  writeColor("학생1 : "+student.toString(),"h3","green"); //객체를 생성하여 메서드 호출 : 객체명.메서드명
  writeColor("학생2 : "+student1,"h3","blue"); 
  writeColor("학생3 : "+student2,"h3","red"); 
  </script>
  ```
  
  

* prototype영역에 넣어서 정의한 메서드와 정적 메서드 차이

  * 메모리 영역에 한 번만 할당한다는 것은 같다.
  * 정적메서드는 this를 사용할 수 없다.
  * 단독으로 수행되어야할 경우 정적메서드로 구현한다.

  ``` javascript
  <script>
  function Area() { //기본적인 생성자함수 구조
  }
  Area.version = '1.0'; //정적속성
  Area.triangle = function(base, height) { //정적메서드
    return base * height / 2;
  }
  Area.diamond = function(width, height) {
    return width * height / 2
  }
  document.writeln('Area클래스의 버전：' + Area.version); //생성자함수 이름으로 멤버변수를 호출한다.
  document.writeln('삼각형의 면적：' + Area.triangle(5, 3));
  var a = new Area();
  document.writeln('마름모의 면적：' + Area.diamond(10, 2));
  document.writeln('마름모의 면적：' + a.diamond(10, 2));
  </script>
  ```



---

## 1.8 주요 API

* **BOM**(Browser Object Model)

  웹 브라우저와 관련된 모든 객체들의 집합을 말한다.

  브라우저가 제공하는 자바스크립트 API

  미리 객체를 생성해서 제공 (브라우저가 기동될 떄 생성해서 제공)

  - window, location, document, history, screen(화면 사이즈, 해상도를 담고 있는 객체), navigator(브라우저에 대한 정보, 플랫폼에 대한 정보를 담고 있는 객체 / 위도, 경도) 

  - window 객체(전역 객체)

    - id = setInterval(func, 초시간) : 주기적으로 함수를 수행시킨다.

      clearInterval(id)

    - id = setTimeout(func, 초시간) : 어떤 시간이 지났을 때 어떤 함수를 1번만 수행시킨다. 주기적인 것은 없다. 

      clearTimeout(id)

    - alert(), confirm(), prompt(), open()

  - location

    - href : 현재 보고있는 페이지의 url 정보를 가지고 있다. 
    - reload() : 현재 페이지를 자동으로 새로고침한다. (href와 reload는 기억하기!)

  - history

    - go(n) : 현재 페이지를 기준으로 전이면

  - screen

    - width
    - height

  - navigator 객체

    웹 브라우저에 대한 정보를 제공하는 객체

    - **user-agent**

    - getLocation() 

      

* **Dom**(Document  Object Model)

  HTML 파서들은 파싱한 HTML 문서 각각의 태그, 태그의 속성, 태그의 텍스트 형식의 컨텐트 

  모두 자바스크립트 객체로 생성한다. (이유 : 자바스크립트에서 HTML태그에 접근가능하도록 지원하기 위해서)

  HTML 태그를 document 객체의 자손 객체로 등록한다.

  (ex) document.body

  ``` javascript
  document.getElementById("id속성값"); //태그에 정의된 id속성, Dom객체 1개 리턴
  
  document.getElementsByClassName("class속성값");  //태그에 정의된 class속성, 배열객체리턴
  
  document.getElementsByTagName("태그명");  
  
  document.getQuerySelector("CSS선택자"); //다양하게 태그를 찾을 수 있다.
  
  document.getQuerySelectorAll("CSS선택자");  
  ```



* 이벤트 핸들러 구현

  * 이벤트 : 웹페이지상에서 발생되는 일

    (1) 브라우저에서 자동으로 발생 (load-렌더링이 끝나면 발생)

    (2) 사용자의 액션에 의해서 발생 (click, mouseover, mouseenter, mouseout, keyin, keyout, keypress, scroll, change, submit, reset 등)

  * 타겟 : 이벤트가 발생된 대상 객체

  * 이벤트 핸들러(리스너) : 이벤트가 발생했을 때 수행되는 코드를 담고 있는 함수

  * 이벤트 모델 : 특정한 타겟에서 정해진 이벤트가 발생했을 때 핸들러가 수행되도록 구현하는 방법

    (1) 인라인 이벤트 모델(지역방식) 

    (2) 고전 이벤트 모델(전역방식)

    (3) 표준 이벤트 모델(전역방식)  
    
    

* 인라인 이벤트 모델(지역방식) 

  태그의 속성으로 등록 : onXXX = "이벤트 핸들러 코드"

  (ex) onclick(onClick, onCLICK) = "수행문장1;수행문장2;수행문장3;..."

  

* 고전 이벤트 모델(전역방식)

  DOM객체를 찾는다.

  DOM객체.onxxx(반드시 소문자) = 함수;

  DOM객체.onxxx(반드시 소문자) = null; //고전 이벤트 모델을 해제한다.

  

* 표준 이벤트 모델(전역방식)  

  DOM객체를 찾는다.

  DOM객체.addEventListner("이벤트이름", 함수)

  DOM객체.removeEventListner("이벤트이름", 함수) //표준 이벤트 모델을 해제한다.
  
  

---

## 1.9 HTML5 API

* **Canvas API**

  웹 페이지에 그림을 그릴 수 있도록 지원하는 HTML5 API이다.

  (1) arc(x,y,r,startAngle, endAngle, anticlockwise) : anticlockwise가 true면 반시계방향, false면 시계방향으로 그린다.
  
  (2) drawImage(image, sx, sy, sWidth, sHeight, dx, dy, dWidth, dHeight) : 이미지를 잘라서 출력한다.
  
  (3) createLinearGradient(x1, y1, x2, y2) : 선형그라디언트 객체를 생성한다.
  
  (4) createRadialGradient(x1, y1, r1, x2, y2, r2) : 원형그라디언트 객체를 생성한다.
  
  (5) save() : 캔버스의 상태정보를 스택에 저장한다.
  
  (6) restore() : 스택에 저장된 상태 정보를 읽어온다.
  
  (7) scale(x, y) : 도형의 크기를 조정한다.
  
  (8) globalCompositeOperatio : 원본(먼저 그린 도형) 도형과 대상(나중에 그린 도형) 도형의 겹쳐진 형태에 따른 표시 방법을 정의한다.
  
  (9) **toDataURL()** : canvas 태그 영역의 모든 내용을 png 형식의 URL 문자열로 변환하여 리턴한다. 

  ​						storage에는 텍스트형식으로만 저장이 가능하다.

* **Web Storage API**

  웹 브라우저에 자료를 저장하기 위한 기능을 지원하는 API로 로컬스토리지와 세션스토리지로 나뉜다.

  * **Local Storage** : 저장하려는 데이터를 영구 보관한다. 
  * **Session Storage** : 저장하려는 데이터를 브라우저가 종료될 때까지 보관한다.
  * W3C는 Same Origin Policy(동일 출처 정책)에 따라 도메인당 5MB를 권장하고 있으며 추가 용량이 필요한 경우 사용자의 동의를 얻어 용량을 확장할 수 있다.(초과시 QUOTA_EXCEEDED-ERR 발생)

  * window.localStorage 와 window.sessionStorage 의 주요 멤버

    (1) **length** : 스토리지에 저장된 key, value 쌍의 개수를 추출한다.

    (2) **key(index)** : 숫자형 인덱스에 해당하는 key를 리턴한다.

    (3) **getItem(key)** : 스토리지로부터 key에 해당하는 value를 **추출**한다.

    (4) **setItem(key, value)** : 스토리지로부터 key에 해당하는 value를 **저장**한다.

    (5) **removeItem(string key)** : 스토리지 key에 해당하는 value를 **제거**한다.

    (6) **clear()** : 현재 스토리지의 모든 데이터를 **제거**한다.

    (7) **onstorage**: **로컬스토리지**의 내용이 변경될 때마다 이벤트이다. **StorageEvent** 객체가 생성된다.

    ​	[StorageEvent 객체의 주요 속성]

    		- key : 추가,삭제,변경된 키 이름
    		- oldValue : 업데이트되기 전의 값, 새로 추가된 값이면 **null**
    		- newValue : 새로 업데이트된 값, 기존 값을 삭제한 경우에는 **null**
    		- url : 변경사항이 발생된 페이지의 URL

  * <https://www.caniuse.com/> : Opera Mini를 제외한 웹,앱 브라우저에서 WebStorage API를 지원한다는 것을 확인할 수 있다.

  * 크롬 - 개발자 도구 - Application - Local Storage : 저장한 데이터를 확인할 수 있다.

    Local Storage에 저장된 데이터는 localhost:8000번 페이지에서만 공유해서 사용할 수 있다.

* **Drag&Drop API**

  마우스를 사용하여 애플리케이션 간에 파일이나 애플리케이션의 데이터를 전달,복사하는 기능을 하는 API이다.

  사용자 편의를 고려한 UI기능을 한다.

  * 드래그할 수 있는 대상 : 클라이언트의 외부파일, 웹페이지 상의 컨텐트 (HTML5는 2가지 모두 지원한다.)
  * \<img> element는 디폴트로 draggable 속성의 값이 true이다.
  * 다른 엘리먼트는 draggable 속성의 값을 true로 지정하면 드래그가 가능한 소스객체가 된다.

  * Drag&Drop 관련 이벤트

    | 드래그가 가능한 대상(소스 객체) | 드롭이 가능한 영역(타겟 객체) |
    | ------------------------------- | ----------------------------- |
    | dragStart 이벤트                | dragenter 이벤트              |
    | dragend 이벤트                  | dragleave 이벤트              |
    | drag 이벤트                     | dragover 이벤트               |
    |                                 | drop 이벤트                   |

---

## 1.10  HTML5 부터 추가된 속성

* **contenteditable** 속성

  요소(Element)를 편집 모드로 변경하는 기능을 제공한다. 모든 태그에서 사용가능하다.

  설정값
  • true : 요소 편집 가능 상태
  • false : 요소 편집 불가능 상태
  • inherit : 부모 요소의 값 상속. 즉, 부모가 편집 가능하다면 이 요소도 편집 가능(디폴트)

  

---

# Ajax (Asynchronous Javascript and xml)

* **GML**(Geography Markup Language)(IBM에서 만듬 : 출판문서 작성용도로 사용)

  ---> GML을 표준화시켜 만든 것이 **SGML**(Standard Generalized Markup Language)이다.

  ​	  (표준 : 출판뿐만 아니라 규격문서를 작성하는 범용용도로 사용)

  ---> **HTML**(웹페이지 제작용도) - 태그가 정해져 있음

  ---> **XML**(Extensible Markup Language)(다목적 규격화된 문서 작성용) - 직접 태그 정의

  ​	   <태그명>...<태그명/>  : 종료태그를 반드시 명시해야한다.

  ​	   <태그명/>

  ​	   <태그명 속성명="속성값">

* XMLHttpRequest 객체

  서버 측과의 비동기 통신을 제어한다.

  XMLHttpRequest 객체 생성 : new XMLHttpRequest()

  * open( ... ) : HTTP 요청을 초기화한다.

  * send([body]) : HTTP 요청을 송신한다.

  * onreadystatechange : 통신 상태가 변화된 타이밍에 호출되는 이벤트 핸들러이다.

    readyState 값

    | 반환값 | 설명                                                         |
    | ------ | ------------------------------------------------------------ |
    | 0      | 미초기화(open메서드가 호출되지 않음)                         |
    | 1      | 로드 중(open메서드가 호출됨, send메서드는 호출되지 않음)     |
    | 2      | 로드 완료(send 메서드가 호출됨, 응답스테이터스/헤더는 미취득) |
    | 3      | 일부 응답을 취득(응답스테이터스/헤더만 취득, 본체는 미취득)  |
    | 4      | 모든 응답데이터를 취득 완료                                  |

    

  * status : HTTP Status코드를 취득한다.

    ``` javascript
    function requestAjax() { //페이지 이동없이 데이터를 받아온다.
    	var req = new XMLHttpRequest();
    	var result = document.getElementById("result");
    	req.onreadystatechange = function() {		
    		alert("req.readyState : "+req.readyState);       
    		if(req.status == 200 && req.readyState == 4) 
             	//readyState 값 200은 서버로부터 응답이 성공적으로 왔다는 것이다.
                //readyState 값 4는 서버로부터 응답이 다왔다는 것이다.
    			result.innerHTML += req.responseText; 
    	}	
    	req.open("GET", "content/sample.txt", true); //true : 비동기 통신방식으로 보내겠다는 것이다.	
    	req.send(); 	
    }
    ```

  * [ XMLHttpRequest 객체에서 제공되는 이벤트 관련 속성 ]

    - onloadstart

    - onprogress

    - onabort

    - onerror

    - onload

    - ontimeout

    - onloadend : 항상 마지막에 발생하는 이벤트이다.

    - onreadystatechange

      

* **JSON**(JavaScript Object Notation)

  인터넷에서 자료를 주고 받을 때 그 자료를 표현하는 방법이다.

  ``` javascript
  <script>
  window.onload = function() {
  	setInterval(function() { //폴링 - 주기적으로 서버한테 요청해서 데이터를 받아오는 기술이다.
  		var request = new XMLHttpRequest(); //이용시간이 많을 때 더 자주 받아온다.
  		request.onload = function(event) {
  			if (request.status == 200) {
  				var str = request.responseText;
  				var obj = JSON.parse(str);
  				var target = document.getElementById('news');
  				target.innerHTML = obj.news;
  			}
  		};
  		request.open('GET', 'content/newsjson.jsp', true);
  		request.send();
  	}, 2000);
  };	
  </script>
  ```



* Same Origin Policy(SOP)

  브라우저에서 보안상의 이슈로 동일 사이트의 자원(Resource)만 접근해야 한다는 제약이다.

  

* Cross Origin Resource Sharing(CORS)

  ``` javascript
  response.addHeader("Access-Control-Allow-Origin", "*");
  ```

  Origin이 아닌 다른 사이트의 자원을 접근하여 사용한다는 의미이다. 따라서 ajax로 직접 요청해서 가져올 수 있다.