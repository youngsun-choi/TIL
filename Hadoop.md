# Hadoop

Hadoop = HDFS(저장)+MapReduce(파일처리)->upgrade시킨게 spark이다.

* cluster

  여러 대의 컴퓨터들이 연결되어 하나의 시스템처럼 동작하는 컴퓨터들의 집합을 말한다.

* HDFS (하둡분산파일시스템)

  **NameNode와 여러 개의 DataNode로 연결**된다. 명령어 또는 직접 프로그램을 만들어서(java) 사용한다. 파일을 block단위(128M 또는 128G)로 쪼개서 같은 rack에 2개 다른 rack에 1개를 저장한다. 

  DataNode는 주기적으로 **하트비트**를 NameNode에 보내 살아있음을 알린다. **SecondaryNameNode**는 meta 데이터를 주기적으로 갱신해준다. NameNode가 실행되지 않는 것을 염려해 active NameNode, standby NameNode로 나눠 준비할 수도 있다.