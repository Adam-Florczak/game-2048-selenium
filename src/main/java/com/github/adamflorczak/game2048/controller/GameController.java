package com.github.adamflorczak.game2048.controller;

import com.github.adamflorczak.game2048.model.Board;
import com.github.adamflorczak.game2048.view.ConsoleView;


public class GameController {

    Board game2048;

    public GameController(){
        game2048 = new Board();
    }

    public GameController (Board game2048){
        this.game2048 = game2048;
    }




    public void start (){

        ConsoleView view = new ConsoleView();


        game2048.generateNumbers();
        game2048.displayBoard();


        while(game2048.gameInProgress() || game2048.isWon()){
            game2048.gameMove(view.directions());
            game2048.displayBoard();
            System.out.println();
            System.out.println("Your current score is " + game2048.getScore());
        }

        System.out.println("You finished the game with " + game2048.getScore() + " points! :)");
    }

}