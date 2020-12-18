package nl.novi.TicTacToe;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Welkom bij TicTacToe");

        // Stap 1: maak een bord
        String[] board = new String[9];

        for(int i = 0; i < 9; i++){
            board[i] = Integer.toString(i);
        }

        // Toon het bord
        printBoard(board);

        String currentPlayer = "X";
        boolean hasWon = false;

        while(hasWon == false){
        // Stap 2: geef de speler de mogelijkheid om een symbool te zetten
        System.out.println("\n Voer een cijfer van 0 t/m 8 in om op het bord een "+ currentPlayer + " te zetten");

        Scanner userInput = new Scanner(System.in);
        int selectedField = userInput.nextInt();

        board[selectedField] = currentPlayer;

        // Toon het bord
        printBoard(board);

        hasWon = HasPlayerWon(board, currentPlayer);

        // Wissel van speler
        currentPlayer = switchPlayer(currentPlayer);
        }

        System.out.println("Gefeliciteerd, je hebt gewonnen: " + currentPlayer);
    }

    public static void printBoard(String[] board){
        // Toon het bord
        for (int i = 0; i < board.length; i++){
            System.out.print(board[i]);

            boolean isEndOfRow = (i + 1) % 3 == 0;
            boolean isLastField = i == 8;

            if(isEndOfRow == false){
                System.out.print(" | ");
            }
            if (isEndOfRow && !isLastField){
                System.out.println("\n ___________");
            }
        }
    }

    public static String switchPlayer(String currentPlayer){
        if (currentPlayer == "X"){
            return "O";
        }
        else{
            return "X";
        }
    }

    public static boolean HasPlayerWon(String[] board, String currentPlayer){

        // Horizontale opties om te winnen
        if (board[0] == currentPlayer && board[1] == currentPlayer && board[2] == currentPlayer){
            return true;
        }
        if (board[3] == currentPlayer && board[4] == currentPlayer && board[4] == currentPlayer){
            return true;
        }
        if (board[6] == currentPlayer && board[7] == currentPlayer && board[8] == currentPlayer){
            return true;
        }
        // Verticale opties om te winnen
        if (board[0] == currentPlayer && board[3] == currentPlayer && board[6] == currentPlayer){
            return true;
        }
        if (board[1] == currentPlayer && board[4] == currentPlayer && board[7] == currentPlayer){
            return true;
        }
        if (board[2] == currentPlayer && board[5] == currentPlayer && board[8] == currentPlayer){
            return true;
        }
        // Diagonale opties om te winnen
        if (board[0] == currentPlayer && board[4] == currentPlayer && board[8] == currentPlayer){
            return true;
        }
        if (board[2] == currentPlayer && board[4] == currentPlayer && board[6] == currentPlayer){
            return true;
        }
        return false;
    }
}
