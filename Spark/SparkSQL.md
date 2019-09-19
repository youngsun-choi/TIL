# Spark and SQL

## 설정

1. hive-site.xml ${SPARK_HOME}/conf에 배치한다.
2. vi hive-site.xml 에서 명령모드 :745 줄의 metastore verification을 false 값으로 변경한다. (hive와 스파크SQL의 버전차이 때문)

``` scala
val dessertRDD = sc.textFile("file:///root/sampledata/dessert-menu.csv")
val dessertDF = dessertRDD.map{record =>
     | val splitRecord = record.split(",")
     | val menuId = splitRecord(0)
     | val name = splitRecord(1)
     | val price = splitRecord(2).toInt
     | val kcal = splitRecord(3).toInt
     | Dessert(menuId,name,price,kcal)
     | }.toDF
dessertDF.printSchema
root
 |-- menuId: string (nullable = true)
 |-- name: string (nullable = true)
 |-- price: integer (nullable = false)
 |-- kcal: integer (nullable = false)

```

``` scala
hdfs dfs -put /root/sampledata/dessert-menu.csv /edudata
val dessertRDD = sc.textFile("/edudata/dessert-menu.csv")
```

