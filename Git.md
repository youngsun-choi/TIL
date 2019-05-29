# Git

## 1. Git 이란?

* **버전 관리 시스템**(VCS : Version Control System) 이다.

* 기능

  1. Git을 이용하면 하나의 파일이름으로 버전 관리 할 수 있다.

     예를 들어  발표자료_최종본.pptx, 발표자료_진짜_최종본.pptx, 발표자료__정말_최종본.pptx 이라는 파일이있을 때, 버전관리를 발표자료_최종본.pptx 하나로 할 수 있다. 

  2. 다른사람과 협업할 수 있다.

* 구조

  * git 구조도 이미지
  * **Working Directory** : 현재 작업하고 있는 디렉토리를 말한다.
  * **Stage Area** : 커밋이 되기위해 대기하는 파일이 저장된다. 
  * **Repository** : 저장소이다.
    * Local Repository : 자신의 PC에 존재하는 저장소를 말한다.
    * Remote Repository : Github와 같은 원격 저장소를 말한다.

## 2. Git 명령어

* git : git에서 사용 가능한 명령어 리스트를 보여준다.

* git init : 현재 디렉토리에서 버전 관리한다는 것을 깃에게 알려준다. 

* pwd : 현재 디렉토리 경로를 보여준다.

* ls -al : 현재 디렉토리의 파일 목록을 보여준다.

  * .git 파일목록 : 버전관리와 관련 정보가 저장된다. 

* vim 편집기

  - i : 입력모드로 상태가 바뀐다.
  - esc + :wq : 입력모드에서 나간 뒤 현재 내용을 저장하고 vim 편집기에서 완전히 나간다.
  
* cat [파일 이름] : 현재 파일의 내용을 읽는다.

* git add [파일 이름] : 깃에게 버전 관리해야할 파일을 알려준다. 

  * add 명령어를 사용하는 경우
    * 최초로 파일을 추적할 때
    * 파일이 수정된 후 버전을 만들기 전
  * 커밋 전에 add 명령어를 사용하는 이유 : 원하는 파일만 선택적으로 커밋할 수 있게 하기 위해서이다.
  * git add를 하면 커밋 대기상태(stage area)로 들어간다.
  * stage -  repository 
    * stage : 커밋이 되기를 대기 하고 있는 파일이 저장된다.
    * repository : - 커밋이 된 결과가 저장된다.

* git status : 현재 저장소의 상태가 어떤지 알아본다.

* git 사용자 설정 (1번만)

  git config --global user.name [자신의 이름]
  git config --global user.email [자신의 이메일]

* git commit : 현재 버전에서 어떤 것이 변경되었는지 메시지를 적는다.  (커밋 메시지)

* git log : 저장소의 커밋 히스토리를 시간순으로 보여준다.

* 변경사항 확인하기
  * git log -p : 로그에서 출력되는 버전 간의 차이점을 출력한다.
  * git diff [버전 id]..[버전 id2] : 입력한 두 버전 간의 차이점을 비교한다.
  * git diff : git add하기 전과 add한 후의 파일 내용을 비교한다.
  
* 과거의 버전으로 돌아가기
  * reset : 원격 저장소에 파일을 올리고 난 뒤에는 reset 하지 않는 것이 좋다.
  * revert
  
* git 파일 삭제

  * git rm [File Name] : 원격 저장소와 로컬 저장소에 있는 파일을 삭제한다.
  * git rm --cached [File Name] : 원격 저장소에 있는 파일만 삭제한다.
  
* git commit -am [커밋하고자 하는 내용] : add와 commit을 같이 한다.

* 버전이란?
  
  * 작업이 있으면 작업에서 완결된 상태가 있는 것이 버전이다.