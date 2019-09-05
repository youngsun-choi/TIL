# R, Oracle, Java 연동

## R과 Oracle 연동

1. DB 서버 접속

   ```r
   drv <- JDBC('oracle.jdbc.driver.OracleDriver','C:/kj/ojdbc6.jar')
   conn <- dbConnect(drv,'jdbc:oracle:thin:@localhost:1521:xe','jdbctest','jdbctest')
   ```

2. DB 접속해제

   ```r
   dbDisconnect(conn)
   ```

3. 테이블 리스트 출력

   ```r
   dbListTables(conn)
   ```

4. 테이블에 저장된 데이터 읽기 

   * 방법1 **(테이블 이름은 반드시 대문자!)**

     ``` r
     (result1 <- dbReadTable(conn,'VISITOR'))
     class(result1) #data frame
     ```

   * 방법2

     ``` r
     (result2 <- dbGetQuery(conn,'select * from visitor'))
     class(result2) #data frame
     ```

   * 방법3

     ``` R
     (result3 <- dbSendQuery(conn,'select * from visitor'))
     class(result3) #resultSet
     (ret1 <- dbFetch(result3,1))
     (ret2 <- dbFetch(result3,2))
     ```

5. 테이블에 데이터 저장하기

   * 방법1

     ``` R
     dbWriteTable(conn,'book',data.frame(bookname=c('자바의 정석','하둡 완벽 입문','이것이 리눅스다'),
                                         price=c(30000,25000,32000))) #테이블 생성 동시에 데이터 저장
     dbWriteTable(conn,'cars',head(cars,3)) #이미 만들어진 테이블
     ```

   * 방법2

     ``` r
     dbSendUpdate(conn,"insert into visitor values(visitor_seq.nextval,'R언어',sysdate,'R언어로 입력')") #데이터만 저장
     dbSendUpdate(conn,"insert into visitor values(visitor_seq.nextval,'하둡',sysdate,'대용량데이터')")
     ```

6. 테이블 데이터 수정

   ``` r
   dbSendUpdate(conn,'insert into cars(speed,dist) values (1,1)')
   dbSendUpdate(conn,'insert into cars(speed,dist) values (2,2)')
   dbReadTable(conn,'CARS')
   dbSendUpdate(conn,'update cars set dist=dist*100 where speed=1')
   dbReadTable(conn,'CARS')
   dbSendUpdate(conn,'update cars set dist=dist*3 where speed=1')
   dbReadTable(conn,'CARS')
   ```

7. 테이블 삭제 **(테이블 이름은 반드시 대문자!)**

   ``` r
   dbRemoveTable(conn,'CARS')
   ```

   

## R과 Java 연동

* **RServe**

  R 바이너리 서버라고 불리는 프로그램이다. Java 나 다른언어에서 R코드를 연동할 때 필요한 기능을 서포트하는 서버이다. Java, C, C++, PHP와 같은 다른 프로그램에서 TCP/IP로 R에 원격 접속, 인증, 파일 전송을 가능하게 해준다.

  install.packages('Rserve')로 패키지를 설치한다.

* Java와 R연동 테스트용 프로젝트 생성

  * 프로젝트 생성 후 Resource - UTF-8, Project facets - Java - 1.8

* Rserve에 접속하는 명령 실행 - RConnection

  * **eval()** : R에 직접적인 명령을 내리고 **REXP 타입으로 데이터를 반환 받는다.** (R코드 입력)
  * **assign()** : R의 변수에 REXP 또는 String 형태로 데이터를 지정하여 설정한다.

* **REXP 타입**

  R과 Java에서 서로의 자료구조와 데이터 타입을 서로 사용할 수 있도록 지원하는 데이터 모델 형의 클래스이다.

  * asBytes : Byte 일차원 배열형으로 반환
  * asDouble : double형으로 반환
  * asDoubleMatrix : double 이차원 배열형으로 반환
  * asDoubles : double 일차원 배열형으로 반환
  * asList : data frame을 리턴한다.
  * asString : String형으로 반환
  * asStrings : String 일차원 배열형으로 반환
  * length : 데이터의 개수 반환
  
* source() 함수

  * 자주 사용하는 R코드를 모아 놓은 함수이다.