
 
set user=root
set password=""
set backupDir="C:\bkpmysql"
set mysqldump="C:\wamp64\bin\mysql\mysql5.7.19\bin\mysqldump.exe"
set databases="bdsifat"
set host="localhost"

@echo off
:: get date
for /F "tokens=1-3 delims=/ " %%i in ('date /t') do (
set dia=%%i
set mes=%%j
set ano=%%k
)
 
:: get time
for /F "tokens=1-2 delims=:. " %%i in ('time /t') do (
set hora=%%i
set minuto=%%j
)
 
set data=%ano%-%mes%-%dia%_%hora%-%minuto%
set filename=%databases%_%data%.sql
:: switch to the "data" folder
pushd %mysqlDataDir%

 
if not exist %backupDir%\%dirName%\ (
mkdir %backupDir%\%dirName%
)
 
%mysqldump% --host=%host% --user=%user% --password=%dbPassword% --single-transaction --add-drop-table --databases %databases% > %backupDir%\%filename%
 
echo "bkp feito em %backupDir%\%filename%"