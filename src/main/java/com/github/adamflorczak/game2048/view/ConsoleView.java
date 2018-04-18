package com.github.adamflorczak.game2048.view;

import com.github.adamflorczak.game2048.model.Move;

import java.util.Scanner;

public class ConsoleView {


    public Move directions(){

        Scanner sc = new Scanner(System.in);
        System.out.println("Choose the direction to slide the numbers. \n 'w' goes up. " +
                "\n 's' goes down. \n 'a' goes left. \n 'd' goes right. \n Good luck!");
        String input = sc.nextLine();

        switch (input.toLowerCase()){

            case "w":
                return Move.UP;
            case "a":
                return Move.LEFT;
            case "s":
                return Move.DOWN;
            case "d":
                return Move.RIGHT;
            default:
                throw new IllegalArgumentException("Please choose the direction in accordance with 'wsad' logic");
        }
    }
}
