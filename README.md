# Version Required:
* Java 8

# Dependency
* Jackson (for deserilize JSON data)

# Run
Find the main class under the `/src/main/Main` and run.<br>
Demo input & output:
```
Input: Person = Ish; Relation = Brothers
Output: Chit,Vich
Input: Person = Vila; Relation = Cousins
Output: Drita,Vrita,Satvy,Savya,Saayan
Input: Person = Vila; Relation = Father
Output: Vich
Input: Person = Vila; Relation = Paternal_Uncle
Output: Ish,Chit,Vyan
Input: Person = Drita; Relation = PATERNAL_AUNT
Output: Satya,Lika
```

# Mock Data
Mock data is the json version of example in the pdf which locates on <br>
```
src/main/helpers/rawData.json
```

# Description
This solution is for the Problem 1: meet the family.<br>

# Test
Test is under the src/tests.processors folder, cannot cover all the case on the limited time,
so i chose some of the typical logic for demonstration. I used JUnit5 for relationProcessor class unit test.


