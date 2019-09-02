# R

R - 프로그래밍 언어이름이면서 개발환경 툴의 이름이다.

R 스튜디오 - R을 편리하게 사용할 수 있도록 돕는 통합개발환경(Integrated Development Environment)이다.

* plot : 정적 그래프
* viewer : 동적 그래프

## R 언어의 구문

### 1. 데이터 타입의 종류

* R의 자료형

  (1) 문자형 : 문자, 문자열

  (2) 수치형 : integer, double

  (3) 복소수형 : 실수+허수

  (4) 논리형 : 참값과 거짓값

* R의 리터럴

  (1) 문자형 리터럴 : "가나다", '가나다', "", ''

  (2) 수치형 리터럴 : 100, 3.14, 0

  (3) 논리형 리터럴 : **TRUE(T), FALSE(F)** (대문자로만)

  - NULL (데이터 셋이 비어있음을 의미)

  - **NA** (not available, 데이터 셋의 내부에 존재하지 않는 값(**결측치**)을 의미) : 오라클 null과 비슷

  - NaN (not a number, 숫자가 아님)

  - Inf (무한대값)

* R에서 지원하는 데이터 타입의 종류

  * 타입체크 함수들

    (1) 문자형 : is.character()

    (2) 수치형 : integer, double

    (3) 복소수형 : 실수+허수

    (4) 논리형 : 참값과 거짓값

  * 자동 형 변환 룰

    문자형(character)(높음) > 복소수형(complex) > 수치형(numeric) > 논리형(logical)(낮음)

  * 강제 형 변환 함수

    as.character(x), as.complex(x)

  * 자료형 확인 함수 

    class(x), str(x), mode(x)

### 2. 데이터 셋의 종류

#### 스칼라(Scala, 단일값)  

* 10, 100은 벡터에 포함된다.

#### **벡터** (Vector, 1차원 데이터셋), 행렬, 배열 

* **모든 데이터가 동일한 타입이어야 한다.**
* 하나의 데이터 값도 벡터로 취급된다.
* 벡터 생성 방법 : c(), seq(), rep(), : 연산자
* 무조건 1부터 시작한다. 인덱스에 -를 붙이면 그 값을 빼고 출력한다.
* summary() : 어떤 벡터냐에 따라 출력내용이 다르다.
* sample(배열,개수) : 배열 안에서 개수만큼 무작위로 꺼낸다. 

#### **행렬**(Matrix) 

* 2차원의 벡터이다. [행의 인덱싱, 열의 인덱싱], [행의 인덱싱, ] , [ ,열의 인덱싱] (인덱스를 안주면 모든 인덱스를 포함한다.)
* 동일한 타입의 데이터를 저장한다.
* drop 속성 : 행렬구조 유지여부를 결정한다. 디폴트 값은 TRUE로 행렬구조를 유지해주지 않는다.
* 값을 채울 때는 열 단위를 우선으로 채운다. (byrow =TRUE면 행 단위를 우선으로 채운다.)
* dim(m) : 행렬이 몇 차원인지 체크한다.
* nrow, ncol :  행의 개수 또는 열의 개수를 추출한다.

#### **요인** (Factor, 정해진 범주의 데이터 의미) 

* 범주형이냐 아니냐에 따라 그려지는 그래프가 달라진다.
* 정해진 값 : Level 이라 한다.
* summary()를 하면 해당 범주 안의 원소의 개수를 세준다.
* stringAsFactors = FALSE로 주면 열이름을 마음대로 생성하지 않는다.

#### 데이터 프레임(열 단위로 여러 개의 vector가 모여 있는 것) 

* **열마다 타입이 다를 수 있다.** csv, oracle, excel, xml 등이 속한다.
* 벡터로 구성되어있다.
* 열 단위로 서로 다른 타입의 데이터들로 구성이 가능하다.
* **모든 열의 데이터 개수는 동일해야 한다.**
* 리눅스: ~ : 홈디렉토리 / 윈도우: ~: 내문서
* order()를 통해 정렬한다.

#### 리스트 (List) 

* 어떤 데이터(벡터, 행렬, 함수 등)든 담을 수 있다.
* 서로 다른 구조의 데이터를 하나로 묵을 수 있는 자료구조이다.
* 데이터를 꺼낼 때는 **[[ ]]** 를 사용해 꺼내야한다.
* 사칙연산을 할 수 없다.

### 3. 연산자

* %/% : 행렬의 곱 몫

* %% : 행렬의 곱 나머지

* 논리 연산자

  &, | : 모든 원소에 적용

  &&, || : 첫 번째 원소에만 적용

* <<- : 전역 할당 연산자
* 데이터 입출력
  * print() : 데이터 내용 출력, 1개 출력 가능, 자동으로 개행처리됨
    * quote=FALSE
    * print.gap=10
  * cat() : 메세지 출력, 여러 개 출력 가능, 개행처리 안됨, \n 사용해야함
* 파일에서 데이터 읽어들이기
  * scan("aaa.txt") : word단위로 numeric형으로 각각 원소를 벡터로 출력한다.
  * scan("aaa.txt",what="") : 주어진 파일 내용을 character형으로 읽는다.(숫자도 문자로)
  * readLines() : 행 단위로 character형으로 읽는다.
  * table() : 테이블 형으로 읽는다.

### 4. 제어문

* switch 함수
  * switch(EXPR=수치데이터,식1,식2,식3...) : default 값을 줄 수 없다.
  * switch(EXPR=문자열데이터, 비교값1=식1, 비교값2=,비교값3=식3,식3) : default값을 줄 수 있다.

### 5. 함수

```
[함수 정의]
func1 <- function(매개변수) {
  xx <- 10
  yy <- 20
  return(xx*yy)
}
```

* 함수가 정의하고 있는 매개변수 사양에 맞춰서 꼭 아규먼트를 전달해야 한다.

* 리턴값이 없는 함수는 NULL이 리턴된다.

* return()문이 생략된 경우에는 마지막으로 출력된 데이터값이 자동으로 리턴된다. 따라서 리턴함수를 사용하여 명확히 구현하는 것이 필요하다.

* 아규먼트 타입을 제한하려는 경우에는 is.xxx() 함수를 활용한다.

* 기본값을 갖는 매개변수를 선언하여 선택적으로 전달되는 아규먼트를 처리할 수 있다. ex) f3<-function(p="R") print(p) ---> f3(), f3(p="PYTHON") 으로 호출가능

  ex) f4 <- function(p1="ㅋㅋㅋ",p2) for(i in 1:p2) print(p1) ---> f4(p2=5) 로 호출 

* 아규먼트 개수와 타입을 가변적으로 처리 가능하다. 

  ex) f5 <- function(...) {print("TEST"); data <- c(...); print(length(data))} 

* 함수 안에서 만들어진 지역변수는 함수내에서만 사용 가능하다.

* 수행문자 1개일 때 중괄호 생략 가능하다.

* invisible()함수

  호출할 때는 return값을 표시해주지 않는다. 호출하고 변수에 담거나 다른 연산에 사용되야지 표시된다. ex) ft.3 <- function(x) invisible(x+10)

* stop() 함수

  error를 표시해주고 더 이상 수행하지 않는다.

* warning() 함수

  warning을 표시해주고 끝까지 수행한다.

* **try() 함수**

  error가 발생해도 다음을 그대로 수행한다. java의 try-catch문과 비슷하다. 많을 경우 중괄호로 묶는다. ex) try(testError(-1))

* tryCatch() 함수

  error, waring이 났을 떄 대신 수행할 함수를 지정할 수 있다.

  ```
  testAll <-function(p){
    tryCatch({
      if(p=="오류테스트"){
        testError(-1)
      }else if (p =="경고테스트"){
        testWarn(6)
      }else{
        cat("정상 수행..\n")
        print(testError(2))
        print(testWarn(3))
      }
    },warning = function(w){
      print(w)
      cat("-.-;;\n")
    }, error = function(e){
      print(e)
      cat("ㅠㅠ \n")
    },finally ={
      cat("오류, 경고 발생 여부를 따라서 반드시 수행되는 부분입니다요..\n")
    })
  }
  ```

---

## 웹 스크랩핑 / 크롤링

정적 스크랩핑

* 웹 스크랩핑 : 웹 상에서 콘텐츠를 가져와 원하는 부분을 추출하는 것이다. 
* 웹 크롤링 : 서버를 통해 콘텐츠를 가져오는 것이다.
* 개발자도구-copy-selector 
* rvest 라이브러리 주요 함수
  * html_nodes(x,css,xpath) : 돔객체를 찾아준다. (x : 읽고자 하는 정보)
  * html_node(x,css,xpath)
  * html_text(x,trim=FALSE) : 컨텐츠를 읽는다. (trim : True일 경우 blank를 없애준다.)
  * html_attrs(x) : 태그가 가지고 있는 모든 속성을 추출한다.
  * html_attr(x, name, default="")  : 태그가 가지고 있는 특정 속성을 추출한다.
* xml 라이브러리 주요 함수
  * htmlParse() : read_html과 비슷하다.
* httr 라이브러리 주요 함수
  * GET() :  GET방식으로 사이트 내용을 가져온다.
  * POST() : POST방식으로 사이트 내용을 가져온다.
  * unique() : 중복을 제거해준다.
* 한글이 깨지는 경우
  * iconv(text1,"CP949","UTF-8")

동적 스크랩핑

자바스크립트를 이용해 원하는 내용을 추출한다.

---

## Selenium

Selenium은 웹앱을 테스트하는데 이용하는 프레임워크이다.

* saaply : 리스트 대신 행렬, 벡터 등의 데이터 타입으로 결과를 변환하는 함수이다.
* java -jar selenium-server-standalone.jar -port 4445

---

## 정규표현식

* gsub(변경할 내용, 변경후 내용, 전체내용) : 괄호 안의 내용을 찾아 변경한다.
* [] : 대괄호 안의 내용을 or로 받아 변경한다.
* [[:digit:]] : 숫자를 변경한다.
* [^[:alnum:]] : 알파벳과 숫자를 제외해 변경한다. (공백도 변경된다.)
* [[:space:]] : 공백을 변경한다. 

---

## 날짜와 시간관련 함수들

* 날짜 : %d (day 01-31), %a (Mon), %A (Monday), %m (month 01-12), %b (Jan), %B (January), %y (yy), %Y (YYYY)
* 시간 : %H, %M, %S

---

## apply 계열 함수

* apply(X,Margin,Fun) : X:배열 또는 행렬, Margin:함수를 적용하는 방향(1:행,2:열), Fun:함수

* lapply() : 결과를 리스트 형식으로 반환한다.

* sapply() : s-simple, **가능한 결과를 simple한 데이터셋으로 반환**한다.

* tapply() : 특정 기준에 따라 데이터를 그룹으로 묶은 뒤 각 그룹마다 주어진 함수를 적용하여 결과를 반환한다.

* mapply() : m-multiple, 여러 벡터를 받아 첫번째,두번재 등 원소끼리 함수를 수행한다.

* **sapply함수에 원소를 주느냐, 데이터프레임을 주느냐에 따라 처리하는 방식이 다르다.**

  ```
  (count <- 1)
  myf <- function(x,wt=T){
    print(paste(x,"(",count,")")) #x벡터, 벡터마다 count가 붙는다.
    Sys.sleep(10)
    if(wt) r <- paste("*",x,"*")
    else r <- paste("#",x,"#")
    count <<- count + 1; #전역변수에 적용
    return(r)
  }
  sapply(df$w,myf)
  sapply(df$w,myf,F)
  sapply(df$w,myf,wt=F)
  (rr1 <- sapply(df$w,myf,wt=F)) #myf가 원소개수마다 호출된다!!!
  str(rr1) 
  (count<-1)
  sapply(df,myf) #### df : 변수들로 구성된 벡터모임이다.!!!
  (rr2 <- sapply(df, myf)); str(df) #myf가 2번(열의 개수) 호출된다.!!!
  str(rr2)
  rr2[1,1]; rr2[1,"w"]
  r <- sapply(df,myf) #변수단위로 myf 함수의 결과값을 갖고 있다가 마지막에 리턴한다. 
  str(r) #matrix
  ```

---

## 시각화

* 고수준함수 : plot(), pie(), barplot(), boxplot(), hist()

* 저수준함수 : 고수준함수를 꾸며준다. title(), lines(), axis(), legend(), points(), text()

* 칼라팔레트 함수 : rainbow(), cm.colors(), topo.colors(), terrian.colors(), heat.colors()

* 그래프를 파일에 저장하는 방법

  1. 그려지는 그래프를 파일로 저장

     ```
     png("mytest.png",500,400);
     dev.off();
     ```

  2. 그래프를 그린 후에 파일에도 저장

     ```
     dev.copy(png,"mytest.png"); 또는 dev.copy(pdf,"mytest.pdf");
     dev.off();
     ```

* 히스토그램

  값의 분포를 그린다. 최댓값, 최솟값을 구해 구간을 나눠 값이 몇 개 속하는지 나타낸다.

  hist(score, breaks = 10) : 값의 분포에 따라 breaks 값을 적용 또는 적용하지 않아 구간을 나눠준다.

  hist(nums, breaks=c(0,33,66,100)) : 원하는 값으로 구간을 나누려면 직접 명시해주어야 한다.

## R 패키지

## reshape2 package 

**melt(열->행 변환)**, dcast(행->열 변환), cast(행->열 변환)

* **melt(데이터 세트, id.var = "기준 열", measure.vars = "변환 열")**
  * 기준 열은 여러 개 지정 가능하며 필수이다. 변환 열을 생략하면 모두 포함한다.

## KoNLP package (Korean Natural Language Process)

패키지 내에 포함된 사전을 통해 문서에 포함된 단어의 품사를 분석해준다.

``` 
useSystemDic() #시스템 사전 설정
useSejongDic() # 세종 사전 설정
useNIADic() # NIADic 사전 설정
```

* 텍스트 수집 -> 분해 -> 단어 추출 -> 정제 -> 정형 데이터 생성 -> 분석 -> 시각화
* extractNoun() 함수 : 데이터에서 명사만 분리한다.
* buildDictionary() 함수 : 사용자 정의 사전에 없는 단어를 추가한다.

## wordcloud, wordcloud2 package

wordcloud2(데이터, 옵션)

* 옵션 : minsize, size, col, rotateRatio, backgroundColor, **figPath**(이미지)

1. 기본형 워드클라우드

## ggplot2 package

**ggplot(데이터 세트, aes(데이터 속성))**

* 여러 줄로 작성 시 앞의 명령어 뒤에 + 기호를 붙여야 한다.

1. 그래프 기본틀 

   ```
   ggplot(airquality, aes(x=Day, y=Temp))
   ```

2. 산점도, geom_point() 함수

   ```
   ggplot(airquality, aes(x=Day, y=Temp))+geom_point(size=3, color="blue")
   ```

3. 꺾은선그래프, geom_line() 함수

   ```
   ggplot(airquality, aes(x=Day, y=Temp))+geom_line()
   ```

4. 그래프에 그래프 더함

   ```
   ggplot(airquality, aes(x=Day, y=Temp))+geom_point()+geom_line()
   ```

5. 막대 그래프, geom_bar() 함수

   ```
   ggplot(mtcars, aes(x=factor(cyl))) + geom_bar(width = 0.5)
   ```

   * x축에 해당하는 데이터의 수를 y축에 표시한다.

   ```
   ggplot(data=w, aes(x=year, y=weight)) + geom_bar(aes(fill=year), stat="identity") + 
     geom_label(aes(label=weight), nudge_y=-1.1)+coord_cartesian(ylim=c(60, 75))
   ```

   * **geom_bar(stat="identity")** : y축을 y축에 지정된 값으로 표현한다.
   * **coord_cartesian(ylim=c(60, 75))** : y축의 표현범위를 설정한다.
   * **geom_label(nudge_y=1.1)** : y축 값을 nudge_y거리만큼 띄어 표시해준다.

6. 누적 막대그래프

   ```
   ggplot(mtcars, aes(x=factor(cyl))) +
     geom_bar(aes(fill=factor(gear)))
   ```

   * ggplot에 fill이라는 변수를 바로 주어도 된다.
   * fill = factor형 데이터일 경우 완전히 다른 컬러로 채운다.
   * fill = numeric형 데이터(연속 데이터) 그라데이션 컬러로 채운다.

7. 선버스트 차트

   ```
   ggplot(mtcars, aes(x=factor(cyl)))+
     geom_bar(aes(fill=factor(gear))) +
     coord_polar()
   ```

8. 상자 그림, geom_boxplot() 함수

   ```
   ggplot(airquality, aes(x=Day, y=Temp, group=Day)) +
     geom_boxplot()
   ```

   * **group=Day** : 날짜별 온도 분포를 확인할 수 있다.

9. 히스토그램, geom_histogram() 함수

   ```
   ggplot(airquality, aes(Temp)) +
     geom_histogram(binwidth = 0.5)
   ```

   * binwidth = 비율 : 그래프의 폭을 기본값의 비율만큼 조정한다.

### 그래프 꾸미기

직선그리기

1. 사선, geom_abline() 함수

   ```
   ggplot(economics, aes(x=date,y=psavert)) +
     geom_line() + #절편 12.18671, 기울기 -0.0005444
     geom_abline(intercept = 12.18671, slope = -0.0005444) 
   ```

   ```
   #date를 기준으로 psavert(개인 저축률)이 얼마인지 출력한다.
   lm(psavert~date, data=economics) 
   ```

2. 평행선, geom_hline()  함수

   ```
   #평행선 - 개인 저축률의 평균값
   ggplot(economics, aes(x=date,y=psavert)) +
     geom_line() +
     geom_hline(yintercept = mean(economics$psavert), col="red")
   ```

3. 수직선, geom_vline() 함수 

   ```
   #수직선 - 개인 저축률이 최솟값일 때 날짜
   (x_inter <- filter(economics, psavert == min(economics$psavert))$date)
   ggplot(economics,aes(x=date,y=psavert)) +
     geom_line() +
     geom_vline(xintercept = x_inter, col="red")
   ```

텍스트 입력 및 도형 그리기

1. 텍스트, geom_text() 함수

   ```
   ggplot(airquality, aes(x=Day,y=Temp)) +
     geom_point() +
     geom_text(aes(label=Temp, vjust=0, hjust=-3))
   ```

2. 도형 및 화살표, annotate() 함수

   ```
   ggplot(mtcars,aes(x=wt,y=mpg)) +
     geom_point() +
     annotate("rect", xmin=3, xmax = 4, ymin = 12,ymax = 21, alpha = 0.5, 
              fill = "skyblue") +
     annotate("segment",x=2.5,xend = 3.7, y=10,yend = 17,color="red",
              arrow=arrow()) +
     annotate("text",x=2.5,y=10,label="point")
   ```

3. 그래프 및 축 제목, labs() 함수

   ```
   ggplot(mtcars, aes(x=gear)) + geom_bar() +
     labs(x="기어수", y="자동차수", title="변속기 기어별 자동차수")
   ```

4. 테마 적용, theme() 함수

   ```
   imsi <- ggplot(mtcars, aes(x=gear)) + geom_bar() +
     labs(x="기어수", y="자동차수", title="변속기 기어별 자동차수")
   
   imsi + theme_gray()
   imsi + theme_bw()
   imsi + theme_linedraw()
   imsi + theme_light()
   imsi + theme_dark()
   imsi + theme_minimal()
   imsi + theme_classic()
   imsi + theme_void()
   ```

트리맵 그리기

```
treemap(sales_df, vSize="saleAmt", index=c("product", "region"), title="A기업 판매현황")
```

## plotyly package

```
p <- ggplot(data = mpg, aes(x = displ, y = hwy, col = drv)) + geom_point()
ggplotly(p)
```

```
p <- ggplot(data = diamonds, aes(x = cut, fill = clarity)) + 
  geom_bar(position = "dodge")
ggplotly(p)
```

## ggmap package

1. 주소가 영어일 때

   ```
   mk <- geocode("seoul", source = "google")
   print(mk)
   cen <- c(mk$lon, mk$lat)
   map <- get_googlemap(center=cen, maptype="roadmap",zoom=12, marker=mk)
   ggmap(map)
   ```

2. 주소가 한글일 때

   ```
   mk <- geocode(enc2utf8("강남구 역삼동 테헤란로 212"), source = "google")
   cen <- c(mk$lon, mk$lat)
   map <- get_googlemap(center=cen, maptype="roadmap",zoom=16)
   ggmap(map) + 
     geom_point(aes(x=mk$lon, y=mk$lat), alpha=0.4, size=5, color="pink") +
     geom_text(aes(x=mk$lon, y=mk$lat, label="우리가 공부하는 곳", vjust=0, hjust=0))
   ```

## leaflet package

- leaflet() : leaflet map widget을 생성하고 데이터를 연결한다. 각각의 함수는 %>%를 통해 연결할 수 있다.
- setView() : 지도의 중심과 확대 정도를 설정한다.
- addTiles() : 기본 타일(OpenStreetMap)을 불러와서 지도를 보여준다.