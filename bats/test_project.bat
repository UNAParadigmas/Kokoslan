@echo off
REM Tests KoKoslan
if "%1"=="" goto :paramempty
rem set OUT=%2
rem if "%2"=="" SET OUT=%1.out.kl

SET OUT=%1.out.kl

if "%2"=="kotlin" goto :kotlin
if "%2"=="java" goto :java

echo Prueba el caso de prueba: cases\%1 output\%OUT%

:java
java -cp .;classes;lib;%CLASSPATH% kokoslan.compile.KoKoc cases\%1 output\%OUT%
if %ERRORLEVEL% == 1 (goto :error)
exit /b

:kotlin
kotlin -cp .;classes;lib;%CLASSPATH% kokoslan.kotlin.compile.KoKocKt cases\%1 output\%OUT%
if %ERRORLEVEL% == 1 (goto :error)
exit /b

:error
echo "*** Test failed ***"
exit /b

:paramempty
echo "*** Provide some test case in dir cases ***"

:end