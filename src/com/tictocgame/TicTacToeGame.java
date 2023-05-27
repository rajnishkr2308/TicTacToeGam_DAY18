package com.tictocgame;

public class TicTacToeGame {
    //UC1:
    public char[] CreateEmptyBoard(char[] board) {
        /*
         * 0th index is ignored to make it user-friendly.
         * Assign Empty space to each Element.
         */
        for (int i=0; i < 10; i++) {
            if (i == 0) {
                continue;
            }else {
                board[i] = ' ';
            }
        }
        System.out.println("Currently No one is playing the Game");
        return board;
    }
    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        /*
         * Create a board of char[] of size 10 and
         * Create empty board.
         */
        char[] board = new char[10];
        board = ticTacToeGame.CreateEmptyBoard(board);

    }
}

