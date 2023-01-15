/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package learningtoprogram;

/**
 * Author: Kinjal Class: ICS3U
 *
 * Program: Tic Tac Toe Input: each player inputs the row and colum they would want the place and 'X' or 'O'
 * Processing: the computer checks to see if the letters are repeated three in a row or not 
 * Output: either one player wins or they continue palcing X's and O's 
 *
 */
//Import Statements Listed Alphabetically
import java.io.*;           //used for any type of input or output
import java.util.*;         //useful utilities like Scanner
import hsa.Console;
import hsa.*;

/**
 *
 * @author Kinjal
 */
public class TicTacToe {
//creates method that prints array for tic tac toe board
public static void printTTT(char[][] board, Console c){
for(int row=0;row<board.length;row++){
            for (int col = 0; col<board.length;col++){
                c.print(board[row][col] + " ");
                
                }
            c.println();
        }
}
//method that declares if any player won
public static boolean winner(char[][] board, Console c)
{
    //boolean statement that checks if any rows, columns, or two diagnals have three in a row, without one of them being a default '0'    
    //checks to make sure that in each boolean statemnet, the postion is not occupied by the default '0'
    return (board [0][0] == board [0][1] && board[0][0] == board [0][2] && board [0][0] != '0') ||
           (board[0][1] == board [1][1] && board [0][1] == board [2][1] && board [0][1] != '0') ||
           (board[0][2] == board [1][2] && board [0][2] == board [2][2] && board [0][2] != '0') ||
           (board [0][0] == board[0][1] && board[0][0] == board [0][2] && board [0][0] != '0')  ||
           (board [1][0] == board [1][1] && board [1][0] == board [1][2] && board [1][0] != '0')||
           (board [2][0] == board [2][1] && board [2][0] == board [2][2] && board [2][0] != '0')||
           (board [0][0] == board[1][1] && board [0][0] == board [2][2] && board [0][0] != '0') ||
           (board [0][2] == board [1][1] && board [0][2] == board [2][0]&& board [0][2] != '0');
}



    /**
     * * MAIN METHOD
     *
     **
     * @param args
     */
    public static void main(String[] args) {

        //FIRST WRITE YOUR PSEUDOCODE USING COMMENTS, THEN FILL IN WITH CODE
        System.out.println("Starting...");
        Console c = new Console();
        //creates 2d array for board
        char [][] board = new char [3][3];
        //fills up the board once to get one board already filled
        for(int row=0;row<board.length;row++){
            for (int col = 0; col<board.length;col++){
                board [row] [col] = '0';
                
                }
        }
        //declares variables for each player, row and columsn
        int i = 0;
        int moveRow= 0, moveCol = 0;
        char player = 'X';
        printTTT(board, c);
        //while the winner method it false (no one has gotten 3 in a row)
        while (true) {
        //asks player 1 to to insert row and column they woudl like to print x and stores the number
        c.println ("Player 1: Where would you like to place " + player + " . Type [row] and [column] using 0,1, or 2.");
        moveRow = c.readInt();
        moveCol = c.readInt(); 
        //if the row and column chosen is already occupied then asks user to try again
        if (board[moveRow] [moveCol] == 'X' || board[moveRow][moveCol] == 'O') {
            c.println ("Sorry this spot is occcupied. Try again.");
            continue;
        }
        //puts X in place of row and column and prints the board again 
        board [moveRow] [moveCol] =  player;
        printTTT(board,c);
        
        //if player X is playing then switches it to player O and vice versa 
        if (player == 'X') {
            player = 'O';
        }
        else {
            player = 'X';
        }
        //if the winner method is satified (as in the player get 3 in a row) 
            if (winner(board,c) == true){
                //the player at that turn wins and the player can exit 
                  c.println ("Congratulations, " + player + " won!");
                  c.println ("Press any key to exit!");
                  c.getChar();
                  break;
        }}
        }

        
    

    }

