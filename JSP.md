# JSP(JavaServer Pages)

**HTML 또는 XML 기반의 동적인 웹 콘텐츠를 개발하는 기술**이다. Servlet과 JSP 모두 웹서버단에서 수행되는 기술이라는 것은 동일하지만 구현방식이 다르다. Sevlet은 상속구문, 메서드 오버라이딩 구문 등을 적용한 완전한 Java 프로그래밍이고 JSP는 정적인 내용은 HTML 또는 XML 기술로 작성하고, **동적인 내용은 JSP 태그와 스크립트 코드(Java 언어)로 작성**하는 기술이다.

* 공부순서

  (1) JSP 태그

  (2) JSP 내장객체

  

* 시간출력

  * javascript : 클라이언트 시간
  *  jsp&java : 서버 시간



## 1.1 JSP 태그

* **스크립트 태그**

  필요한 자바코드를 정의하는 용도의 태그이다. Servlet으로 변환될 때 try-catch문으로 표현된다.

  * C:\yschoi\eclipse\workspace\.metadata\.plugins\org.eclipse.wst.server.core\tmp0\work\Catalina\localhost\sedu\org\apache\jsp (Servlet으로 변환된 코드를 확인할 수 있다.)

  ex) **<%=      >** : **표현식 태그**이다. 주어진 식의 수행결과를 출력한다. 식만 올 수 있다. if문은 안된다!! 

  ​						표현식 태그에는 식만 올 수 있으므로 **;는 넣을 수 없다.** 

  ​						<%= num  %> 가 servlet으로 바뀔 때 out.print(num);로 바뀌어 표현식 태그 안의 값이 out.print의 아규먼트가 된다.  Servlet으로 변환될 때  표현식 태그는 out.print로 표현되고 나머지는 out.write로 표현된다.

  ​	 **<%       %>** : **수행문 태그**이다. 수행만 하고 결과는 출력하지 않는다. Servlet으로 변환될 때 수행문 코드는 그대로 들어간다. 

  ​	 **<%!      %>** : **선언문 태그**이다. 멤버변수를 선언, 메서드를 정의한다.

  ​	 **<%@   %>** : **지시자 태그**이다. **jsp는 최초 요청시 servlet으로 바뀌는데** 톰캣 안에 있는 자스퍼 엔진이 바꿔준다. 					ex) <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

     - <%@ page
       [ language="java" : 사용할 언어
       [ extends="package.class" ] : 상속하는 부모
       **[ import="{package.class | package.*}, ..." ]** : 여러번 반복해도 상관없다. 

       ​																			ex) import = "java.util.*, java.io.File"
       **[ session="true|false" ]** : 디폴트는 true이다. 따라서 session객체가 자동으로 준비된다.
       [ buffer="none|8kb|sizekb" ] : 출력버퍼의 사이즈를 조절한다. 디폴트는 8kb이다. 버퍼가 꽉차면 자동으로 flush가 일어난다.
       [autoFlush="true|false" ] : 버퍼가 꽉차면 자동으로 flush가 일어나는 기능이다. 
       **[ errorPage="relativeURL" ]** : relativeURL은 동일한 웹 어플리케이션에 있는 페이지만 사용가능하다.
       **[ contentType="mimeType [ ; charset=characterSet ]" |"text/html ; charset=ISO 8859 1" ]** : 디폴트는 charset=ISO 8859 1이다. 따라서 UTF-8로 인코딩해주어야한다.

       **[ isErrorPage="true|false" ]** : exception 내장객체를 통해 오류를 출력할 수 있다.
       **[ pageEncoding="characterSet | ISO8859 1" ]** : 디폴트는 charset=ISO 8859 1이다. 따라서 UTF-8로 인코딩해주어야한다.
       [ isELIgnored="true|false"]
       %>

  ​	 **<%--  --%>** : 주석태그이다. (HTML 주석태그 : <!-- -->, Java 주석태그 : // 또는 /* */)

  * **<%@  include  file="part1.jspf"  %>** : 반복되는 부분을 .jspf(JSP Fragment)로 저장하여 JSP 페이지에 불러 사용한다. 다른 jsp결과를 포함해서 결과를 출력할 때 사용한다.

* **액션 태그**

  \<jsp:useBean ..../>

  \<jsp:forward page=""/> : 다른 jsp page로 이동한다. 

  **<jsp:include ...../>** : **수행자체는 별개로 이루어지고 출력버퍼는 공유**한다. JSP 페이지의 수행 결과 내에 다른 자원의 내용 또는 수행결과를 포함시킨다.

  \<jsp:param name="" value=""/> : 전달할 데이터를 id name값을 가지고 value값을 전달한다. 

  <jsp:setProperty ..../>

  <jsp:getProperty ..../>

  속성값에는 " "를 주고 empty tag 즉 종료태그가 없을 때는 '/'로 닫아주어야한다.

* **커스텀 태그**

  필요에 의해 개발자가 직접 만든 태그이다.

  JSTL : Tomcat에서 만든 커스텀태그이다. ex) corelibrary, xmllibary

### include 지시자와  include 액션태그의 차이점

cf) exam9.jsp --- part1.jspf, part2.jspf : **include 지시자** ---> 서블릿 소스의 개수? **1개** (소스를 포함해서 수행되므로)

exam11.jsp --- greeting.jsp 3번 : **include 액션태그** ---> 서블릿 소스의 개수? **2개** (exam11과 greeting은 각각 수행되므로)

## 1.2 JSP 내장객체

* <%= request.getParameter("stname")  %> : request는 내장객체로 선언하지 않아도 사용할 수 있다.
* <% out.print();  %> 
* <%= session.isNew()  %>
* <%= application.getServerInfo()  %>
* <% String msg = "오류 원인 : " + exception; %> : <%@ page isErrorPage="true" %>인 jsp 페이지에서만 사용가능하다.

요약 정리

서버가 클라이언트를 찾아오는 일은 절대 없다!! HTTP 프로토콜은 **Connection Oriented**(접속이 먼저 이루어져야 통신한다.) 와 **Stateless 방식**으로 동작한다. 신뢰성있는 통신을 하면서도 처리 효율이 좋다. 클라이언트와 서버는 계속 연결되어있는 것이 아니고 클라이언트가 계속 새로운 요청을 하는 것이다. Cache 기술을 써서 이전에 방문했던 주소를 기억한다.

HTTP에는 다양한 요청 방식(GET,HEAD,POST,OPTIONS,DELETE,PUT)이 있다. GET방식은 요청헤더와 요청바디로 구성된다. POST방식은 쿼리문자열을 요청바디에 넣어 전송한다. 쿼리문자열에 타입을 원하는대로 부여할 수 있어 파일을 요청하고자 하는 경우에 사용한다. 

JSP 파일은 WAS에 의해 Servlet파일로 변경된다. 컨테이너에 의해 관리되는 프로그램을 **웹 컴포넌트**라고 한다.

Assembly Root는 WebContent이다. WEB-INF는 클라이언트가 직접적으로 접근할 수 없는 폴더이다. 나중에 JDBC라이브러리를 넣을 것이다. 웹 어플리케이션의 디렉토리 구조는 다른 서버를 사용해도 같다.

MVC패턴은 요청받는 부분(servlet)(Controller)과 응답하는 부분(jsp)(View)으로 나눈다.

**Servlet은 하나의 Servlet 객체를 공유해서 수행한다!!!**

같은 서버에 같은 프로그램이면 **Forward**를 사용한다. jsp는 get과 post를 구분하지 않고 브라우저가 끝날 때까지 유지된다.



## 1.3 요청 동안의 객체공유방법

(1) **HttpServletRequest 객체**에 저장하여 전달하는 방법 : **request scope**를 사용한다. 요청이 끝날 떄 까지 사용, **가장 많이 사용한다.** 요청이 끝나면 사라진다.

(2) **HttpServletSession 객체**에 저장하여 전달하는 방법 : **session scope**를 사용한다. session 객체가 유지되는 동안  																							ex) 쇼핑카트에 물품보관

(3) **ServletContext 객체**에 저장하여 전달하는 방법 : **application scope**를 사용한다. 서버가 죽을 때 까지 																					ex) **모든 클라이언트에 의해 공유**되는 데이터를 저장할 때 사용한다.

cf) **page scope는 공유가 불가**하다.

위의3 방법은 아래 3가지 메서드를 갖고 있다.

setAttribute(이름,객체)

getAttribute(이름)

removeAttribute(이름)

배열, 문자열

이름, 번호, 나이, 주소 ---> 여러개의 객체를 보낼 때는 **VO(Value Object), DTO(Data Transfer Object) 클래스**를 생성하여 전달한다.

``` java
class MyDataVO{
    String name;
    int number;
    int age;
    String address;
}
```



## MVC(Model-View-Controller)

모델-뷰-컨트롤러(Model–View–Controller, MVC)는 소프트웨어 공학에서 사용되는 아키텍처 패턴이다.

* Model : vo,dto

  어플리케이션의 정보를 담당한다.

  * 도메인 모델 ex) VO
  * 서비스 모델 ex)...SERVICE,...BIZ

* view : jsp

  사용자 인터페이스 요소를 담당한다.

* controller : servlet

  어플리케이션 기능을 담당한다.