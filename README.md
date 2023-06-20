# Concurrency and Threading management in Java project

## What is this? 

This an inclass-project using Java to be able to develop an application that allows several diners to eat at a table at the same time, however, certain conditions must be taken into account, such as the fact that diners must use cutlery to be able to eat their dishes. Additionally, these cutlery must be washed in a sink and by a dishwasher. To model the interaction of the case, the Thread class extended in the diners and the dishwasher is used.

At the end of the project we tried to implement GitHub Actions to make an autodeployment of the project.

## Functionality and rules:

Each commensal thread implements a cycle to eat all its dishes according to the rules described above: it needs 2 covers to eat, it changes the cutlery after each dish and, for etiquette reasons, it must wait for everyone to reach half the number of dishes. before moving forward.

The dishwasher thread is an infinite loop that collects cutlery from the sink, washes it (a task that takes a random 1 and 2 seconds), and puts it back on the table.

The rules of access to cutlery are the following:
• Only one cover can be taken at a time. If you cannot take the first one, you must wait (passive wait) for a free cover of that type.
• If after having a place setting I cannot access the second, the diner must release the one they already have and wait (passive wait) for a place setting of the type they could not take to be released to try again to take the two places.
• The sink to pass the cutlery to wash them works in semi-active wait (yield), both for the diners and for the dishwasher.
• At the table there is always space for new cutlery (once washed).

Eating a dish takes a random time between 3 and 5 seconds. Each diner should take at least that time before moving on to the next dish. For this, the diner thread generates a random integer between 1 and 3 before starting to eat a new dish.
 
The number of dishes, cutlery of each type and size of the sink to communicate with the dishwasher must be in a file, which must be processed by the main of the program.

The way to demonstrate that the program works correctly must be defined. The output must be clear so that the correct operation of the system can be easily validated.

The configuration for execution must be stored in a properties file. An example of such a file would be:

concurrency.numDiners = 6
concurrency.numCubiertosT1= 7
concurrency.numCubiertosT2= 10
concurrency.numPlates = 8
concurrency.sinkSize = 5

## What we have used to build this app?

- Java
- Eclipse IDE
- Python scripts (Autodeployment)
