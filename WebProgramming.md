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
     * 크롬 실행 
   
       * <http://localhost:8000/edu/first.html> 
     
         * 위 문장은 HTTP URL(Uniform Resource Locator) 문자열이다.
         * http(HyperText Transfer Protocol) : 웹의 표준 프로토콜이다.
     
         * http://localhost:8000 : 서버 정보이다.
     
         * /edu/first.html : 클라이언트가 서버한테 요청하고자 하는 path정보이다. 
     
           ​						 URI(Uniform Resource Identifier) 문자열이다.
     
         * /edu : Context Path 라고 한다. 잘못 줄 경우 404오류가 발생한다.
     
         * /first.html : Document root에 가서 해당 파일을 보여달라고 요청한다.
     
           ​				 (WebContent : Dynamic Web Project의 WebContent를 Document root 라고 한다.)
     
         * 웹 브라우저에서 내용이 출력되는 부분을 document라고 한다.
     
         * 렌더링 : html 소스를 파싱하여 각 태그에 알맞게 document에 출력해주는 것을 말한다.
     
           * 파싱(parsing)이란?
     
             -> parse에 ing를 붙인 형태로 어떤 데이터를 다른 모양으로 가공하는 것을 말한다.
     
             -> cf) 파서(parser) : compiler의 일부로써 원시 프로그램을 받아들여 그 문장의 구조를 알아내는 							   구문 분석을 행하는 프로그램이다. 
     
     * 서버 다 사용한 뒤 끄기
  
* 웹클라이언트 - 크롬

  * 웹 표준

    * HTML : 문서의 내용과 구조 담당한다.
    * CSS : 스타일에 관련된 표현 담당한다.
    * Java Script : 클라이언트 종류에 무관하게 동작 담당한다.

  * HTML 5 : W3C(World Wide Web Consortium)의 HTML WG(Working Group)을 통해서 만들어지고 있는 

    ​			    차세대 마크업 언어 표준이다.

  * HTML 문서 구성

    |       요소        | 의미                                                 | 코드 예                     |
    | :---------------: | ---------------------------------------------------- | --------------------------- |
    |     태그(tag)     | '<'와 '>'로 둘러싸인 문자열                          | **<title>**Test**</title>** |
    |   내용(content)   | 태그로 둘러싸인 문자열                               | <title>**Test**</title>     |
    | 엘리먼트(element) | 태그와 내용을 포함한 전체 문자열                     | **<title>Test</title>**     |
    |  속성(attribute)  | 시작 태그 안에서 엘리먼트의 상세 기능 설정 사항 지시 | <a **href**="URL"></a>      |
    |   속성값(value)   | 속성값 (' ' 또는 " "로 감쌈)                         | <a href=**"URL"**></a>      |

  * HTML5의 문서구조

    ```html
    <!DOCTYPE html>	<!--선언문-->
    <html>
    <head>
    	<meta charset="UTF-8">
    	<title>첫 번째 HTML</title>
    </head>
    <body>	<!--렌더링 되는 값은 body태그 안의 내용이다.-->
    	<h1>HTML을 테스트합니다.</h1> 
    </body>
    </html>
    
    ```

  * charset="UTF-8" 자동설정

    * Window-Preference-Web-HTML Files-Encoding-UTF-8선택

  * 행바꿈

    * block style tag : 자동으로 행바꿈이 일어나는 태그
    * inline style tag : 자동으로 행바꿈이 일어나지 않는 태그 (ex) select

  * 주석

    * ctrl+shift+/

  * <http://html5test.com/> : 자신의 브라우저에서 html5를 얼마나 지원하는지 점수로 알 수 있다.

  * HTML 특수 코드

    | 특수 코드 값 | 표현                   |
    | ------------ | ---------------------- |
    | \&lt;        | <                      |
    | \&rt;        | >                      |
    | \&nbsp;      | ' ' (공백, Space 한칸) |
    | \&amp;       | &                      |
    | \&quot;      | " (큰따옴표 하나)      |

  * HTML5에서 문서의 구조를 정의하는 태그

    | 태그      | 설명                                                         |
    | --------- | :----------------------------------------------------------- |
    | <header>  | 머리말, 제목을 표현하기 위해 사용한다.                       |
    | <nav>     | 네비게이션, 주로 메뉴에 사용되고 위치에 영향을 받지 않는다.  |
    | <section> | 본문 콘텐츠 내용을 담는다.                                   |
    | <article> | 실질적인 내용을 넣는다. 뉴스를 예로 들면 정치/연예 대분류는 <section>이고, 정치의 기사내용, 연예의 기사내용은 <article>에 넣는다. |
    | <aside>   | ''사이드바''라고 부르며 본문 이외의 내용을 담고 있는 시맨틱 태그이다. |
    | <footer>  | 화면의 구조 중 제일 아래 위치하며 회사소개/저작권/약관/제작정보 등 내용이 들어간다. |

    