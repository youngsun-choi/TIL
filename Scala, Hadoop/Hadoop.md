# Hadoop

Hadoop = HDFS(저장)+MapReduce(파일처리)

* cluster

  여러 대의 컴퓨터들이 연결되어 하나의 시스템처럼 동작하는 컴퓨터들의 집합을 말한다.

* HDFS (하둡 분산 파일시스템) (저장소)

  **NameNode와 여러 개의 DataNode로 연결**된다. 명령어 또는 직접 프로그램을 만들어서(java) 사용한다. 파일을 block단위(128M 또는 128G)로 쪼개서 DataNode에 각각 저장한다. 

  DataNode는 주기적으로 **하트비트**를 NameNode에 보내 살아있음을 알린다. **SecondaryNameNode**는 meta 데이터를 주기적으로 갱신해준다. NameNode가 실행되지 않는 것을 염려해 active NameNode, standby NameNode로 나눠 준비할 수도 있다.
  
  대용량 파일을 저장할 수 있다는 것을 빼고는 일반 파일 시스템과 비슷하다.

* **데몬(daemon) 프로세스**

  background에서 수행 중인 프로그램을 뜻한다. 보통 끝에가 xxxxd로 끝난다. ex) httpd, pop3d

  start-dfs.sh : 데몬 프로세스를 

  ps -ef : 모든 프로세스를 보여준다.

  **jps(JVM Process Status)** : 현재 jvm에 의해 수행된 프로세스를 보여준다.

  ```
  [4개 머신]
  master : NameNode
  slave1 : SecondaryNameNode, DataNode
  slave2 : DataNode
  slave3 : DataNode
  ```

* write ones read many ~

---

* **MapReduce**

  구글에서 대용량 데이터 처리를 분산 병렬 컴퓨팅에서 처리하기 위한 목적으로 제작하여 발표한 소프트웨어 프레임워크다.

  

* **YARN** (Cluster Resource Management)

  자원관리만 전문적으로 한다. 

  Resource Manager 

  Node Manager

  Application Master : 작업 실행을 시작하면 기동되고 시작이 끝나면 사라진다. (중간관리자 역할을 한다.)

  Hadoop 1.x 는 mapreduce만 제공한다.

---

## **Apache Hive**

Apache Hive 데이터웨어 하우스 소프트웨어는 행과 열 구조로 데이터를 다룰 수 있을 때 사용한다. SQL을 사용하여 분산 스토리지에 있는 대규모 데이터 세트의 읽기, 쓰기, 관리를 용이하게 한다. MapReduce 기반의 High-level abstraction(추상화 객체)이다.

특징

1. **HiveQL**과 같은 SQL-like 언어를 사용한다.
2. Hadoop 클러스터에서 MapReduce Job을 생성한다.
3. Facebook에서 데이터 웨어하우스를 위해 개발되었다.
4. 데이터 포멧과 위치를 가지고 있는 **metastore**을 가지고 있다.

데이터 레이크 > 데이터 웹어하우스 > 데이터 마트

---

## Apache Spark

Apache Spark는 오픈 소스 클러스터 컴퓨팅 프레임워크이다. MapReduce를 대신하기위해 나왔다. MapReduce는 처리할 대상과 결과를 hdfs에 저장한다.  따라서 disk io 에서 수행이 많아 수행속도가 느려진다. Spark의 경우에는 인메모리에서 수행해 수행속도가 MapReduce보다 빠르다.  

* RDD(Resilient Distributed Datasets)
  1. **인메모리 기반**으로 데이터를 처리한다.
  2. spark에서는 내부적으로 연산하는 데이터들을 모두 RDD타입으로 처리한다.
  3. **Scala, Python, Java, R** 언어를 사용한다.
  4. 분산된 레코드들이 만들어진 뒤에는 변하지 않는다. (Immutable)
  5. 데이터 셋을 잘게 잘라서 분산한다. (Partitioned)

* RDD를 제어하는 API Operation 타입

  * **Transformation** : RDD에서 새로운 RDD를 생성하는 함수이다.

    ex) map(), flatMap(), filter() 등

  * **Action** : RDD에서 RDD가 아닌 타입의 data로 변환하는 함수이다.

    ex) reduce(), count(), collect() 등

  * **Fault-Tolerant** 확보가 가능하다. Lineage만 기록해두면 동일한 RDD를 생성할 수 있으므로 오류가 발생했을 때 스스로 복구할 수 있다.

  * RDD 객체 특징

    1. Read Only이다.

    2. 1~n 개의 partition으로 구성된다.

    3. RDD 연산은 Transformation과 Action으로 나뉜다.

    4. Transformation은 Lazy-execution을 지원한다.

       **Lazy-execution** 이란?

       Action 연산이 실행되기 전에는 Transformation 연산이 처리되지 않는 것을 의미한다.

    5. Lineage를 통해서 Fault-Tolerant를 확보한다.

       **Lineage**란?

       Transformation 연산 정보를 보관한 것을  Lineage라 한다.

* 인터랙티브 방식과 프로그램적 방식이 있다. 인터랙티브 방식은 명령어를 입력하면 결과가 바로 나오는 방식이다.
* ./eclipse& : background에서 이클립스가 실행된다.
* jar tvf wc7.jar : a