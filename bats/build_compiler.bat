@echo off
REM compila modelo (parser, value, ast y compilador )

kotlinc  -cp .;classes;lib;%CLASSPATH% -d classes src/kotlin/ast/*.kt
