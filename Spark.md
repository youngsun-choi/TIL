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