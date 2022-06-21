package com.example.sudoku;

//To create board and to check if it's correct

import java.util.Random;

public class Board {
    Random random = new Random();
    int[][] board = new int[][] {
            {1,2,3,  4,5,6,  7,8,9},
            {4,5,6,  7,8,9,  1,2,3},
            {7,8,9,  1,2,3,  4,5,6},

            {2,3,1,  5,6,4,  8,9,7},
            {5,6,4,  8,9,7,  2,3,1},
            {8,9,7,  2,3,1,  5,6,4},

            {3,1,2,  6,4,5,  9,7,8},
            {6,4,5,  9,7,8,  3,1,2},
            {9,7,8,  3,1,2,  6,4,5}
    };

    int[][] getBoard(){
        return board;
    }

    void shuffleRows(){
        int blockNumber;
        for(int i = 0; i < 9; i++){
            int ranNum = random.nextInt(3);
            blockNumber = i / 3;
            swapRows(i, blockNumber * 3 + ranNum);
        }
    }

    void swapRows(int r1, int r2){
        int[] row = board[r1];
        board[r1] = board[r2];
        board[r2] = row;
    }

    void shuffleCols() {
        int blockNumber;
        for (int i = 0; i < 9; i++) {
            int ranNum = random.nextInt(3);
            blockNumber = i / 3;
            swapCols(i, blockNumber * 3 + ranNum);
        }
    }

    void swapCols(int c1, int c2) {
        int colVal;
        for (int i = 0; i < 9; i++){
            colVal = board[i][c1];
            board[i][c1] = board[i][c2];
            board[i][c2] = colVal;
        }
    }

    void shuffle3X3Rows() {
        for (int i = 0; i < 3; i++) {
            int ranNum = random.nextInt(3);
            swap3X3Rows(i, ranNum);
        }
    }

    void swap3X3Rows(int r1, int r2) {
        for (int i = 0; i < 7; i+=3) {
            swapRows(r1 + i, r2 + i);
        }
    }

    void shuffle3X3Cols() {
        for (int i = 0; i < 3; i++) {
            int ranNum = random.nextInt(3);
            swap3X3Cols(i, ranNum);
        }
    }

    private void swap3X3Cols(int c1, int c2) {
        for (int i = 0; i < 7; i+=3) {
            swapCols(c1 + i, c2 + i);
        }
    }

    void XMirrorImage(){
        int mirror;
        for (int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                mirror = board[i][8-j];
                board[i][8-j] = board[i][j];
                board[i][j] = mirror;
            }
        }
    }

    void YMirrorImage(){
        int mirror;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                mirror = board[8-i][j];
                board[8-i][j] = board[i][j];
                board[i][j] = mirror;
            }
        }
    }

    void rotate90() {
        for (int i = 0; i < 9 / 2; i++) {
            for (int j = i; j < 8 - i; j++) {
                int temp = board[i][j];
                board[i][j] = board[j][8 - i];
                board[j][8 - i] = board[8 - i][8 - j];
                board[8 - i][8 - j] = board[8 - j][i];
                board[8 - j][i] = temp;
            }
        }
    }

    void Transpose() {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                int temp = board[i][j];
                board[i][j] = board[j][i];
                board[j][i] = temp;
            }
        }
    }

    //remove some numbers in the array depending on level
    void removeSome(){
        MainActivity game = new MainActivity();
        int difficulty = game.selectedDifficulty;

        if(difficulty == 0){
            for(int i = 0; i < 30; i++){
                int x = random.nextInt(9);
                int y = random.nextInt(9);
                board[x][y] = Integer.parseInt(null);
            }
        } else if (difficulty == 1){
            for(int i = 0; i < 45; i++){
                int x = random.nextInt(9);
                int y = random.nextInt(9);
                board[x][y] = Integer.parseInt(null);
            }
        } else {
            for(int i = 0; i < 55; i++){
                int x = random.nextInt(9);
                int y = random.nextInt(9);
                board[x][y] = 0;
            }
        }
    }

    //Backtrack to get solution of the sudoku

    //checks to see if we can assign the number to the column or row or 3x3 grid
    boolean isSafe(int row, int col, int num){
        for(int i = 0; i < 9; i++){
            if(board[row][i] == num)
                return false;
        }

        for(int i = 0; i < 9; i++){
            if(board[i][col] == num)
                return false;
        }

        int startRow = row - (row % 3);
        int startCol = col - (col % 3);

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[startRow][startCol] == num)
                    return false;
            }
        }
        return true;
    }

    //main skeleton of the backtracking function
    boolean solveSudoku(int row, int col){
        if(row == 8 && col == 8)
            return true;

        if(col == 8){
            col = 0;
            row++;
        }

        if(board[row][col] != 0)
            return solveSudoku(row, col+1);

        for(int i = 1; i <= 9; i++){
            if(isSafe(row, col, i)){
                board[row][col] = i;
                if(solveSudoku(row, col+1))
                    return true;
            }
            board[row][col] = 0;
        }
        return false;
    }

//    public static void main(String[] args) {
//        test1 board = new test1();
//        board.shuffleRows();
//        board.shuffleCols();
//        board.shuffle3X3Cols();
//        board.shuffle3X3Rows();
//        board.XMirrorImage();
//        board.YMirrorImage();
//        board.rotate90();
//        board.Transpose();
//        System.out.println(Arrays.deepToString(board.getBoard()));
//
//    }
}
