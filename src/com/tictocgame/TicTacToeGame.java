package com.tictocgame;
import java.util.Scanner;

public class TicTacToeGame {
    Scanner scanner = new Scanner(System.in);
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
        return board;
    }
    //UC2:
    public char chooseLetter() {
        /*
         * Taking input from User to choose either 'X' or 'O'.
         */
        System.out.println("Choose the Letter 'X' or 'O' :-");
        char letter = scanner.next().charAt(0);
        if (letter == 'X' || letter =='O') {
            System.out.println("Player Selected the Letter.");
        }else {
            System.out.println("Invalid Input");
            letter = chooseLetter();
        }
        return letter;
    }
    //UC3:
    public void showBoard(char[] board) {
        /*
          * Player would like to see the board so player can choose the valid cells to make
            their move during player turn.
          * Display the board on Console
         */
        System.out.println("Display the Current Board :-");
        int i=1;
        while (i < 10) {
            System.out.println(board[i]+" "+board[i+1]+" "+board[i+2]);
            i = i+3;
        }
        System.out.println();
    }
    //UC4:
    public void findUserLocation(char playerLetter, char[] board) {
        /*
         * User to make a move to a desired location in the board.
         * Select the index from 1 to 9 to make the move.
         * Ensure the index is Free.
         */
        System.out.println("Enter the position where you want to make a move : ");
        int playerPosition = scanner.nextInt();

        if (playerPosition > 0 && playerPosition < 10) {
            if (board[playerPosition] == '_' ) {
                board[playerPosition] = playerLetter;
            }else {
                System.out.println("Position is Already Occupied !!");
            }
        }else
            System.out.println("Invalid. Please Select the Valid Position");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to Tic Tac Toe Game");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Player Name : ");
        String playerName = scanner.nextLine();
//UC1:
        TicTacToeGame ticTacToeGame = new TicTacToeGame();
        /*
         * Create a board of char[] of size 10 and
         * Create empty board.
         */
        char[] board = new char[10];
        board = ticTacToeGame.CreateEmptyBoard(board);
//UC2:
        /*
         * Player and Computer to choose a letter X or O
         */
        char playerLetter = ticTacToeGame.chooseLetter();
        char computerLetter;
        if (playerLetter == 'X')
            computerLetter = 'O';
        else
            computerLetter = 'X';
        System.out.println(playerName+ "'s Letter is "+playerLetter);
        System.out.println("Computer Player's Letter is "+computerLetter);
//UC3:
        /*
          Method of Show Board
         */
        for (int i=0; i<10; i++) {
            if (i != 0)
                board[i] = '_';
        }
//UC4:
        /*
         * Using Switch Case ,we can select the options given below.
         * call method to find the Player position on board.
         */
        boolean flag = true;
        while (flag) {
            System.out.println("---Select the below options---");
            System.out.println("1.  To Continue the Game \n2.  To view the Current Board \n3.  Quit the Game");
            System.out.println("Enter the option : ");
            int option = scanner.nextInt();
            switch (option){
                case 1:
                    ticTacToeGame.findUserLocation(playerLetter,board);
                    break;
                case 2:
                    ticTacToeGame.showBoard(board);
                    break;
                case 3:
                    flag = false;
                    break;
            }
        }
    }
}
