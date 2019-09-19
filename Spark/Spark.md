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

 