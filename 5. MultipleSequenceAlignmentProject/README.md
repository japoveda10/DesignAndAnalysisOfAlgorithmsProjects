# Multiple Sequence Alignment Project
This project aligns various DNA sequences.

The main class is called `Main`, it receives 2 parameters:
- Location of input file
  - data/exampleFLOGenes.fa
- Number that defines which sequences are going to be aligned
  - 0 if user wants to align default sequences
  - 1 if user wants to align input file sequences

Example of program arguments:

data/exampleFLOGenes.fa 0

## How does it work?

A matrix is going to be used to align the sequences. Each column of the matrixrepresents a character from the sequence 1 and each row represents a character from the sequence 2. First we fill the matrix with scores. After filling the matrix, the algorithm makes a traceback in order to build the aligned sequences.
