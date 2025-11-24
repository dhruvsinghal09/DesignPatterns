package main.java.CreationalPatterns.PrototypePattern;

import java.util.ArrayList;
import java.util.List;

public class GameBoard implements Prototype<GameBoard>{

    private List<GamePiece> gamePieces;

    public GameBoard(){
        gamePieces=new ArrayList<>();
    }

    public void addGamePiece(GamePiece gamePiece){
        gamePieces.add(gamePiece);
    }

    public void showBoardState(){
        for(GamePiece gamePiece:gamePieces){
            System.out.println(gamePiece);
        }
    }

    @Override
    public GameBoard clone() {
        GameBoard copyBoard = new GameBoard();
        for(GamePiece gamePiece:gamePieces){
            copyBoard.addGamePiece(gamePiece.clone());
        }
        return copyBoard;
    }

    @Override
    public String toString() {
        return "GameBoard{" +
                "gamePieces=" + gamePieces +
                '}';
    }
}
