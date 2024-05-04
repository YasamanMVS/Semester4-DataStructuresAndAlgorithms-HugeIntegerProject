# Huge Integer Java Implementation

## Project Overview
This Java project implements a `HugeInteger` class that handles extremely large integers using a linked list to store each digit. The class includes methods for adding large integers, comparing them, and other utilities that extend the capability of Java's built-in integer types.

## Features
- Initialize large integers from strings to handle numbers beyond standard integer limits.
- Perform arithmetic operations such as addition.
- Compare huge integers to determine relative size.
- Efficiently handle numbers with operations tailored for linked list data structures.

## Installation
Clone the repository to your local machine:
```bash
git clone https://github.com/YasamanMVS/Semester4-DataStructuresAndAlgorithms-HugeIntegerProject.git
cd huge-integer
```
Ensure you have Java installed on your machine. To compile the program, run:
```bash
javac src/HugeInteger.java src/Main.java
```
To run the program, use:
```bash
java -cp src Main
```
## Usage:
The `Main.java` file contains usage examples that demonstrate the capabilities of the `HugeInteger` class. You can modify this file to include your tests or utilize the `HugeInteger` class in your projects.
```java
public class Main {
    public static void main(String[] args) {
        HugeInteger hi = new HugeInteger("123456789012345678901234567890");
        HugeInteger hi2 = new HugeInteger("987654321098765432109876543210");
        HugeInteger sum = hi.addPositive(hi2);
        System.out.println("Sum: " + sum);
    }
}
