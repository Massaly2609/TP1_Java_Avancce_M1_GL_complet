@echo off
REM Script de compilation pour Windows
REM Usage : compiler.bat

cd /d "%~dp0\src"
if not exist "..\out" mkdir "..\out"
echo Compilation en cours...
dir /s /b *.java > sources.txt
javac -d ..\out @sources.txt
if %errorlevel%==0 (
    echo Compilation reussie. Fichiers .class dans TP_Java\out
    echo.
    echo Pour executer un test, par exemple :
    echo   cd ..\out ^&^& java sn.uasz.m1.tp1.exo2.TestOperation
) else (
    echo Compilation echouee.
)
del sources.txt
pause
