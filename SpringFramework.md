# Spring Framework

스프링 프레임워크란 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크로서 간단히 스프링이라고 한다. 소스 코드의 코딩량을 줄여주고 유지보수성이 좋은 프로그램이다.

웹 서버 프로그래밍 - Spring MVC, Spring Ioc(Spring DI)

Eclipse EE = Eclipse for Java Developer +WTP(Web Tools Platform) + **STS(Spring Tool Suite) 추가설치**

* Eclipse-Help-Eclipse Marketplace-STS검색-Spring Tools 3 Add-On설치

프레임워크(framework) - 1998, 2004~2006 : 스마트 라이브러리(라이브러리+디스크립터 파일( XML))

* 최초 프레임워크는 EJB(1998)(Java+XML) 였다. 그러나 구현이 어려웠다.  
* Servlet, Struts, iBatis(MyBatis), Spring, Spring MVC 

## 학습 순서

(1) **Spring IoC**

외부에서 객체를 만들어서 프로그램에 넣어주는 기술이다. 객체 생성을 Spring DI 컨테이너가 대신하게 한다. Spring Framework에서 프로그램에서 필요한 객체를 생성한다. 또한 객체를 필요로 하는 곳에 주입하고 객체를 찾을 때 제공한다.

* **DL**(Dependency Lookup) : 객체를 달라고 할 때마다 주는 것이다.

* **DI**(Dependency Injection) : 어떤 상황에서 객체를 달라고 하는 것을 xml에 작성하면 주는 것이다.

  * **Setter Injection** : setter 메서드를 이용해서 객체를 바인딩(의존관계를 연결)한다.

  * **Constructor Injection** : 생성자를 통해 객체를 바인딩(의존관계를 연결)한다.

Maven Project 추가 방법

- Springioc Java Project 생성

- Springioc-오른쪽마우스-configure-convert to Maven Project 선택

- Name : Springioc_project, Description : 스프링 IOC 학습용 자바프로젝트입니다. 입력

- pom.xml을 수정해서 프로젝트에서 의존하는 추가라이브러리에 대한 정보를 작성

  - 오류 발생할 경우 .m2 파일에 repository파일이 만들어졌는지 확인한다. 

  ```xml
  <dependencies>
    <!-- https://mvnrepository.com/artifact/org.springframework/spring-context -->
  <dependency>
      <groupId>org.springframework</groupId>
      <artifactId>spring-context</artifactId>
      <version>5.0.2.RELEASE</version>
  </dependency>
  </dependencies> 
  ```

Annotation 설정

* @Component

  클래스에 선언하며 해당 클래스를 자동으로 bean 으로 등록한다

* @autowired

  * autowired="**byType**" : **setter**

    (1) 타입으로 찾아서 1개이면 해당 객체 주입
    (2) 타입으로 찾아서 2개 이상이면 NoUniqueBeanDefinitionException 발생
    (3) 없으면 null 주입 : 주입을 포기한다는 의미이다.

  * autowired="**byName**"  : setter
    (1) 프로퍼티명과 동일한 명칭의 빈을 찾아서 해당 객체 주입
    (2) 없으면 null 주입

  * autowired="**constructor**"  : 
    (1) 타입으로 찾아서 1개이면 해당 객체 주입
    (2) 타입으로 찾아서 2개 이상이면 **매개변수명과 동일한 id 값**을 갖는 객체 주입
    (3) 없으면 null 주입

  * 필드(멤버변수)에 설정된 @Autowired (디폴트는 required = true다.) - Spring Framework 전용 /멤버변수,생성자메서드,setter메서드,일반메서드에 적용가능하다.
    (1) 타입으로 찾아서 1개이면 해당 객체 주입
    (2) 타입으로 찾아서 2개 이상이면 **변수명과 동일한 id 값을 갖는 객체** 주입
    (3) 없으면 NoSuchBeanDefinitionException 발생
         (**required = false** 속성을 사용하여 없으면 null 이 되게 지정 가능) 
    (4) **@Qualifier(value="xxx")**를 추가로 사용해서 변수명이 아닌 다른 이름 지정 가능

    간단하게 멤버변수와 setter메서드를 입력할 수 있다.

  * 필드에 설정된 @Resource - Java 전용
    (1) **변수명과 동일한 id 값을 갖는 빈**을 찾아서 해당 객체 주입 - 변수명이 우선이다.
    (2) 타입으로 찾아서 1개이면 객체 주입
    (3) 타입으로 찾아서 2개이상 이면 NoUniqueBeanDefinitionException 발생
    (4) 없으면 NoSuchBeanDefinitionException 발생

(2) **Spring MVC**

**웹 어플리케이션**

복수의 사용자가 인터넷을 통해 DB에 접근하고 안전하게 정보를 읽고 쓸 수 있게 지원하는 어플리케이션이다.

기본적으로 Forword방식으로 전송한다. redirect방식으로 전송하고 싶으면 "redirect:에 context명을 제외한 path정보"를 사용한다. 그러면 302라는 응답과 함께 다시 끌어간다.

* 웹 어플리케이션 구조
  	* 티어 : 어플리케이션의 구조를 물리적으로 나눈 것
   * 레이어 : 어플리케이션의 구조를 논리적으로 나눈 것
     	* 프레젠테이션 레이어 : 컨트롤러, 뷰
     	* 비즈니스 로직 레이어 : 서비스, 도메인
     	* 데이터 엑세스 레이어 : DAO

* 스프링 MVC

  프론트 컨트롤러 패턴을 적용한다. 프론트 컨트롤러 패턴이란, 하나의 핸들러 객체를 통해서 요청을 할당하고, 일관된 처리를 작성할 수 있게 하는 개발 패턴이다.

  * Spring Framework가 제공하는 것
    * **Dispatcher Servlet** : 클라이언트가 요청하는 모든 요청을 받는다.
    * **Handler Mapping** : Handler Mapping을 통해 Dispatcher Servlet에서 클라이언트가 무엇을 요청했는지 판단한다.
    * **View Resolver** : 출력할 뷰를 Dispatcher Servlet에 전송한다.

* Spring MVC 패키지 만들기

  Spring MVC project명 : springedu

  package명 : my.spring.springedu

  server 추가

  property-utf-8로 변경, properties-web project settings - context명 확인

  * webapp : 최상위 폴더이다.
  * resources :html 등 정적 리소스(클라이언트한테 바로 줄 수 있는 리소스)를 보관한다.
  * views : jsp를 보관한다.
  * my.spring.springedu : controller를 보관한다.

  ```
  pom.xml 환경 변경
  <java-version>1.8</java-version>
  <org.springframework-version>5.0.2.RELEASE</org.springframework-version>
  ```

  ```
  web.xml에 추가
  <filter> <!-- spring MVC에서 post방식으로 전송하여도 깨지지 않는다. post방식 setCharacterEncoding -->
      <filter-name>encodingFilter</filter-name>
      <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
      <init-param>
        <param-name>encoding</param-name>
        <param-value>UTF-8</param-value>
      </init-param>
    </filter>
    <filter-mapping>
      <filter-name>encodingFilter</filter-name>
      <url-pattern>/*</url-pattern>
    </filter-mapping>
  ```

  * javax.servlet.forward.request_uri :  클라이언트가 요청한 uri 다.

* vo에 담아 보낼 떄(Dispatcher Servlet이 처리해준다.)

1. Controller 매개변수 값이 3개 이상일 때 VO model에 담아 사용한다. 
2. vo 멤버변수 이름과 쿼리문자열 이름이 같아야한다.
3. Dispatcher Servlet이 클래스 이름에서 앞에 첫문자를 소문자로 만들어 request객체에 저장해준다.
4. vo에 담을 쿼리문자열 값을 주지 않으면 setter메서드를 호출하지 않는다.
5. @ModelAttribute("사용하고자 하는 이름")를 사용해서 request객체이름을 저장할 수 있다. 

(3) MyBatis : JDBC 프로그래밍을 더 효율적으로 할 수 있게 해준다. (HiberNate라는 것도 있다.)

```
[추가 라이브러리 준비 방법]
(1) 해당 라이브러리 압축파일(xxx.jar)을 사이트에서 다운로드하여 정해진 디렉토리에 저장하거나 패스 설정을 한다. -> 관리하기가 쉽지 않다..
(2) 추가로 설치하려는 라이브러리를 관리해주는 툴(빌드 툴)
- Maven, Gradle 등 (pom.xml에 내려받을 것을 작성하면 빌드 툴이 다운로드해준다.)
```

* xmlns:p="http://www.springframework.org/schema/p" - property를 대신한다.
  xmlns:c="http://www.springframework.org/schema/c" - constructor-arg를 대신한다.