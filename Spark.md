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

## 자료구조

### RDD 

대량의 데이터를 요소로 가지는 분산 컬렉션이다. RDD는 배열, 리스트 등의 요소를 저장하며, 내부는 여러 개의 파티션으로 구분된다. 불변의 성질이 있다.

### 변환

* filter
* map : 각 분리된 내용으로 
* flatmap : 각 요소를 쪼개 하나로 묶어서 여러 개의 요소를 생성해 처리한다.
* zip : 한 쪽의 요소값을 키로, 다른 한쪽의 요소값을 value로 가지는 쌍을 만든다.
* reduceByKey : key 별로 함수를 적용해 같은 키를 가지는 요소를 집약처리한다. 다른 머신 간의 이동인 셔플이 일어난다.
* join : 두 개의 RDD에서 같은 키를 가지는 요소끼리 조인한다.

### 액션

* saveAsTextFile : RDD의 내용을 파일로 출력한다. 파티션 단위로 파일이 만들어진다.
* count : RDD의 요소 개수를 센다.
* collect : RDD의 요소를 꺼내 array로 리턴한다.

### 지연수행

**최초로 수행되는 액션이 있을 때 수행된다.**

``` scala
val textRDD = sc.textFile("/path/to/simple-words.txt") //에러 발생 안함
val textArray = textRDD.collect //파일 경로가 맞지 않아 에러발생
//org.apache.hadoop.mapred.InvalidInputException: Input path does not exist: hdfs://master:9000/path/to/simple-words.txt
```

``` scala
val textRDD = sc.textFile("file:///root/sampledata/simple-words.txt")
val textArray = textRDD.collect
textArray.foreach(println)
```

``` scala
//결과
cat
dog
.org
cat
cat
&&
tiger
dog
100
tiger
cat
```



### RDD 영속화 

RDD에 대한 정보를 하드디스크에 저장해놓다가 필요한 경우 메모리에 올린다. spark와 mapreduce의 다른 점은 메모리에 계속 올려놓고 사용할 수 있다는 것이다.

## 에러

아래와 같은 오류가 났을 때는 cd $HADOOP_HOME - hdfs dfs mkdir /spark logs 수행한다. 

``` 
java.io.FileNotFoundException: File does not exist: hdfs://192.168.111.120:9000/spark-logs
	at org.apache.hadoop.hdfs.DistributedFileSystem$22.doCall(DistributedFileSystem.java:1309)
	at org.apache.hadoop.hdfs.DistributedFileSystem$22.doCall(DistributedFileSystem.java:1301)
	at org.apache.hadoop.fs.FileSystemLinkResolver.resolve(FileSystemLinkResolver.java:81)
	at org.apache.hadoop.hdfs.DistributedFileSystem.getFileStatus(DistributedFileSystem.java:1317)
	at org.apache.spark.scheduler.EventLoggingListener.start(EventLoggingListener.scala:97)
	at org.apache.spark.SparkContext.<init>(SparkContext.scala:523)
	at org.apache.spark.SparkContext$.getOrCreate(SparkContext.scala:2520)
	at org.apache.spark.sql.SparkSession$Builder$$anonfun$7.apply(SparkSession.scala:935)
	at org.apache.spark.sql.SparkSession$Builder$$anonfun$7.apply(SparkSession.scala:926)
	at scala.Option.getOrElse(Option.scala:121)
	at org.apache.spark.sql.SparkSession$Builder.getOrCreate(SparkSession.scala:926)
	at org.apache.spark.repl.Main$.createSparkSession(Main.scala:106)
	at $line3.$read$$iw$$iw.<init>(<console>:15)
	at $line3.$read$$iw.<init>(<console>:43)
	at $line3.$read.<init>(<console>:45)
	at $line3.$read$.<init>(<console>:49)
	at $line3.$read$.<clinit>(<console>)
	at $line3.$eval$.$print$lzycompute(<console>:7)
	at $line3.$eval$.$print(<console>:6)
	at $line3.$eval.$print(<console>)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at scala.tools.nsc.interpreter.IMain$ReadEvalPrint.call(IMain.scala:793)
	at scala.tools.nsc.interpreter.IMain$Request.loadAndRun(IMain.scala:1054)
	at scala.tools.nsc.interpreter.IMain$WrappedRequest$$anonfun$loadAndRunReq$1.apply(IMain.scala:645)
	at scala.tools.nsc.interpreter.IMain$WrappedRequest$$anonfun$loadAndRunReq$1.apply(IMain.scala:644)
	at scala.reflect.internal.util.ScalaClassLoader$class.asContext(ScalaClassLoader.scala:31)
	at scala.reflect.internal.util.AbstractFileClassLoader.asContext(AbstractFileClassLoader.scala:19)
	at scala.tools.nsc.interpreter.IMain$WrappedRequest.loadAndRunReq(IMain.scala:644)
	at scala.tools.nsc.interpreter.IMain.interpret(IMain.scala:576)
	at scala.tools.nsc.interpreter.IMain.interpret(IMain.scala:572)
	at scala.tools.nsc.interpreter.IMain$$anonfun$quietRun$1.apply(IMain.scala:231)
	at scala.tools.nsc.interpreter.IMain$$anonfun$quietRun$1.apply(IMain.scala:231)
	at scala.tools.nsc.interpreter.IMain.beQuietDuring(IMain.scala:221)
	at scala.tools.nsc.interpreter.IMain.quietRun(IMain.scala:231)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1$$anonfun$apply$mcV$sp$1.apply(SparkILoop.scala:109)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1$$anonfun$apply$mcV$sp$1.apply(SparkILoop.scala:109)
	at scala.collection.immutable.List.foreach(List.scala:392)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1.apply$mcV$sp(SparkILoop.scala:109)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1.apply(SparkILoop.scala:109)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1.apply(SparkILoop.scala:109)
	at scala.tools.nsc.interpreter.ILoop.savingReplayStack(ILoop.scala:91)
	at org.apache.spark.repl.SparkILoop.initializeSpark(SparkILoop.scala:108)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1$$anonfun$org$apache$spark$repl$SparkILoop$$anonfun$$loopPostInit$1$1.apply$mcV$sp(SparkILoop.scala:211)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1$$anonfun$org$apache$spark$repl$SparkILoop$$anonfun$$loopPostInit$1$1.apply(SparkILoop.scala:199)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1$$anonfun$org$apache$spark$repl$SparkILoop$$anonfun$$loopPostInit$1$1.apply(SparkILoop.scala:199)
	at scala.tools.nsc.interpreter.ILoop$$anonfun$mumly$1.apply(ILoop.scala:189)
	at scala.tools.nsc.interpreter.IMain.beQuietDuring(IMain.scala:221)
	at scala.tools.nsc.interpreter.ILoop.mumly(ILoop.scala:186)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1.org$apache$spark$repl$SparkILoop$$anonfun$$loopPostInit$1(SparkILoop.scala:199)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1$$anonfun$startup$1$1.apply(SparkILoop.scala:267)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1$$anonfun$startup$1$1.apply(SparkILoop.scala:247)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1.withSuppressedSettings$1(SparkILoop.scala:235)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1.startup$1(SparkILoop.scala:247)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1.apply$mcZ$sp(SparkILoop.scala:282)
	at org.apache.spark.repl.SparkILoop.runClosure(SparkILoop.scala:159)
	at org.apache.spark.repl.SparkILoop.process(SparkILoop.scala:182)
	at org.apache.spark.repl.Main$.doMain(Main.scala:78)
	at org.apache.spark.repl.Main$.main(Main.scala:58)
	at org.apache.spark.repl.Main.main(Main.scala)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.spark.deploy.JavaMainApplication.start(SparkApplication.scala:52)
	at org.apache.spark.deploy.SparkSubmit.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:849)
	at org.apache.spark.deploy.SparkSubmit.doRunMain$1(SparkSubmit.scala:167)
	at org.apache.spark.deploy.SparkSubmit.submit(SparkSubmit.scala:195)
	at org.apache.spark.deploy.SparkSubmit.doSubmit(SparkSubmit.scala:86)
	at org.apache.spark.deploy.SparkSubmit$$anon$2.doSubmit(SparkSubmit.scala:924)
	at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:933)
	at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
19/09/11 14:27:54 ERROR Main: Failed to initialize Spark session.
java.io.FileNotFoundException: File does not exist: hdfs://192.168.111.120:9000/spark-logs
	at org.apache.hadoop.hdfs.DistributedFileSystem$22.doCall(DistributedFileSystem.java:1309)
	at org.apache.hadoop.hdfs.DistributedFileSystem$22.doCall(DistributedFileSystem.java:1301)
	at org.apache.hadoop.fs.FileSystemLinkResolver.resolve(FileSystemLinkResolver.java:81)
	at org.apache.hadoop.hdfs.DistributedFileSystem.getFileStatus(DistributedFileSystem.java:1317)
	at org.apache.spark.scheduler.EventLoggingListener.start(EventLoggingListener.scala:97)
	at org.apache.spark.SparkContext.<init>(SparkContext.scala:523)
	at org.apache.spark.SparkContext$.getOrCreate(SparkContext.scala:2520)
	at org.apache.spark.sql.SparkSession$Builder$$anonfun$7.apply(SparkSession.scala:935)
	at org.apache.spark.sql.SparkSession$Builder$$anonfun$7.apply(SparkSession.scala:926)
	at scala.Option.getOrElse(Option.scala:121)
	at org.apache.spark.sql.SparkSession$Builder.getOrCreate(SparkSession.scala:926)
	at org.apache.spark.repl.Main$.createSparkSession(Main.scala:106)
	at $line3.$read$$iw$$iw.<init>(<console>:15)
	at $line3.$read$$iw.<init>(<console>:43)
	at $line3.$read.<init>(<console>:45)
	at $line3.$read$.<init>(<console>:49)
	at $line3.$read$.<clinit>(<console>)
	at $line3.$eval$.$print$lzycompute(<console>:7)
	at $line3.$eval$.$print(<console>:6)
	at $line3.$eval.$print(<console>)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at scala.tools.nsc.interpreter.IMain$ReadEvalPrint.call(IMain.scala:793)
	at scala.tools.nsc.interpreter.IMain$Request.loadAndRun(IMain.scala:1054)
	at scala.tools.nsc.interpreter.IMain$WrappedRequest$$anonfun$loadAndRunReq$1.apply(IMain.scala:645)
	at scala.tools.nsc.interpreter.IMain$WrappedRequest$$anonfun$loadAndRunReq$1.apply(IMain.scala:644)
	at scala.reflect.internal.util.ScalaClassLoader$class.asContext(ScalaClassLoader.scala:31)
	at scala.reflect.internal.util.AbstractFileClassLoader.asContext(AbstractFileClassLoader.scala:19)
	at scala.tools.nsc.interpreter.IMain$WrappedRequest.loadAndRunReq(IMain.scala:644)
	at scala.tools.nsc.interpreter.IMain.interpret(IMain.scala:576)
	at scala.tools.nsc.interpreter.IMain.interpret(IMain.scala:572)
	at scala.tools.nsc.interpreter.IMain$$anonfun$quietRun$1.apply(IMain.scala:231)
	at scala.tools.nsc.interpreter.IMain$$anonfun$quietRun$1.apply(IMain.scala:231)
	at scala.tools.nsc.interpreter.IMain.beQuietDuring(IMain.scala:221)
	at scala.tools.nsc.interpreter.IMain.quietRun(IMain.scala:231)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1$$anonfun$apply$mcV$sp$1.apply(SparkILoop.scala:109)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1$$anonfun$apply$mcV$sp$1.apply(SparkILoop.scala:109)
	at scala.collection.immutable.List.foreach(List.scala:392)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1.apply$mcV$sp(SparkILoop.scala:109)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1.apply(SparkILoop.scala:109)
	at org.apache.spark.repl.SparkILoop$$anonfun$initializeSpark$1.apply(SparkILoop.scala:109)
	at scala.tools.nsc.interpreter.ILoop.savingReplayStack(ILoop.scala:91)
	at org.apache.spark.repl.SparkILoop.initializeSpark(SparkILoop.scala:108)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1$$anonfun$org$apache$spark$repl$SparkILoop$$anonfun$$loopPostInit$1$1.apply$mcV$sp(SparkILoop.scala:211)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1$$anonfun$org$apache$spark$repl$SparkILoop$$anonfun$$loopPostInit$1$1.apply(SparkILoop.scala:199)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1$$anonfun$org$apache$spark$repl$SparkILoop$$anonfun$$loopPostInit$1$1.apply(SparkILoop.scala:199)
	at scala.tools.nsc.interpreter.ILoop$$anonfun$mumly$1.apply(ILoop.scala:189)
	at scala.tools.nsc.interpreter.IMain.beQuietDuring(IMain.scala:221)
	at scala.tools.nsc.interpreter.ILoop.mumly(ILoop.scala:186)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1.org$apache$spark$repl$SparkILoop$$anonfun$$loopPostInit$1(SparkILoop.scala:199)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1$$anonfun$startup$1$1.apply(SparkILoop.scala:267)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1$$anonfun$startup$1$1.apply(SparkILoop.scala:247)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1.withSuppressedSettings$1(SparkILoop.scala:235)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1.startup$1(SparkILoop.scala:247)
	at org.apache.spark.repl.SparkILoop$$anonfun$process$1.apply$mcZ$sp(SparkILoop.scala:282)
	at org.apache.spark.repl.SparkILoop.runClosure(SparkILoop.scala:159)
	at org.apache.spark.repl.SparkILoop.process(SparkILoop.scala:182)
	at org.apache.spark.repl.Main$.doMain(Main.scala:78)
	at org.apache.spark.repl.Main$.main(Main.scala:58)
	at org.apache.spark.repl.Main.main(Main.scala)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.apache.spark.deploy.JavaMainApplication.start(SparkApplication.scala:52)
	at org.apache.spark.deploy.SparkSubmit.org$apache$spark$deploy$SparkSubmit$$runMain(SparkSubmit.scala:849)
	at org.apache.spark.deploy.SparkSubmit.doRunMain$1(SparkSubmit.scala:167)
	at org.apache.spark.deploy.SparkSubmit.submit(SparkSubmit.scala:195)
	at org.apache.spark.deploy.SparkSubmit.doSubmit(SparkSubmit.scala:86)
	at org.apache.spark.deploy.SparkSubmit$$anon$2.doSubmit(SparkSubmit.scala:924)
	at org.apache.spark.deploy.SparkSubmit$.main(SparkSubmit.scala:933)
	at org.apache.spark.deploy.SparkSubmit.main(SparkSubmit.scala)
```









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

## 주요 메서드

- parallelize() : 스칼라컬렉션 객체를 이용해서 **RDD 객체를 생성**
- count() : RDD의 **요소 개수를 리턴**
- first() : RDD 객체의 **첫 번째 요소를 리턴**
- collect() : RDD 객체의 모든 요소를 **배열로 리턴**
- map() : 입력 RDD의 모든 요소에 function을 적용한 결과를 저장한 RDD 반환
- flatMap() : 입력 RDD의 모든 요소에 function을 적용하고 **모든 요소를 하나로 묶어서 반환**
- filter() : 입력 RDD의 모든 요소에 function을 수행하고 **참을 리턴하는 결과만 저장한 RDD 반환**
- reduce() : 지정된 function을 수행해 입력 RDD의 개수를 축소시켜 생성된 RDD를 반환
- reduceByKey() : 키값을 기준으로 function을 수행하고 RDD반환
- groupBy() : 입력 RDD의 모든 요소에 function을 적용한 결과로 grouping된 RDD를 반환

## 정규식

POSIX Character Classes

* """\p{Alnum}+""" : 숫자 또는 문자가 1 개 이상
* """\p{Alnum}*""" :  숫자 또는 문자가 0 개 이상
* """\p{Alnum}?""" : 숫자 또는 문자가 0개 또는 1개 이상

