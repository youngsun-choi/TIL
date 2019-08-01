# Hadoop

Hadoop = HDFS(저장)+MapReduce(파일처리)

* cluster

  여러 대의 컴퓨터들이 연결되어 하나의 시스템처럼 동작하는 컴퓨터들의 집합을 말한다.

* HDFS (하둡 분산 파일시스템) (저장소)

  **NameNode와 여러 개의 DataNode로 연결**된다. 명령어 또는 직접 프로그램을 만들어서(java) 사용한다. 파일을 block단위(128M 또는 128G)로 쪼개서 DataNode에 각각 저장한다. 

  DataNode는 주기적으로 **하트비트**를 NameNode에 보내 살아있음을 알린다. **SecondaryNameNode**는 meta 데이터를 주기적으로 갱신해준다. NameNode가 실행되지 않는 것을 염려해 active NameNode, standby NameNode로 나눠 준비할 수도 있다.
  
  대용량 파일을 저장할 수 있다는 것을 빼고는 일반 파일 시스템과 비슷하다.

* 데몬(daemon) 프로세스

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

