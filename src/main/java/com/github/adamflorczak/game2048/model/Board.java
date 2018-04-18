package com.github.adamflorczak.game2048.model;

import java.util.Random;



public class Board {

    private final int SIZE = 4;
    private int[][] gameBoard = new int[SIZE][SIZE];
    private int score;

    public Board(){

    }

    private void moveAndMergeLogic() {
        moveLogic();
        merge();
        moveLogic();
    }

    private void moveLogic() {

        for (int i = 0; i < SIZE; i++) {
            for (int x = 0; x < 3; x++) {
                for (int j = 0; j < SIZE - 1; j++) {
                    if (gameBoard[i][j] == 0) {
                        if (gameBoard[i][j] < gameBoard[i][j + 1]) {
                            int numberZero = gameBoard[i][j];
                            gameBoard[i][j] = gameBoard[i][j + 1];
                            gameBoard[i][j + 1] = numberZero;
                        }
                    }

                }
            }
        }
    }


    private void merge() {

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - 1; j++) {
                if (gameBoard[i][j] == gameBoard[i][j + 1]) {
                    int value = gameBoard[i][j];
                    score = score + gameBoard[i][j + 1] + value;
                    gameBoard[i][j] = gameBoard[i][j + 1] + value;
                    gameBoard[i][j + 1] = 0;
                }
            }
        }
    }

    private void moveLeft() {
        moveAndMergeLogic();
    }

    private void moveDown() {
        rotateLogic();
        moveAndMergeLogic();
        rotateLogic();
        rotateLogic();
        rotateLogic();
    }

    private void moveUp() {
        rotateLogic();
        rotateLogic();
        rotateLogic();
        moveAndMergeLogic();
        rotateLogic();
    }

    private void moveRight() {
        rotateLogic();
        rotateLogic();
        moveAndMergeLogic();
        rotateLogic();
        rotateLogic();


    }

    private void rotateLogic() {
        final int M = gameBoard.length;
        final int N = gameBoard[0].length;
        int[][] temp = new int[N][M];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                temp[c][M - 1 - r] = gameBoard[r][c];
            }
        }
            gameBoard = temp;
    }

    public void generateNumbers() {

        Random rand = new Random();
        int lottery = rand.nextInt(100);

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int x = rand.nextInt(SIZE);
                int y = rand.nextInt(SIZE);
                if (gameBoard[x][y] == 0 && lottery < 90) {
                    gameBoard[x][y] = 2;
                } else if (gameBoard[x][y] == 0 & lottery < 10){
                    gameBoard[x][y] = 4;
                }
            }
        }
    }

    private void moveLeftAndGenerate() {
        moveLeft();
        generateNumbers();
    }

    private void moveRightAndGenerate() {
        moveRight();
        generateNumbers();
    }

    private void moveUpAndGenerate() {
        moveUp();
       generateNumbers();
    }

    private void moveDownAndGenerate() {
        moveDown();
        generateNumbers();
    }

    public void gameMove(Move move) {

        if (move == Move.UP) {
            moveUpAndGenerate();
        }
        if (move == Move.DOWN){
            moveDownAndGenerate();
        }
        if (move == Move.LEFT){
            moveLeftAndGenerate();
        }
        if (move == Move.RIGHT){
            moveRightAndGenerate();
        }

    }

    public int getScore() {
        return score;
    }

    public boolean gameInProgress() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (gameBoard[i][j] == 0) {
                    return true;
                }
                if (j < SIZE - 1) {
                    if (gameBoard[i][j] == gameBoard[i][j + 1]) {
                        return true;
                    }
                }
                if (i < SIZE - 1) {
                    if (gameBoard[i][j] == gameBoard[i + 1][j]) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean isWon(){
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (gameBoard[i][j] == 2048){
                    return true;
                }
            }
        }
        return true;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                sb.append(gameBoard[i][j]);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void displayBoard() {
        System.out.println(toString());
    }
}
