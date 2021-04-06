# CS542 - Design Patterns: Assignment 4
## Name: Kenneth Peter Fernandes

---
# Assignment Goal
Implement the state pattern to capture the changes in spending potential of a person. This is an individual assignment.
Programming Language  - You are required to program using Java.
Compilation Method - You are required to use ANT for compilation of code written in Java.

#Project Description
Let us say that a person's spending potential and priorities change based on the running average of the money earned. Note that for this assignment, currency does not matter. Therefore, money is just represented as a number.
The running average of the money earned determines the state the person is in. The window size for calculating running average will be provided via commandline.
The following are the categories of items.

basic
moderatelyExpensive
superExpensive

The person can be in one of the following states. The conditions to be satisfied to be in each of these states are also provided.
BASIC - Default starting state. Signifies that the person only spends money on basic items.
Condition → 0 ≤ running average of money earned < 10000.

LUXURIOUS - Signifies that apart from the basic necessities, the person also spends money on moderatelyExpensive items.
Condition → 10000 ≤ running average of money earned < 50000.

EXTRAVAGANT - Signifies that apart from basic and moderatelyExpensive items, the person also spends money on superExpensive items.
Condition → 50000 ≤ running average of money earned.

Depending on the state, the person either agrees/disagrees to purchase an item.

Input:
The available items filename is provided via commandline option. Below is the format of the file. Note that words are camelcased starting with lowercase letter.
```
basic:<item name>
basic:<item name>
...
moderatelyExpensive:<item name>
moderatelyExpensive:<item name>
...
superExpensive:<item name>
superExpensive:<item name>
...
```

Example available items file is shown below.
```
basic:householdItem
basic:medicine
basic:food
moderatelyExpensive:cinema
moderatelyExpensive:automobile
moderatelyExpensive:vacationTrip
superExpensive:yacht
superExpensive:privateJet
superExpensive:island
```

The money earned and and items that can be purchased are provided in the input file, the name of which is also provided via commandline. Below is the format of the file. Note that any number in the file should be an integer.
```
money:<amount>
money:<amount>
...
item:<item to purchase or not>
item:<item to purchase or not>
...
money:<amount>
money:<amount>
...
item:<item to purchase or not>
item:<item to purchase or not>
...
```
Example input file is shown below.
```
money:10000
money:4000
item:cinema
item:medicine
item:householdItem
money:500
item:medicine
item:householdItem
money:25000
item:yacht
item:vacationTrip
money:60000
item:medicine
item:householdItem
money:60000
item:yacht
```

The following commandline options are to be accepted.
```
-DinputFile - Input filename.
-DavailableItemsFile - Available items file.
-DrunningAverageWindowSize - Window size for running average calculation.
-DoutputFile - Output filename.
```

Output:
The name of the output file will be provided via commandline.
When processing the input file, do the following.
If the line represents money earned, then DO NOT write anything to the output file.
If the line is an item, then write the following to the output file.
Name of the state.
Item.
Yes/No indicating whether the person agrees to purchase the item or not.
The format of the above information in the output file would be <state name>::<item name>--<YES/NO>.
Instead of directly writing to the output file, use the Results class as a mediator.

The output file will have the following format.
```
<state name>::<item name>--<YES/NO>
<state name>::<item name>--<YES/NO>
...
```

Assuming that the running average window size = 2, the example output for the above input is shown below.
```
BASIC::cinema--NO
BASIC::medicine--YES
BASIC::householdItem--YES
BASIC::medicine--YES
BASIC::householdItem--YES
LUXURIOUS::yacht--NO
LUXURIOUS::vacationTrip--YES
LUXURIOUS::medicine--YES
LUXURIOUS::householdItem--YES
EXTRAVAGANT::yacht--YES
```


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
