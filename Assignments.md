### Program 2-1
Use the Reference Example introduced in Lesson 2 as a starting point to create your own
Customer class. A Customer has a firstName, lastName, socSecurityNum (which you can
represent as a String), a billingAddress and a shippingAddress. Define a Java class
Customer that has these attributes and has a constructor, getter, and setter methods just
like the Employee class in the Reference Example. You may re-use the Address class
from the Reference Example – billingAddress and shippingAddress should both have
type Address. Your Customer class should have a toString method that provides a string
representation of the customer. A typical toString output would be "[Joe, Smith, ssn: 332-
221-4444]".

In the main method of a Main class, create two instances of Customer (be sure to create
instances of Address to populate their billingAddress and shippingAddress fields). Add
these instances to an array. Then loop through the array and print to the console all those
Customers whose billingAddress is located in the city of Chicago (when you create
instances of Customer initially, be sure to create at least one Customer whose billing
address is in Chicago).



### Program 2-2
Create a class called Prog2. In the main method of the class, output to the console the
result of doing the following two computations:
1. get a random number x in the range 1 .. 9 and compute πx
   .
2. get a random number y in the range 3 .. 14 and compute yπ
   .
   Use the RandomNumbers.java class that has been provided for you. (Do not use the
   Random class directly.)



### Program 2-3
Create a class Prog3. Inside its main method, create float variables to store each of the
following numbers:
1.27, 3.881, 9.6
Output to the console the following two values:
1. the sum of the floats as an integer, obtained by casting the sum to type int
2. the sum of the floats as an integer, obtained by rounding the sum to the nearest
   integer, using the Math.round function



### Program 2-4 

The records of a database table Product have been stored in text format using delimiters
“:” and “,” in the following way: Different rows are separated by “:” and, within a
particular record, different column entries are separated by “,”. In each record, the first
column is always productId.

Write a program (called Prog4) that will read such a text file and extract all the product
id’s that occur in the file. Your program should then output these values to the console in
the following form: (this is a typical example)

134A

213A

911C

012E

662Z

Since we have not yet discussed how to read a file in Java, a text file is provided for you
in this assignment in the form of a separate Java class, called Data. The records have
been stored as a long String in Data, named records. To access this String within
your own program, you can use this line of code:

myString = Data.records;


### Program 2-5
Write a program (called Prog5) that asks the user to input a String. The output is the
characters of this String in reverse order, which should be written to the console. (For
example, if the input string is "Hello", the ouptut string would be "olleH".) (Do not use
arrays and do not create a new String object. In particular, you may not use Java library
functions that peform the reverse operation for you, such as the reverse functions found
in StringBuilder and StringBuffer.)


### Program 2-6
Create a Java class called Prog6.
Create a static method inside Prog6 called removeDups, which accepts an array of
Strings as its only argument. When the method is called, it creates a new array in
which all duplicate Strings in the original input array have been removed. This new
array is then returned.
For example, if the input array is
["horse", "dog", "cat", "horse","dog"]
then the output would be the following array:
["horse","dog","cat"]
NOTE: You must not use any "advanced" data structures to solve this problem – such as
implementors of Java's Set interface (like HashSet and TreeSet).

### Program 2-7

Write a program that generates a random set of 8 addition problems (intended for a child
in elementary school). Numbers to be added should be randomly chosen from the range
1..99. Each run of the program should result in a different set of problems (actually, there
is a tiny probablity that two runs of the program will produce the same set of problems,
but I don’t expect anyone will encounter this). Console output should be formatted like
this:

   8      23     31       99
+ 10    + 17    + 9     + 42
 _____   ____   ____    ____

83 67 39 5
+ 17 + 7 + 19 + 49
 _____ ____ ____ ____
A Hint is provided in the folder that accompanies this assignment, in this directory.



### Program 2-8
Create a Java method
static int min(int[] arrayOfInts)
(in a class Prog2_8) that outputs the minimum of an array of ints.
Create a class Prog2_8Test that tests your method on the following input array
[2, -21, 3, 45, 0, 12, 18, 6, 3, 1, 0, -22]
using JUnit.
NOTE: You may not use the sorting tools available in the Java libraries; for instance, you
may not call Arrays.sort() to sort the input array. (No credit if you do it this way.)



#### Pencil And Paper Program
1. Consider the following if…then logic:
   if(age > 65) socialSecurityStatus = "eligible";
   else socialSecurityStatus = "ineligible";
   Rewrite this (pseudo) code using the Java ternary operator.
2. Suppose a String s is initialized by
   String s = "a friendly face";
   a. Compute the value of the expression
   s.charAt(2);
   b. What is the value of
   s.length()?
   c. What is the value of
   s.substring(2,9)?
   s.substring(4)?
3. Write a Java expression that computes each of the following:
   a. Given the radius r of a circle, compute the area of the circle, and store it in a
   variable A.
   b. Given the length len and width wid of a rectangle, compute the length of the
   diagonal of the rectangle, and store it in a variable diag.
4. Compute the following (without writing any Java code) and indicate the type of your
   answer. (Example: 4 * 3 + 2 equals 14, of type int.)
   a. 3 * 5 / 9 % 2
   b. 4 ^ 3 & 5
   c. 13 >> 2 << 2 ^ 4
   d. 32 | 16/3 >> 2 & 5.
5. You are reviewing some old Java programs in your company's IT department and you
   read the following assignment statement in some abandoned code:
   int a = (b = 5);
   Is the statement legal (i.e. would it compile)? If so, what value is assigned to the
   variable a? Explain.