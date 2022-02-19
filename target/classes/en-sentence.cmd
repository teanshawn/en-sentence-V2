@echo off


java en.EnTestTxtGenerate
:: commit automatically
cd ..
cd ..
git add . 
 git commit -m "bat commit automatically : %date:~0,10%,%time:~0,8%" 
::  git commit -m "%commitMessage%" 
git push origin master
@echo Git push finished

SET daoTime=10
:dao
set /a daoTime=daoTime-1
ping -n 2 -w 500 127.1>nul
cls
echo Git push finished, time to exit: %daoTime% second
if %daoTime%==0 (exit) else (goto dao)