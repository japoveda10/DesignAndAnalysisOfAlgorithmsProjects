# Activity 3 part 1: Sorting Algorithms
This project has the implementation of 3 sorting algorithms: BubbleSort, MergeSort and QuickSort.

The main class is called `ExampleSort`, it receives 3 parameters:
- Name of input file with numbers to sort
- Output file to save sorted numbers
- (Optionally) name of a sorting algorithm class implemented in the project
  - sortingAlgorithms.BubbleSort
  - sortingAlgorithms.MergeSort
  - sortingAlgorithms.QuickSort
  - If this argument is left in blank, automatically the program will run the default algorithm implemented in the static method sort of the class java.util.Arrays

These are some examples of how to run the program with arguments:
- data/array.txt data/sortedArray.txt sortingAlgorithms.BubbleSort
- data/array.txt data/sortedArray.txt sortingAlgorithms.MergeSort
- data/array.txt data/sortedArray.txt sortingAlgorithms.QuickSort
- data/array.txt data/sortedArray.txt
