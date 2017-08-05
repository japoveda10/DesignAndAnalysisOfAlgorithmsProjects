# Multiple Sequence Alignment Project
This project aligns various DNA sequences.

## How does it work?

A matrix is going to be used to align the sequences. Each column of the matrix represents a character from the sequence 1 and each row represents a character from the sequence 2. First we fill the matrix with scores. After filling the matrix, the algorithm makes a traceback from the bottom right corner to the upper left corner in order to build the aligned sequences.

## How can i run the project?

Download the project, open it in Eclipse, select the class `SequencesAlignmentProjectGUI` (it has the main) and run it as a Java Application.

## How does it looks like?

![Sequence Alignment Project GUI with 2 text fields and a button][image1]

[image1]: https://github.com/japoveda10/DesignAndAnalysisOfAlgorithmsProjects/blob/master/images/SEQUENCES_ALIGNMENT_PROJECT_1.png


![Sequence Alignment Project GUI with 2 DNA example sequences][image2]

[image2]: https://github.com/japoveda10/DesignAndAnalysisOfAlgorithmsProjects/blob/master/images/SEQUENCES_ALIGNMENT_PROJECT_2.png


![Sequence Alignment Project GUI displaying the alignment of 2 DNA example sequences][image3]

[image3]: https://github.com/japoveda10/DesignAndAnalysisOfAlgorithmsProjects/blob/master/images/SEQUENCES_ALIGNMENT_RPOJECT_3.png
