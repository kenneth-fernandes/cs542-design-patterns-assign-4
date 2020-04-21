# CS542: Assignment 4

## Name: Kenneth Peter Fernandes

---

Following are the commands and the instructions to run ANT on your project.

#### Note: build.xml is present in expenseManagerProg/src folder.

---

## Instruction to clean:

```commandline
ant -buildfile expenseManagerProg/src/build.xml clean
```

Description: It cleans up all the .class files that were generated when you
compiled your code.

---

## Instruction to compile:

```commandline
ant -buildfile expenseManagerProg/src/build.xml all
```

Description: Compiles your code and generates .class files inside the BUILD folder.

---

## Instruction to run:

#### Use the below command to run the program.

```commandline
ant run -buildfile expenseManagerProg/src/build.xml \
-DinputFile="inputFiles/input.txt" \
-DavailableItemsFile="inputFiles/available-items.txt" \
-DrunAvgWinSize=2 \
-DoutputFile="src/BUILD/resultFiles/output.txt"
```

---

## Description:

1. Assumption:
    - The input files are well formatted as per the file format present with appropriate spacing in the assignment description.
    - Special characters are not mentioned in the money data.

2. Data Structures:
    - HashMap <key, value>: It is used to store the available items read by the program from the available-items.txt
    - List<Integer>: It is used to store the list of money earned by the user.

3. External Materials:
    - N/A

4. Compiling:
    - Follow the instructions as mentioned above.

5. Execute Program:
    - Follow the instruction as mentioned above.

6. Code Working:
  - The code first reads the available-items.txt file and retrieves all the available-items and stores it in a HashMap.
  - The code then reads each line from the input file which contains money and item to be purchased.
  - If the data is money earned, then it is added to the money credit list and calculates the average based on window size and then changes the spending state based on the condition.
  - If the data is an item that needs to be processed, the item and item type is checked from the list, with the current spending state and makes the decision to buy the item or not.
  - Once all the data is read from the input file, the final output is persisted to the output file.

---

### Academic Honesty statement:

---

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: [04/14/2020]
