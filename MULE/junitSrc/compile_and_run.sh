#!/bin/bash
javac -cp ".:junit-4.11.jar:..build/classes:../src" TestSuite.java
javac -cp ".:junit-4.11.jar:..build/classes:../src" RunTestSuite.java 
java -cp ".:junit-4.11.jar:hamcrest-core-1.3.jar:..build/classes:../src" RunTestSuite
