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

## Spark

