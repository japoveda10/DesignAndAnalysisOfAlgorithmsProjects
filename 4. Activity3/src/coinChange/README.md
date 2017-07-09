# Activity 3 part 2: Minimum Coin Change
This project has 3 solutions to the minimum coin change problem.<br>
The main class is called `ExampleCoinChange`, it receives 3 parameters:
- Name of the class with the algorithm to run
  - DivideAndConquerCoinChange
  - GreedyAlgorithmCoinChange
  - DynamicProgrammingCoinChange
- Total value that wants to be given using the less amount of coins
- Comma-separated list of denominations

These are some examples of how to run the program with arguments:
- coinChange.DivideAndConquerCoinChange 1000  1,2,3,4,5
- coinChange.GreedyAlgorithmCoinChange 100000  1,2,4,6,8
- coinChange.DynamicProgrammingCoinChange 1000000 1,12,47,51,69
