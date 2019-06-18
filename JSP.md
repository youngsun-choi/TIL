# JSP(JavaServer Pages)

HTML 또는 XML 기반의 동적인 웹 콘텐츠를 개발하는 기술이다. Servlet과 JSP 모두 웹서버단에서 수행되는 기술이라는 것은 동일하지만 구현방식이 다르다. Sevlet은 상속구문, 메서드 오버라이딩 구문 등을 적용한 완전한 Java 프로그래밍이고 JSP는 정적인 내용은 HTML 또는 XML 기술로 작성하고, 동적인 내용은 JSP 태그와 스크립트 코드(Java 언어)로 작성하는 기술이다.

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

  ex) **<%=      >** : 표현식 태그이다. 주어진 식의 수행결과를 출력한다. 식만 올 수 있다. if문은 안된다!! 

  ​						표현식 태그에는 식만 올 수 있으므로 ;는 넣을 수 없다. 

  ​						<%= num  %> 가 servlet으로 바뀔 때 out.print(num);로 바뀌어 표현식 태그 안의 값이 out.print의 아규먼트로 바뀐다.  Servlet으로 변환될 때  표현식 태그는 out.print로 표현되고 나머지는 out.write로 표현된다.

  ​	 **<%       %>** : 수행문 태그이다. 수행만 하고 결과를 출력하지 않는다. Servlet으로 변환될 때 수행문 코드는 그대로 들어간다. 

  ​	 **<%!      %>** : 선언문 태그이다. 멤버변수를 선언, 메서드를 정의한다.

  ​	 **<%@   %>** : 지시자 태그이다. **jsp는 최초 요청시 servlet으로 바뀌는데** 톰캣 안에 있는 자스퍼라는 엔진이 바꿔준다. ex) <%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

  ​	 **<%--  --%>** : 주석태그이다. (HTML 주석태그 : <!-- -->, Java 주석태그 : // 또는 /* */)

* **액션 태그**

  \<jsp:useBean ..../>

  \<jsp:forward ..../> 

  <jsp:include ...../> : 다른 jsp결과를 포함해서 결과를 출력할 때 사용한다.

  <jsp:setProperty ..../>

  <jsp:getProperty ..../>

  속성값에는 " "를 주고 empty tag 즉 종료태그가 없을 때는 '/'로 닫아주어야한다.

* **커스텀 태그**

  필요에 의해 개발자가 직접 만든 태그이다.

  JSTL : Tomcat에서 만든 커스텀태그이다. ex) corelibrary, xmllibary

## 1.2 JSP 내장객체

<%= request.getParameter("stname")  %> //request는 내장객체로 선언하지 않아도 사용할 수 있다.

<li><%= session.isNew()  %></li>
<li><%= application.getServerInfo()  %></li>