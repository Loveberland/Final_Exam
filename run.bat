@echo off
REM run.bat - Windows script to build and run the Java application

REM --- Configuration ---
set SRC_DIR=src\main\java
set BIN_DIR=bin
set MAIN_CLASS=Final_Exam.Main

REM --- Argument Parsing ---
if /I "%1"=="clean" goto clean
if /I "%1"=="run" goto run
goto build

:clean
    echo Cleaning bin directory...
    if exist "%BIN_DIR%" rd /s /q "%BIN_DIR%"
    echo Clean complete!
    goto :eof

:build
    echo Compiling Java files...
    if not exist "%BIN_DIR%" mkdir "%BIN_DIR%"
    
    REM Create a temporary list of all .java files
    dir /s /b "%SRC_DIR%\*.java" > sources.txt
    
    REM Compile using the list
    javac -encoding UTF-8 -d "%BIN_DIR%" -sourcepath "%SRC_DIR%" @sources.txt
    
    REM Remove the temporary list
    del sources.txt
    
    echo Build successful!
    goto :eof

:run
    REM Build first before running
    call :build
    
    echo Running application...
    java -cp "%BIN_DIR%" "%MAIN_CLASS%"
    goto :eof