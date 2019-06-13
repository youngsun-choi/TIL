```
Web Client & Web Server에서 다루는 언어
web Client : ex) Browser HTML, CSS, Javascript, Ajax, jQuery

Web Server : Servlet(java로 구현하는 web server 프로그램), JSP, MVC패턴(servlet과 jsp를 함께사용), 				MyBatis, Spring Ioc, Spring MVC
```

# Servlet 프로그래밍

Servlet이란 **Java 언어**로 구현하는 웹 서버 프로그래밍 기술이다. 초기 웹 서버 프로그래밍 표준 기술은 CGI(Common Gateway Interface)였다. 언어로는 C, VisualBasic, Perl을 사용한다. CGI는 멀티프로세스 방식으로 처리하여 메모리를 많이 사용하는 단점을 가졌고 이러한 단점을 보완하기 위해 FastCGI가 나왔다. 후에 구현하기 어려운 FastCGI의 단점을 보완하기 위해 1998년 9월에 Servlet()이 나왔다. Servlet은 멀티스레드 방식으로 처리한다. 즉 하나의 실행프로그램을 공유해서 수행한다.

* 구조

  CGI, FastCGI 						Servlet -> JSP

  ​									  **Servlet 엔진(컨테이너)**

   Web Server							Web Server

  Tomcat : Web Server + Servlet Container -> **WAS**(Web Application Server)

  

* Servlet 등록과 매핑

  * Url mappings을 사용하는 이유 : 대부분의 웹 자원들은 파일의 확장자로 파일의 종류를 구분하지만 Servlet의 경우에는 불가능하기 때문이다. Servlet의 경우에는 컴파일을 통해서 .class 확장자를 갖는데 이미 Java Applet에서 사용하고 있어 사용할 수가 없다.

* Servlet 정의 애노테이션 : @WebServlet (Servlet 3.0부터 추가)