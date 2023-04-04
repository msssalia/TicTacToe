package org.example;



class TicTacToeTest {


    public static void main(String[] args) {

        char[][] ticTacToe = {
                {'.', '.', 'X'},
                {'.', 'X', '.'},
                {'X', '.', '.'}
        };

        System.out.println((ticTacToe[0][2] == 'X') && (ticTacToe[1][1] == 'X') && (ticTacToe[2][0] == 'X'));
    }

}