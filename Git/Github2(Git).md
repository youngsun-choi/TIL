# Github 특강2

## Git, DVCS (Distributed Version Control System)

* Git은 분산버전관리시스템이다.

* Git은 3공간으로 나뉜다.

  ​						git add						git commit

  Working Directory -> Index(Staging Area) -> 저장소 

## 기본 명령어

1. 저장소 초기화 : git init 
2. git add
3. git commit
4. history : 지금까지 사용한 명령어를 확인

## Git 되돌리기

1. commit 메시지 수정

   ```bash
   git commit --amend
   ```

   - git bash에서 vim이 실행된다.
   - 편집모드(i) 상태에서 수정후 **esc+:wq**
   - push : **원격저장소에 올린 이후에는 진행하면 충돌이 무조건 발생**한다.
   - **커밋을 다시 하게 되면 해시값이 변경되기 때문이다!** (이력이 바뀐다.)

2. Staging Area(INDEX)에서 취소하기

   ```bash
   $ git reset HEAD 파일명
   $ git status
   On branch master
   Your branch is ahead of 'origin/master' by 1 commit.
     (use "git push" to publish your local commits)
   
   Changes to be committed:
     (use "git reset HEAD <file>..." to unstage)
   
           modified:   "백준알고리즘/1001.py"
   
   Untracked files:
     (use "git add <file>..." to include in what will be committed)
   
           Programmers/
   
   ```

3. git 이력에서 특정 파일 삭제 커밋

   ```bash
   $ git rm --cached 파일명 
   ```

   * 한 번도 커밋된 이력이 없을 때에는 Staging Area에서 취소하는 것과 동일함.

   * 다만, 커밋에 포함된 적이 있는 경우에는 삭제 커밋이 됨.

     **(실제 파일은 삭제되지 않음!)**

4. 특정 파일 포함해서 다시 커밋

   ```bash
   $ git add a.py
   $ git commit -m 'a, b추가'
   $ git add b.py
   $ git commit --amend
   ```

   * commit 메시지를 수정하기 전에 Staging Area에 변경을 해주면, 해당 파일까지 포함하여 다시 커밋을 진행함.

5. 현재 작업내역 커밋 시점으로 되돌리기 **(주의!!!)**

   ```bash
   $ git checkout -- 파일명 또는 디렉토리명
   ```

   * 예를 들어, 특정 파일을 삭제하였거나 혹은 코드 수정과정에서 오류가 많이 발생하여 직전 커밋 시점 상태로 돌아가고 싶을 때 사용이 가능함.
   * 중요한 내용은 반드시 커밋을 해두어야 돌아갈 수 있다!!

## Git reset vs. revert

* revert : commit이 발생하면서 되돌아간다. 이력 자체를 초기화한다.
* reset : commit이 발생하지 않고 되돌아간다.

## gitignore

* gitignre 파일에 적은 확장자 파일은 무시한다.
* [gitignore.io 사이트](<https://www.gitignore.io/>)

## 원격저장소(Github) 활용하기

1. 원격저장소 설정

   ``` bash
   $ git remote add origin {url}
   ```

2. 원격저장소 확인

   ``` bash
   $ git remote -v
   origin  https://github.com/youngsun-choi/dummy.git (fetch)
   origin  https://github.com/youngsun-choi/dummy.git (push)
   ```

3. 원격저장소에 push

   ``` bash
   $ git push origin master
   ```

   * origin을 붙여놓은 master branch로 파일을 올린다.

4. 원격저장소 삭제

   ``` bash
   $ git remote rm origin
   ```

5. 원격저장소 복제

   ``` bash
   $ git clone {url}
   ```

   * 로컬에 원격저장소를 받아오고 싶다면, clone을 통해 가져온다!
   * 이후에는 push-pull을 통해서 업데이트한다.

## 충돌 해결하기(Merge Conflict)

> 기본적으로 push-pull 하는 과정에서 동일한 파일의 다른 이력이 기록될 경우 충돌이 발생한다!
>
> 다른 파일이 수정되는 경우 fast-forwarding을 통해 자동으로 merge가 되기도 함!
>
> 이러한 오류를 발생시키지 않으려면, 항상 작업하기 전에 pull을 확인하고, 작업 및 커밋을 한 이후에 push를 하는 것을 습관화 하자!

1. Local A에서 a.txt 작성 후 커밋

2. Local A에서 원격저장소(Origin)로 push

3. Local B에서 pull 하지 않은 상태에서 a.txt 동일한 라인 작성 후 커밋

4. Local B에서 원격저장소(Origin)로 push -> push 되지 않음! **merge conflict 발생!**

5. 해결

   ``` bash
   $ git pull origin master
   ```

6. 충돌 발생 (동일 파일 수정시)

   * 어떤 파일에서 충돌되었는지 확인하는 명령어

   ``` bash
   $ git diff
   $ git log --oneline --left-right -p
   ```

   * Git에서 직접 충돌 파일에 기록을 남겨줌.

   ``` bash
   <<<<<<< HEAD
   집에서 수정 내용
   =======
   멀캠에서 수정 내용
   >>>>>>> 71be1eec331d8fc12a3a1f6fdf757981c422b447
   ```

   * Head : 현재 작업하고 있는 곳 (Local B)
   * 해쉬값 : pull 을 통해 받아온 변경사항 (Origin)
   * 해당하는 위치를 찾아서 직접 수정을 하면된다.

7. merge conflict 해결 commit 남기기

   ``` bash
   $ git status
   $ git add .
   $ git commit -m 'Merge conflict 해결'
   ```

8. 원격저장소로 push

   ``` bash
   $ git push origin master
   ```

## github.io 페이지 만들기

1. [github.io 템플릿 사이트](<https://startbootstrap.com/>)

2. .travis, gulpfile, package, package-lock 파일 삭제!!!

3. 해당 폴더에서 git init, add, commit

4. github.io repository 만들기

5. git remote add origin {url}

6. git push -u origin master

7. visual studio code - Extensions - open in browser 설치 - Alt+B

---

## 참고자료

* 커밋 메시지

  [좋은 git 커밋 메시지 작성법](<https://meetup.toast.com/posts/106>)

  [git 커밋 낱말 사전](<https://blog.ull.im/engineering/2019/03/10/logs-on-git.html>)

* TIL 예시

  <https://github.com/edutak/algorithms>

  <https://gist.github.com/edutak/0b3ec40bdecbc9bad074e8df1e5a7998>

* 잘 정리된 예시

  [기술 면접 가이드 github](<https://github.com/JaeYeopHan/Interview_Question_for_Beginner>)

  [주니어 개발자를 위한 취업 정보](<https://github.com/jojoldu/junior-recruit-scheduler>)

  [논산](<https://github.com/krta2/awesome-nonsan>)

  [한국 자율 출퇴근 혹은 원격 근무가 되는 회사](<https://github.com/milooy/remote-or-flexible-work-company-in-korea> )

  [Github Visuallizing](<https://git-school.github.io/visualizing-git/#free-remote>)
