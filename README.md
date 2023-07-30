# Programming-Exercise-Counting-Website-Visits
Assignments from OOP Course on Java Programming: Arrays, Lists, and Structured Data, week 3. https://www.coursera.org/learn/java-programming-arrays-lists-data/supplement/ygOPU/programming-exercise-counting-website-visits

PROJECT TITLE: "Programming Exercise: Counting Website Visits"

PURPOSE OF PROJECT: Modify existing code to do additional tasks. Specifically:
                    task 1 - find the number of times all IP addresses visited 
                    the website;
                    task 2 - find the maximum number of visits to this website by a 
                    single IP address;
                    task 3 - find IP addresses that all have the maximum number of 
                    visits to this website;
                    task 4 - IP addresses that occurred on a specific given day 
                    (including repeated IP addresses);
                    task 5 - find the day that has the most IP address visits;
                    task 6 - find IP addresses that had the most accesses on a 
                    given day.
                    Also, make use of Object oriented principle of programming.

DATE: 30.07.2023

HOW TO START THIS PROJECT: Use BlueJ Environment to open project named "package.bluej". 
                           Find inside of this project 4 classes: 
                           LogEntry (organizes all the variables from the WebLogParser
                           and return a string with them)
                           WebLogParser (take line from WebLog and make it an object of
                           type LogEntry that holds all information about specific log)
                           LogAnalyzer (stores all log entries and print them on the screen)
                           Tester - compile, create object of type Tester 
                           and start one of the following functions: 
                           "testCountVisitsPerIp" for task 1;
                           "testMostNumberVisitsByIP" for task 2;
                           "testIPsMostVisits" for task 3;
                           "testIPsForDays" for task 4;
                           "testDayWithMostIPVisits" for task 5;
                           "testIPsWithMostVisitsOnDay" for task 6;
                           It chooses automatically one file from the project folder.
                           You may choose another one web log example file, but should modify
                           filename in the code.

AUTHOR: Gusev Roman

USER INSTRUCTIONS: If your time zone is different from Durham, 
                   USA, you may want to temporarily change the time zone on your 
                   computer as the time zone setting of your computer affects the 
                   output value from the getAccessTime method.
                   you will need 6 imports: 
                   "edu.duke.FileResource" (simplified version of 
                   File function from Java);
                   "java.text.SimpleDateFormat";
                   "java.text.ParsePosition";
                   "java.util.ArrayList"; 
                   "java.util.Date";
                   "java.util.Locale";
