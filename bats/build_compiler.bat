@echo off
REM compila modelo (parser, value, ast y compilador )
javac  -cp .;classes;%CLASSPATH% -d classes src/kotlin/parser/*.java
kotlinc  -cp .;classes;%CLASSPATH% -d classes src/kotlin/ast/*.kt src/kotlin/eval/*.kt src/kotlin/exception/*.kt src/kotlin/compiler/*.kt
