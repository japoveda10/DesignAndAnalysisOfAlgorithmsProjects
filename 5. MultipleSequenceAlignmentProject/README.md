# Multiple Sequence Alignment Project
This project aligns various DNA sequences.

## How does it work?

A matrix is going to be used to align the sequences. Each column of the matrix represents a character from the sequence 1 and each row represents a character from the sequence 2. First we fill the matrix with scores. After filling the matrix, the algorithm makes a traceback from the bottom right corner to the upper left corner in order to build the aligned sequences.
