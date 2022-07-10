# Sudoku
Made with Gradle and tested with JUnit

### Why Sudoku? 
I'm lowkey addicted to board games

### Features
- 3 different levels Easy, Medium and Hard (difference in the amount of blanks)
- Can generate 6 x 10^21 sudoku boards based on http://pi.math.cornell.edu/~mec/Summer2009/Mahmood/Count.html
- Board only has one solution

### How was the Board Generated
1. A plain valid board is used which looks like
    1 2 3    4 5 6    7 8 9
    4 5 6    7 8 9    1 2 3
    7 8 9    1 2 3    4 5 6

    2 3 1    4 5 6    8 9 7
    5 6 4    8 9 7    2 3 1
    8 9 7    2 3 1    5 6 4

    3 1 2    6 4 5    9 7 8
    6 4 5    9 7 8    3 1 2
    9 7 8    3 1 2    6 4 5
2. The board is then shuffled by rows, columns, by 3x3 rows and 3x3 columns. Board is also transposed and rotated
3. When board goes through all of these processes, it will still be a valid sudoku board
