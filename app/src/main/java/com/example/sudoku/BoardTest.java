package com.example.sudoku;

import java.util.Arrays;
import java.util.Random;

public class BoardTest {
    static boolean inRange(int[][] board){
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] <= 0 || board[i][j] > 9)
                    return false;
            }
        }
        return true;
    }

    static boolean isValidSudoku(int board[][]) {
        int N = 9;
        if (!inRange(board)) {
            return false;
        }

        boolean[] unique = new boolean[N + 1];

        for(int i = 0; i < N; i++) {
            Arrays.fill(unique, false);
            for(int j = 0; j < N; j++) {
                int Z = board[i][j];
                if (unique[Z]) {
                    return false;
                }
                unique[Z] = true;
            }
        }


        for(int i = 0; i < N; i++) {
            Arrays.fill(unique, false);
            for(int j = 0; j < N; j++) {
                int Z = board[j][i];
                if (unique[Z]) {
                    return false;
                }
                unique[Z] = true;
            }
        }

        for(int i = 0; i < N - 2; i += 3) {
            for(int j = 0; j < N - 2; j += 3) {
                Arrays.fill(unique, false);
                for(int k = 0; k < 3; k++) {
                    for(int l = 0; l < 3; l++) {
                        int X = i + k;
                        int Y = j + l;
                        int Z = board[X][Y];
                        if (unique[Z]) {
                            return false;
                        }
                        unique[Z] = true;
                    }
                }
            }
        }
        return true;
    }

    static boolean removeEasy(int board[][]){
        Random random = new Random();
        for(int i = 0; i < 30; i++){
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            if(board[x][y] != 0){
                board[x][y] = 0;
            }
        }

        int count = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == 0)
                    count++;
            }
        }

        return count != 30;
    }

    static boolean removeMedium(int board[][]){
        Random random = new Random();
        for(int i = 0; i < 45; i++){
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            if(board[x][y] != 0){
                board[x][y] = 0;
            }
        }

        int count = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == 0)
                    count++;
            }
        }

        return count != 45;
    }

    static boolean removeHard(int board[][]){
        Random random = new Random();
        for(int i = 0; i < 55; i++){
            int x = random.nextInt(9);
            int y = random.nextInt(9);
            if(board[x][y] != 0){
                board[x][y] = 0;
            }
        }

        int count = 0;
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == 0)
                    count++;
            }
        }

        return count != 55;
    }
}