# Student Attendance File Analyzer

## Project Title
Student Attendance File Analyzer

## Problem Statement
A Java console application that collects attendance details for multiple students, calculates attendance percentage, stores records in a text file, reads the stored file, and displays students whose attendance is below 75%.

## Features
- Multiple student records
- Scanner-based input
- Attendance percentage calculation
- Text-file storage using Java I/O
- Reads stored records
- Displays attendance below 75%
- Input validation and exception handling
- No database
- No external libraries

## Concepts Used
Java variables and data types, Scanner, arithmetic operations, conditional statements, classes and objects, Java I/O, file handling, character-based file handling, exception handling and basic problem solving.

## Project Structure
StudentAttendanceAnalyzer/
- src/StudentAttendanceAnalyzer.java
- attendance.txt
- README.md

## How to Run
Compile:
```bash
javac src/StudentAttendanceAnalyzer.java
```

Run:
```bash
java -cp src StudentAttendanceAnalyzer
```

Windows users can also double-click `run.bat`.

## Sample Input
Enter number of students: 3

Student 1
Name: Rahul
Roll Number: 101
Total Classes: 60
Classes Attended: 52

Student 2
Name: Priya
Roll Number: 102
Total Classes: 60
Classes Attended: 40

Student 3
Name: Arjun
Roll Number: 103
Total Classes: 60
Classes Attended: 55

## Sample Output
Students with attendance below 75%
Roll Number: 102, Name: Priya, Attendance: 66.67%
Total Classes: 60, Classes Attended: 40

## Formula
Attendance Percentage = (Classes Attended / Total Classes) x 100

## Constraints
- Total Classes must be greater than 0.
- Classes Attended cannot be greater than Total Classes.
- Invalid input and file errors are handled.
- No database is used.
