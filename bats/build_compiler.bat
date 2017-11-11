@echo off
REM compila modelo (parser, value, ast y compilador )

kotlinc  -cp .;classes;%CLASSPATH% -d classes src/kotlin/ast/*.kt src/kotlin/compiler/*.kt src/kotlin/eval/*.kt src/kotlin/exception/*.kt
