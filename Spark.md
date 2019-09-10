# Spark

## 시스템 설정 

* cd $HADOOP_HOME

* cd etc

* cd hadoop

* hdfs-site.xml 수정

  ```
  <configuration>
  <property>
        <name>dfs.replication</name>
        <value>1</value>
     </property>
     <property>
        <name>dfs.name.dir</name>
        <value>/root/hadoop-2.7.7/hdfs/name</value>
     </property>
     <property>
        <name>dfs.data.dir</name>
        <value>/root/hadoop-2.7.7/hdfs/data</value>
     </property>
     <property>
        <name>dfs.support.append</name>
        <value>true</value>
     </property>
     <property>
        <name>dfs.namenode.secondary.http-address</name>
        <value>master:50090</value>
     </property>
     <property>
        <name>dfs.namenode.secondary.https-address</name>
        <value>master:50091</value>
     </property>
  
  </configuration>
  
  ```

* slaves 수정

  ```
  master로 수정
  ```

* hdfs namenode -format

* start-dfs.sh

* jps로 확인

  ```
  [root@master hadoop]# hdfs dfs -ls /
  [root@master hadoop]# hdfs dfs -ls /edudata
  ls: `/edudata': No such file or directory
  [root@master hadoop]# hdfs dfs -mkdir /edudata
  [root@master hadoop]# hdfs dfs -chmod 777 /edudata
  [root@master hadoop]# hdfs dfs -ls /
  Found 1 items
  drwxrwxrwx   - root supergroup          0 2019-09-09 14:48 /edudata
  [root@master hadoop]# cd ~/sampledata
  [root@master sampledata]# hdfs dfs -put 2008.csv
  put: `.': No such file or directory
  [root@master sampledata]# hdfs dfs -put 2008.csv /edudata 
  [root@master sampledata]# hdfs dfs -put fruit.txt /edudata 
  [root@master sampledata]# hdfs dfs -put president_moon.txt /edudata 
  [root@master sampledata]# hdfs dfs -cat president_moon.txt /edudata 
  cat: `president_moon.txt': No such file or directory
  cat: `/edudata': Is a directory
  [root@master sampledata]# hdfs dfs -cat /edudata/president_moon.txt 
  존경하고 사랑하는 국민 여러분 감사합니다. 국민 여러분의 위대한 선택에 머리 숙여 깊이 감사드립니다. 저는 오늘 대한민국 제19대 대통
  ```

* root/eclipse

* ./eclipse

* help - eclipse marketplace - scala - 체크된 것만 설치 - restart

# Scala

2004년 마틴 오더스키가 발표한 **객체 지향 언어 특징과 함수형 언어 특징을 함께 가지는** 다중 패러다임 프로그래밍 언어이다.

## 특징

* 자바가상머신(JVM)에서 동작하는 **JVML(Java Virtual Machine Language) 언어**이다. JVML언어에는 Scala, Kotlin, Groovy 등이 있다.
* 자바의 모든 라이브러리를 사용할 수 있다. 스칼라는 스칼라 컴파일러를 통해 스칼라 코드->바이트코드로 변환하고, 바이트 코드는 JVM 상에서 자바와 동일하게 실행된다.

* 함수형 언어
  1. 순수 함수 (pure function)를 지원한다.
  2. 익명 함수 (anonymous function)를 지원한다.
  3. 고차 함수 (higher-order function)를 지원한다.
* 바이트 코드를 최적화하여 자바보다 20%정도 속도가 빠르다.
* 동시성에 강하다. 스칼라는 변경 불가능한 Immutable 변수를 많이 가지고 있다. 속성을 변경 불가능하게 하고 순수함수를 사용하여 병렬 프로그래밍 처리에 강하다.

## 문법

* 변수 타입과 함수 리턴값이 뒤에 나온다. []는 java의 <>와 비슷하다. 

  ```scala
  //String값을 갖는 array타입의 args가 매개변수이다. void가 unit이다.
  object MyObject1 {
    def main(args: Array[String]):Unit = {
     println("Hello World main");
      }       
  }
  ```

  ``` scala
  //App을 상속받으면 main class에 들어갈 내용만 작성해주면 된다.
  object MyObject2 extends App{
    println("안녕? 스칼라");  
  }  
  ```

## 변수

* **val** 변수명 : 타입 -> **상수 : value(값을 한 번만 넣을 수 있다.)**

  var 변수명 : 타입 -> 변수 : variable

* val 변수명 : 타입 = 값

  var 변수명 : 타입 = 값

* val 변수명 = 값

  var 변수명 = 값

```scala
object StringPrefixApp extends App {
  val name = "duke"
  println("Hello! ${name}")
  println(s"Hello! ${name}") //s : 문자열을 넣어서 표현한다.
  println("${1 + 1}")
  println(s"${1 + 1}")
  val height : Double = 160.576
  val name1 = "dooly"
  println(f"$name1%s is $height%2.2f meters tall") // f : 실수를 넣어서 표현한다.
  println("$name1%s is $height%2.2f meters tall")
  val str = "AAA\nBBB"
  println(str)
  val rawStr = raw"AAA\nBBB" //raw : 개행문자를 일반문자로 표현한다.
  println(rawStr)
  println("---------------------------")
  println(name+height+name1+str)
  println(name,height,name1,str)
}
```

``` scala
//결과
Hello! ${name}
Hello! duke
${1 + 1}
2
dooly is 160.58 meters tall
$name1%s is $height%2.2f meters tall
AAA
BBB
AAA\nBBB
---------------------------
duke160.576doolyAAA
BBB
(duke,160.576,dooly,AAA
BBB)
```

## 함수

``` scala
object FunctionApp1  {
  def add1(x:Int, y:Int):Int = { //매개변수는 기본적으로 val이다.
    return x + y
    }
  def add2(x:Int, y:Int):Int = {
    x + y + 1000 //return을 주지 않아도 식의 결과값이 리턴된다.
    }
  def add2(x:Int):Int = {
    x * 1000
    }
  def add3(x:Int, y:Int):Unit = {
    println("Inner " + x + y)
    println("Inner " + (x + y))
    //x = 100
    }
  def main(args: Array[String]):Unit = {
   println(add1(10,20)) //30
   println(add2(10,20)) //1030
   println(add2(10)) //10000
   println(add3(10,20)) //Inner 1020 Inner 30
    }    
}
```

## 람다 함수

``` scala
object FunctionApp4 {
  def exec(fun:(Int, Int) => Int, x:Int, y:Int) = fun(x, y)

  def main(args: Array[String]):Unit = {
   var result = exec((x:Int, y:Int) => x+y, 2, 3)
   print(result) //5
   println("\n====================")
   result = exec((x, y) => x+y, 20, 30)
   print(result) //50
   println("\n====================")
   result = exec((x, y) => x*y, 2, 3)
   print(result) //6
   println("\n====================")
   result = exec(_*_, 20, 30)
   print(result) //600
   println("\n====================")
    }    
}
```

## 클래스

case 클래스는 toString, hashCode, equals 자동으로 생성된다. 등가연산자(=)로 객체값이 같은지 확인할 수 있다.

``` scala
case class Person6(name:String="또치", age:Int=10) { //toString, hashCode, equals 자동으로 생성된다.
  println(s"Person6 - ${name} : ${age} 생성")        
  def greeting() = println(s"${name}님은 ${age}세입니다.");
  def greeting(dong:String) = println(s"${name}님은 ${age}세이고 ${dong}에서 살고 있습니다.");
}


object ClassApp6 extends App {
  var p = Person6()
  p.greeting()
  p.greeting("쌍문동") 
  p.greeting
  println(p.toString)
  println(p.hashCode)
  var p1 = Person6("또치", 10)
  println(p == p1)
  var p2 = Person6("또치", 20)
  println(p == p2)
}
```

## Collection

Array

``` scala
object CollectionApp1 extends App {
  val ary1 = Array(10,20,30,40,50)
  println(ary1)
  println(ary1(0))
  println(ary1(4))
  println(ary1.length)
  ary1(4) = 500
    
  for(su <- ary1)
    print(su + " ")
  println()
  val ary2 = Array(1, true, false, 'A', "ABC", 3.14) //서로 다른 타입의 원소로 배열 생성이 가능하다.
  for(su <- ary2)
    print(su + " ")
  println()
  println(ary2.length)
  val ary3 = ary1 ++ ary2 //2개의 ary를 결합하여 새로운 ary를 생성한다.
  for(su <- ary3)
    print(su + " ")
  println()
  println(ary3.length)    
}
```

List

``` scala
val list1 = List(10,20,20,40)
  println(list1)
  println(list1.length)
  println(list1(0))
  //list1(6) = 100
  println(list1(3))
  val list2 = (1 to 10).toList
  val list3 = Array(100,200,300).toList
  println(list2)
  println(list3)
```

Set

``` scala
val set1 = Set(10,20,20,40)
  println(set1) //Set(10, 20, 40)
  println(set1.size)
  println(set1(0))
  println(set1(40))
  println(set1.last)
```

Tuple

``` scala
val tuple1 = ("java", "duke")
  println(tuple1._1)
  println(tuple1._2)
```

Map

``` scala
val map1 = Map(1 -> 2)
 val map2 = Map("foo" -> "bar")
```

