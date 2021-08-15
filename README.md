## String Builder

### Coding exercice 

This exercice is a slightly different version of the hard hackerrank [Build a String](https://www.hackerrank.com/challenges/build-a-string/problem) problem.

Here the solution is implemented in Java.

##### Context
Bob wants to build a string S, of length N.
Starting with an empty string, Bob can perform two operations:
- Add a character to the end of S for appendCost pounds.
- Copy any substring of S, and then add it to the end of S for cloneCost pounds.

The goal is to calculate the minimum amount of money Bob needs to build S.

##### Input Format

<div align = "center">
  <img src = "https://user-images.githubusercontent.com/39555683/129451127-cee88b69-47cb-4cb0-9ee7-2118deb9d353.png" />
</div>

A line containing the different values (e.g. "abcdefghabcdefgh 2 4") where the first value (abcdefghabcdefgh) is the target string S, the second value (2) is the cloneCost and the third value (4) is the appendCost.

##### Output Format

An integer that is the minimum cost that Bob will to spend to build the string S.

Using the input "abcdefghabcdefgh 2 4" the outcome would be 34.

### How does the algorithm work

This algorithm is quite straightforward and simple to understand.

In memory, there is an array arr of the same size as the target string S.
Then, a for loop iterates through each character of the target and performs the following
- Using the getClone method, the biggest substring is found.
- If the cloning is more efficient than appending, the appending at this point and added to the total sum.
- This loops continues until it reaches the last character of the string.

The minimum cost to reach each substring [0 to i] of S is stored within the array arr at position i. Thus, the minimum for the target string S is stored at the end of the array.

See exemple below:

<div align = "center">
  Appending the character 'a' at the beginning of the string S
  
  Cost array value - [4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

  Appending the character 'b' at the end of the string a
  <br>
  Cost array value [4, 8, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

  Appending the character 'c' at the end of the string ab
  <br>
  Cost array value [4, 8, 12, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

  Appending the character 'd' at the end of the string abc
  <br>
  Cost array value [4, 8, 12, 16, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

  Appending the character 'e' at the end of the string abcd
  <br>
  Cost array value [4, 8, 12, 16, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

  Appending the character 'f' at the end of the string abcde
  <br>
  Cost array value [4, 8, 12, 16, 20, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]

  Appending the character 'g' at the end of the string abcdef
  <br>
  Cost array value [4, 8, 12, 16, 20, 24, 28, 0, 0, 0, 0, 0, 0, 0, 0, 0]

  Appending the character 'h' at the end of the string abcdefg
  <br>
  Current cost array [4, 8, 12, 16, 20, 24, 28, 32, 0, 0, 0, 0, 0, 0, 0, 0]

  Cloning the substring 'a' at the end of the substring abcdefgh
  <br>
  Cost array value [4, 8, 12, 16, 20, 24, 28, 32, 34, 0, 0, 0, 0, 0, 0, 0]

  Cloning the substring 'ab' at the end of the substring abcdefgh
  <br>
  Cost array value [4, 8, 12, 16, 20, 24, 28, 32, 34, 34, 0, 0, 0, 0, 0, 0]

  Cloning the substring 'abc' at the end of the substring abcdefgh
  <br>
  Cost array value [4, 8, 12, 16, 20, 24, 28, 32, 34, 34, 34, 0, 0, 0, 0, 0]

  Cloning the substring 'abcd' at the end of the substring abcdefgh
  <br>
  Cost array value [4, 8, 12, 16, 20, 24, 28, 32, 34, 34, 34, 34, 0, 0, 0, 0]

  Cloning the substring 'abcde' at the end of the substring abcdefgh
  <br>
  Cost array value [4, 8, 12, 16, 20, 24, 28, 32, 34, 34, 34, 34, 34, 0, 0, 0]

  Cloning the substring 'abcdef' at the end of the substring abcdefgh
  <br>
  Cost array value [4, 8, 12, 16, 20, 24, 28, 32, 34, 34, 34, 34, 34, 34, 0, 0]

  Cloning the substring 'abcdefg' at the end of the substring abcdefgh
  <br>
  Cost array value [4, 8, 12, 16, 20, 24, 28, 32, 34, 34, 34, 34, 34, 34, 34, 0]

  Cloning the substring 'abcdefgh' at the end of the substring abcdefgh
  <br>
  Cost array value [4, 8, 12, 16, 20, 24, 28, 32, 34, 34, 34, 34, 34, 34, 34, 34]
  
</div>
  
### How to run the program

I built this program using an online Java compiler so running it in the same envrionment is the easiest way to do.

##### Online Compiler

Copy-paste the stringBuilder.java code into an online Java compiler. I would recommend this [website](https://www.jdoodle.com/online-java-compiler/).
Input the different parameters (target string, cloning cost, appending cost) you wont to run the program with in the CommandLine Arguments field (See exemple below).

<div align = "center"
     <img src = "https://user-images.githubusercontent.com/39555683/129485159-377b9648-af67-485c-9c3c-70997ab8fb5c.png />
</div>

##### Local Compiler

You can copy-paste stringBuilder.java in a existing java project to run it.
Then run the following commands (in this case abcdefghabcdefgh is the target string, 2 is the cloning cost and 4 is the appending cost):
<div align = "center"
     <img src = "https://user-images.githubusercontent.com/39555683/129485211-41d4d468-ae31-4977-981e-b3755b73e481.png" />
     <img src = "https://user-images.githubusercontent.com/39555683/129485214-dc6f23dc-90d8-4d9a-af05-bac2690d32f4.png" />
</div>
