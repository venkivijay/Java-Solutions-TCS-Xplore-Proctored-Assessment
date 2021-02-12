## Problem Statement

Create class Sim with below attributes:
simId - int
customerName - String
balance - double
ratePerSecond - double
circle - String

Create class Solution and implement static method "transferCircle" in the Solution class.
This method will take array of Sim objects, circle1 String and circle2 string as parameters.
And will return another Sim array where the circle1 matches with the circle parameter of the original Sim array and the circle parameter of the new array is set to circle2 and is also sorted by means of ratePerSecond attribute in desending order.

Write necessary getters and setters.

Before calling "transferCircle" method in the main method, read values for five Sim objects referring the attributes in above sequence along with a String circlee1 and circle2.
Then call the "transferCircle" method and write logic in main method to print all the attributes of the result obtained.

## Input

    1
    raju
    130
    1.32
    mum
    2
    sachin
    120
    2.26
    ahd
    3
    ram
    200
    2.54
    kol
    4
    shubham
    640
    3.21
    ahd
    5
    kalpesh
    150
    1.8
    ahd
    ahd
    kol

## Output

    4 shubham kol 3.21
    2 sachin kol 2.26
    5 kalpesh kol 1.8
