package main.java.LLD.SnakeAndLadders.controller;

import main.java.LLD.SnakeAndLadders.models.Board;
import main.java.LLD.SnakeAndLadders.models.Dice;
import main.java.LLD.SnakeAndLadders.models.Jump;
import main.java.LLD.SnakeAndLadders.models.Player;

import java.util.ArrayDeque;
import java.util.Deque;

public class GameController {
    private Board board;
    private Deque<Player> players;
    private Dice dice;
    private Player winner;

    public GameController(int n,int m,int noOfPlayers,int diceCount, int noOfSnakes,int noOfLadders){
        board = new Board(n,m);
        board.setNoOfLadders(noOfLadders);
        board.setNoOfSnakes(noOfSnakes);
        players = new ArrayDeque<>();
        addPlayers(noOfPlayers);
        dice=new Dice(diceCount);
    }

    private void addPlayers(int noOfPlayers) {
        int count=0;
        while(noOfPlayers-->0){
            players.offer(new Player("P"+ (++count)));
        }
    }

    public void startGame(){
        while(true){
            Player player = playerTurn();
            int diceCount = dice.rollDice();
            int currentPosition = player.getCurrentPosition();
            int position = currentPosition + diceCount;
            if(position>99)
                continue;
            System.out.println("Current player playing is " + player.getName());
            int newPosition = checkForSnakersOrLadders(board, position);
            player.setCurrentPosition(newPosition);
            if(newPosition==board.getCells().length-1){
                winner=player;
                return;
            }
        }
    }

    private int checkForSnakersOrLadders(Board board, int newPosition) {
        Jump jump = board.getCells()[newPosition].getJump();
        if(jump!=null){
            int start = jump.getStart();
            int end = jump.getEnd();
            System.out.println("start is" + start + " end is " + end);
            if(start>end){
                System.out.println("Player is on snakes cell");
                newPosition=end;
            }else{
                System.out.println("Player is on ladder cell");
                newPosition=end;
            }
            System.out.println("Player's new position on board " +newPosition);
        }
        return newPosition;
    }

    private Player playerTurn(){
        Player current = players.pollFirst();
        players.addLast(current);
        return current;
    }


    public Player getWinner(){
        return winner;
    }
}
