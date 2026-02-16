package main.java.LLD.SnakeAndLadders;

import main.java.LLD.SnakeAndLadders.controller.GameController;
import main.java.LLD.SnakeAndLadders.models.Player;

public class SnakerAndLadderMain {

    public static void main(String[] args){
        GameController gameController = new GameController(10,10,2,1,3,2);
        gameController.startGame();
        Player winner = gameController.getWinner();
        System.out.println("Player " + winner.getName() + " won the game. Hurray !!");
    }
}
