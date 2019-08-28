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

   * commit 메시지를 수정하기 전에 Staging Area를 변경 해주면, 해당 파일까지 포함하여 다시 커밋을 진행함.

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

##  Branch 활용하기

> git init을 하였을 때 (master)는 사실 master 브랜치에 있다라는 사실을 보여주고 있는 것이다.

1. branch 생성

   ``` bash
   (master) $ git branch {branch이름}
   (master) $ git branch
   *master
   {branch이름}
   ```

2. branch 이동

   ```bash
   $ git checkout {branch이름}
   ```

   * 위 두 명령어를 동시에 실행하려면 아래와 같이 한다.

   ``` bash
   (위에 2문장을 한 번에 사용)
   (master) $ git checkout -b {branch이름} 
   ```

3. branch 삭제

   ```bash
   $ git branch -d {branch이름} 
   ```

4. branch 병합

   ```bash
   
   ```

   * master branch에  feature/footer을 병합한다.
   * 항상 병합을 하고 싶은 대상의 branch로 옮겨서 진행해야 한다.
   * 병합시에 발생할 수 있는 상황은 아래와 같다.

   

## Git merge

## 1. Fast-forwarding

실제로 branch를 나눈 이후에 master branch에 커밋이 발생하지 않았고, 단순히 커밋 만 옮기면 되는 경우, merge 커밋이 발생하지 않는다.

## 2. Auto Merge

branch를 나눈 이후에 master branch에 커밋이 발생하였으나, 동일한 파일이 수정되지 않아서 자동으로 병합이 되는 경우, merge 커밋이 발생한다.

``` bash
$ git log --graph --oneline
* 417b2a4 (HEAD -> master) Fix a.txt, b.txt
*   bd3bae8 Merge branch 'feature/footer'
|\
| * 3dbf644 (feature/footer) Complete footer
* | 5e0db6c README 추가
|/
*   03c091b Merge branch 'feature/main'
|\
| * a3d95c6 Complete mian feature
* | 182e70c Add README.md
|/
* 98e758c Init css/js
* 534a4d0 Add index.html
```

## 3. Merge conflict 발생

branch를 나눈 이후에 master branch에 커밋이 발생하였고, 동일한 파일이 각자 다른 branch에서 수정된 경우 자동으로 merge가 되지 않는다. 따라서 merge conflict가 발생하고, 직접 수정 후 커밋을 해야한다.

``` ba
(master) $ git merge feature/footer
Auto-merging README.md
CONFLICT (content): Merge conflict in README.md
Automatic merge failed; fix conflicts and then commit the result.
```

Git은 충돌이 발생한 파일에 아래와 같이 표기 해준다. 해당 부분을 찾아서 수동으로 해결해야 한다. **충돌 위치를 파악하기 위해서는 git status를 통해 확인할 수 있다!** 

``` bash
<<<<<<< HEAD
블라블라~ 내용 추가함.
=======
footer를 개발함.
>>>>>>> feature/footer
```

``` bash
$ git add .
$ git commit
```

커밋을 하게 되면, merge 커밋이 발생한다.

* 1상황 : merge 하려고 할 때 이후 branch가 없으면 branch를 끌어온다. (fast-forword한다.)
* 2-1 상황 : merge하려는 branch가 모두 서로 다른 파일일 경우에는 자동으로 merge된다.
* 2-2 상황 : merge하려는 branch에 동일한 파일이 있을 경우에는 merge conflict를 해결해야 한다.
* **merge를 할 때는 병합하고 싶은 branch로 돌아와야 한다!!!**

## Stashing 상황

현재 변경사항을 담아둘 수 있는 임시공간이 존재한다.

1. 현재 변경사항 담기

   ``` bash
   $ git stash
   $ git stash list
   ```

2. 임시 저장사항 불러오기

   ``` bash
   $ git stash pop
   ```

   위의 명령어는 apply + drop 과 동일하다.

## Pull Request

협업에서 다른사람에게 pull하라는 request를 보낼 수 있다.

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
  
  [Git Flow](<http://woowabros.github.io/experience/2017/10/30/baemin-mobile-git-branch-strategy.html>)
  
  [Github Flow](<https://ujuc.github.io/2015/12/16/git-flow-github-flow-gitlab-flow/>)
  
  [Git Book](<https://git-scm.com/book/ko/v2>)
