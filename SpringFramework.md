# Spring Framework

스프링 프레임워크란 자바 플랫폼을 위한 오픈소스 애플리케이션 프레임워크로서 간단히 스프링이라고 한다. 소스 코드의 코딩량을 줄여주고 유지보수성이 좋은 프로그램이다.

웹 서버 프로그래밍 - Spring MVC, Spring Ioc(Spring DI)

Eclipse EE = Eclipse for Java Developer +WTP(Web Tools Platform) + **STS(Spring Tool Suite) 추가설치**

* Eclipse-Help-Eclipse Marketplace-STS검색-Spring Tools 3 Add-On설치



## 학습 순서

(1) Spring IoC

외부에서 객체를 만들어서 프로그램에 넣어주는 기술이다. Spring Framework에서 프로그램에서 필요한 객체를 생성한다. 또한 객체를 필요로 하는 곳에 주입하고 객체를 찾을 때 제공한다.

* DL : 객체를 달라고 할 때마다 주는 것이다.

* DI : 어떤 상황에서 객체를 달라고 하는 것을 xml에 작성하면 주는 것이다.

  Setter Injection : setter 메서드를 이용해서 객체를 바인딩(의존관계를 연결)한다.

  Constructor Injection : 생성자를 통해 객체를 바인딩(의존관계를 연결)한다.

Maven Project 추가

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

(2) Spring MVC

(3) MyBatis : JDBC 프로그래밍을 더 효율적으로 할 수 있게 해준다. (HiberNate라는 것도 있다.)

```
[추가 라이브러리 준비 방법]
(1) 해당 라이브러리 압축파일(xxx.jar)을 사이트에서 다운로드하여 정해진 디렉토리에 저장하거나 패스 설정을 한다. -> 관리하기가 쉽지 않다..
(2) 추가로 설치하려는 라이브러리를 관리해주는 툴(빌드 툴)
- Maven, Gradle 등 (pom.xml에 내려받을 것을 작성하면 빌드 툴이 다운로드해준다.)
```

* xmlns:p="http://www.springframework.org/schema/p" - property를 대신한다.
  xmlns:c="http://www.springframework.org/schema/c" - constructor-arg를 대신한다.