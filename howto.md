### Сделал форк и клонирую проект на компьютер
$ git clone https://github.com/Flimill/KotlinAsFirst2020

$ cd KotlinAsFirst2020
### Указал upstream-my
$ git remote add upstream-my https://github.com/Flimill/KotlinAsFirst2021


### Сделал rebase upstream-my в ветку master
$ git fetch upstream-my
$ git rebase --onto master 1137b420cc95fa6894edad69b31e2da1bb985d1d upstream-my/master
Successfully rebased and updated detached HEAD.

###Создал ветку backport и загрузил коммиты

$ git branch backport

$ git checkout master
Previous HEAD position was 3167012 les 11
Switched to branch 'master'
Your branch is up to date with 'origin/master'.

$ git merge backport
Updating d535f35..3167012
Fast-forward
 input/tst.txt                          |   1 +
 src/lesson1/task1/Simple.kt            |  28 ++-
 src/lesson11/task1/DimensionalValue.kt |  45 +++-
 src/lesson2/task1/IfElse.kt            |  45 +++-
 src/lesson2/task2/Logical.kt           |  41 +++-
 src/lesson3/task1/Loop.kt              | 210 ++++++++++++++++--
 src/lesson4/task1/List.kt              | 223 +++++++++++++++++--
 src/lesson5/task1/Map.kt               | 144 +++++++++++--
 src/lesson6/task1/Parse.kt             | 104 ++++++++-
 src/lesson7/task1/Files.kt             | 378 +++++++++++++++++++++++++--------
 src/lesson8/task2/Chess.kt             |  19 +-
 test/lesson2/task1/Tests.kt            |   3 +
 test/lesson3/task1/Tests.kt            |   1 +
 test/lesson5/task1/Tests.kt            |   7 +
 test/lesson6/task1/Tests.kt            |   2 +
 test/lesson7/task1/Tests.kt            |   4 +
 16 files changed, 1103 insertions(+), 152 deletions(-)
 create mode 100644 input/tst.txt

### Указал upstream-theirs
$ git remote add upstream-theirs https://github.com/Keshaqwertys/KotlinAsFirst2021

### Сделал его merge с веткой master
$ git fetch upstream-theirs
From https://github.com/Keshaqwertys/KotlinAsFirst2021
 * [new branch]      master     -> upstream-theirs/master

$ git merge -s ours upstream-theirs/master
Merge made by the 'ours' strategy.

### Создал файл remote и закоммитил
$ git remote -v > remotes


$ git add remotes
warning: LF will be replaced by CRLF in remotes.
The file will have its original line endings in your working directory


$ git commit -m "Add remotes file"
[master 5f1f78f] Add remotes file
 1 file changed, 6 insertions(+)
 create mode 100644 remotes

### Создал howto.md и коммитил
$ touch howto.md


$ git add howto.md


$ git commit -m "Add howto.md"
[master ccf7ebf] Add howto.md
 1 file changed, 0 insertions(+), 0 deletions(-)
 create mode 100644 howto.md

### Загрузил на github
$ git push
Enumerating objects: 741, done.
Counting objects: 100% (741/741), done.
Delta compression using up to 4 threads
Compressing objects: 100% (293/293), done.
Writing objects: 100% (670/670), 101.63 KiB | 5.08 MiB/s, done.
Total 670 (delta 342), reused 430 (delta 197), pack-reused 0
remote: Resolving deltas: 100% (342/342), completed with 34 local objects.
To https://github.com/Flimill/KotlinAsFirst2020
   d535f35..ccf7ebf  master -> master


$ git checkout backport
Switched to branch 'backport'


$ git push --set-upstream origin backport
Total 0 (delta 0), reused 0 (delta 0), pack-reused 0
remote:
remote: Create a pull request for 'backport' on GitHub by visiting:
remote:      https://github.com/Flimill/KotlinAsFirst2020/pull/new/backport
remote:
To https://github.com/Flimill/KotlinAsFirst2020
 * [new branch]      backport -> backport
branch 'backport' set up to track 'origin/backport'.

