package com.example.sudoku;

import org.junit.Test;

import static org.junit.Assert.*;

import java.util.Arrays;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

//Unit Test to make sure the Sudoku commands run well
public class ExampleUnitTest {
    @Test
    public void ValidSudokuBoard() {
        Board board = new Board();
        board.shuffleRows();
        board.shuffleCols();
        board.shuffle3X3Cols();
        board.shuffle3X3Rows();
        board.XMirrorImage();
        board.YMirrorImage();
        board.rotate90();
        board.Transpose();
        assertTrue(BoardTest.isValidSudoku(board.getBoard()));
    }

    @Test
    public void ShuffleRows(){
        Board board = new Board();
        board.shuffleRows();
        assertTrue(BoardTest.isValidSudoku(board.getBoard()));
    }

    @Test
    public void ShuffleCols(){
        Board board = new Board();
        board.shuffleCols();
        assertTrue(BoardTest.isValidSudoku(board.getBoard()));
    }

    @Test
    public void Shuffle3x3(){
        Board board = new Board();
        board.shuffle3X3Cols();
        assertTrue(BoardTest.isValidSudoku(board.getBoard()));
    }

    @Test
    public void Shuffle3x3Row(){
        Board board = new Board();
        board.shuffle3X3Rows();
        assertTrue(BoardTest.isValidSudoku(board.getBoard()));
    }

    @Test
    public void MirrorImage1(){
        Board board = new Board();
        board.XMirrorImage();
        assertTrue(BoardTest.isValidSudoku(board.getBoard()));
    }

    @Test
    public void MirrorImage2(){
        Board board = new Board();
        board.YMirrorImage();
        assertTrue(BoardTest.isValidSudoku(board.getBoard()));
    }

    @Test
    public void rotate(){
        Board board = new Board();
        board.rotate90();
        assertTrue(BoardTest.isValidSudoku(board.getBoard()));
    }

    @Test
    public void transposition(){
        Board board = new Board();
        board.Transpose();
        assertTrue(BoardTest.isValidSudoku(board.getBoard()));
    }

    @Test
    public void testEasy(){
        Board board = new Board();
        assertTrue(BoardTest.removeEasy(board.getBoard()));
    }

    @Test
    public void testMedium(){
        Board board = new Board();
        assertTrue(BoardTest.removeMedium(board.getBoard()));
    }

    @Test
    public void testHard(){
        Board board = new Board();
        assertTrue(BoardTest.removeHard(board.getBoard()));
    }

}