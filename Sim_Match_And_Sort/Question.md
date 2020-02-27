## Problem Statement

Create class Sim with below attributes:
id - int 
company - String 
balance - int 
ratePerSecond - double
circle - String 

Create class Solution and implement static method "matchAndSort" in the Solution class.
This method will take array of Sim objects, search_circle String and search_rate double as parameters.
And will return another Sim array where the search_circle matches with the circle parameter of the original Sim array and the search_rate double is greater than the original array of Sim object's ratePerSecond attribute which is also sorted by means of balance attribute in ascending order.

Write necessary getters and setters.

Before calling "matchAndSort" method in the main method, read values for four Sim objects referring the attributes in above sequence along with a String search_circle and a double search_rate.
Then call the "matchAndSort" method and write logic in main method to print the id's of the result obtained.


## Input

    100
    Sachin
    5
    150
    13000
    101
    Sehwag
    4
    120
    10000
    103
    Dhoni
    7
    110
    7000
    104
    Kohli
    15
    57
    4400
    100

## Output

    Grade A
    Grade A
    Grade B