# 웹 프로그래밍

## 공부 순서

* 웹 클라이언트 
  1. HTML
  2. CSS
  3. JavaScript
  4. Ajax //자바스크립트 언어활용
  5. HTML5 주요 API //자바스크립트 언어활용

* 웹 서버 
  1. Servlet & JSP
  2. Spring FrameWork : Servlet & JSP를 규격화한 서버 기술 (Spring MVC)
  3. MyBatis : jdbc를 세련되게 코딩할 수 있다. //하이버네이트도  있음.
* 웹기반 시각화 : D3.js //자바스크립트 언어활용
* 오픈 API : 네이버 또는 구글, 업그레이드가 자주 된다. //자바스크립트 언어활용

---

## 설치 프로그램

* 웹서버 - Tomcat(Web Application Server : WAS) :
  *  [설치주소: tomcat.apache](<http://tomcat.apache.org/>) 
    * 32-bit/64-bit Windows Service Installer(pgp,sha512)
    * hostmanager, example check : 체크하나 안하나 상관없다.
    * HTTP/1.1 Connector Port : 8000
    * Run Apache Tomcat, Show Readme : 체크해제 -> eclipse에서 직접 기동시키기 위해서
* eclipse에서 Tomcat 서버 구동하기
  1. Tomcat 서버를 eclipse에 등록
     * File-New-Other-Server
     * Apache-Tomcat v9.0 Server 선택
     * Tomcat installation directory : C:\Program Files\Apache Software Foundation\Tomcat 9.0
     * Finish!
  2. edu생성 (edu - Dynamic  Web Project)
     * File-New-Other-Web
     * Generate web.xml deployment descriptor : 체크
     * edu-Properties-Text file encoding-Other-UTF-8
  3. edu를 Tomcat 서버에 등록
     * Add and Remove - add
  4. first.html 파일 생성
     * WebContent-New-html파일
     * meta charset="UTF-8"로 변경
  5. 브라우저(크롬)에서 first.html 요청 
     * 크롬 실행-<http://localhost:8000/edu/first.html>
     * 서버 죽이기

* 웹클라이언트 - 크롬