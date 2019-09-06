# Spring Scheduling(Task)

Spring에서는 특정 시간에 반복적으로 처리되는 코드를 스케줄링할 수 있는 방법을 지원한다. 이때 반복적으로 수행되는 코드를 **Task**라고 한다. 

## Task 수행환경설정

servlet-context에 추가

```
<task:annotation-driven/>
```

## Task 기능의 메서드 정의

Task 메서드 앞에 @Scheduled 애노테이션을 다음에 제시한 속성 중 하나를 정의하여 추가한다.

*  cron : CronTab에서의 설정과 같이 cron="10 * * * * *" 과 같은 설정이 가능하다.
* fixedDelay : 이전에 실행된 task의 종료시간으로 부터 정의된 시간만큼 지난 후 Task를 실행한다.
* fixedRate : 이전에 실행된 task의 시작시간으로 부터 정의된 시간만큼 지난 후 Task를 실행한다.