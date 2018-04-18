package com.github.adamflorczak.game2048;


import com.github.adamflorczak.game2048.controller.GameController;

public class Application {

    public static void main(String[] args) {

        GameController gameController = new GameController();

        gameController.start();

    }
}
