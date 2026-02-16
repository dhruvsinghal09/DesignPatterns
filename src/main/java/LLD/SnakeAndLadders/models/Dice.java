package main.java.LLD.SnakeAndLadders.models;

import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int diceCount;

    public Dice(int diceCount){
        this.diceCount=diceCount;
    }

    public int getDiceCount(){
        return diceCount;
    }

    public int rollDice(){
        int sum=0;
        for(int i=0;i<diceCount;i++){
            sum+= ThreadLocalRandom.current().nextInt(1,7);
        }
        return sum;
    }
}
