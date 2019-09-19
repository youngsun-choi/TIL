# Spark and R

* [R document](https://spark.apache.org/docs/2.4.3/api/R/)

HDFS의 /edudata 폴더의 product_click.log 파일을 읽고 Product Id 별 갯수를 세서 다음과 같이 클릭수가 많은 순으로 출력하는 Spark R 코드를 작성한다.


``` SPARQL
> df <- read.df("/edudata/product_click.log", source="csv", delimiter=" ")
> colnames(df)<-c("date","pid")
> g <- groupBy(df,"pid")
> ag <- agg(g,pid="count")
> colnames(ag)<-c("pid","cnt")
> result <- arrange(ag,desc(ag$cnt))
> showDF(result)
+----+---+                                                                      
| pid|cnt|
+----+---+
|p001| 84|
|p008| 80|
|p009| 80|
|p007| 71|
|p002| 66|
|p010| 58|
|p003| 54|
|p006| 51|
|p004| 50|
|p011| 49|
|p005| 43|
|p012| 39|
|p014| 10|
|p015|  7|
|p013|  4|
+----+---+
```

