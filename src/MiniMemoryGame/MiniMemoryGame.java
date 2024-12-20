/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package MiniMemoryGame;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author RabiaYAVULUEL
 */
public class MiniMemoryGame {

    public static void main(String[] args) {
    Scanner ky = new Scanner(System.in);
    Random rd = new Random();
    char[] cards = {'?', '?', '!', '!', '^', '^', '+', '+', '%', '%', '&', '&', '/', '/', '(', '('};
    for (int i = 0; i < cards.length; i++) {
        int swap = rd.nextInt(cards.length);
        char temp = cards[i];
        cards[i] = cards[swap];
        cards[swap] = temp;

    }
    char[][] board = new char[4][4];
    boolean[][] revealed = new boolean[4][4];
    for (int i = 0; i < 4; i++) {
        for (int j = 0; j < 4; j++) {
            board[i][j] = cards[i * 4 + j];
            revealed[i][j] = false;
        }
    }
    int pairsFound = 0;
    while (pairsFound<8) {
        System.out.println("\nBoard: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (revealed[i][j]) {
                    System.out.print(board[i][j]+" ");

                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        int row1=-1;
        int column1=-1;
        while (true) {
            System.out.println("Enter the row and column of the first card (e.g., 0 1): ");
            if (ky.hasNextInt()) {
                row1=ky.nextInt();
                column1=ky.nextInt();
                ky.nextLine();
                if (row1>=0&&row1<4&&column1>=0&&column1<4&& !revealed[row1][column1]) {
                    break;


                }

            }else{
                ky.nextLine();
            }
        System.out.println("Invalid input ot card already revealed. Try again");
        }
        revealed[row1][column1]=true;
        System.out.println("\nBoard: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (revealed[i][j]) {
                    System.out.print(board[i][j]+" ");


                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        int row2=-1;
        int column2=-1;
                   while (true) {
            System.out.println("Enter the row and column of the first card (e.g., 0 1): ");
            if (ky.hasNextInt()) {
                row2=ky.nextInt();
                column2=ky.nextInt();
                ky.nextLine();
                if (row2>=0&&row2<4&&column2>=0&&column2<4&& !revealed[row2][column2]) {
                    break;


                }

            }else{
                ky.nextLine();
            }
        System.out.println("Invalid input ot card already revealed. Try again");
        }
        revealed[row2][column2]=true;
        System.out.println("\\nBoard: ");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (revealed[i][j]) {
                    System.out.print(board[i][j]+" ");


                }else{
                    System.out.print("* ");
                }
            }
            System.out.println();
    }
        if (board[row1][column1]==board[row2][column2]) {
            System.out.println("It's a match! ");
            pairsFound++;


        }else{
            System.out.println("No match. Try again.");
            revealed[row1][column1] = false;
            revealed[row2][column2] = false;
        }
}
    System.out.println("Congrats! You found all pairs! ");
    ky.close();
}
}
