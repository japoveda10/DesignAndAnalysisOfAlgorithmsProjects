# Activity
This project has 2 parts:
1. **Implements a linear search with ceirtanty using interfaces**

This part of the project iterates through a prime numbers iterator until it finds the first element that fulfills the `Algorithm` class predicate. The main class of this part of the project is `LinearSearchWithCertaintyMain`. `Algorithm` is the class that implements an interface called `Predicate`.

In order to run the first part of the project, the program needs 1 argument, **a number**. This number will affect the behaviour of `Algorithm`´s method `truePredicate`.

For example, if the argument is 100000, `truePredicate` will return `true` if a number is greater than 100000.


2. **Ways to traverse a matrix**

This part of the project traverses a matrix by rows, columns or diagonally until reachng the last element of the main matrix. The main class of this part of the project is `MatrixTraversalsMain`. There is a file located in the data folder of this project called **matrix.properties**. This file has the properties of the matrix that wants to be created and traversed. That file has the next properties:
- matrix.length
- matrix.width
- matrix.element#

The matrix that wants to be created and traversed according to matrix.properties file is:

 C/R | 0 | 1 | 2 | 3 |
------------ | ------------- | - | - | - |
**0** | 0 | 0 | 0 | 0
**1** | 1 | 1 | 1 | 1
**2** | 2 | 2 | 2 | 2
**3** | 3 | 3 | 3 | 3

In order to run the second part of the project, the program needs 1 argument, the **iterator´s name**:
- matrix.MatrixIterator1 - goes through each element of the matrix by rows
- matrix.MatrixIterator2 - goes through each element of the matrix by columns
- matrix.MatrixIterator3 - traverses the matrix diagonally until reaching the last element of the main diagonal



