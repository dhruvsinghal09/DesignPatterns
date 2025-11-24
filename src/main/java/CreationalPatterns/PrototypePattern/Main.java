package main.java.CreationalPatterns.PrototypePattern;

public class Main {

    public static void main(String[] args){
        GamePiece gamePiece = new GamePiece("Red",1);
        GamePiece gamePiece1 = new GamePiece("Blue",5);
        GameBoard gameBoard = new GameBoard();
        gameBoard.addGamePiece(gamePiece);
        gameBoard.addGamePiece(gamePiece1);
        gameBoard.showBoardState();

        GameBoard copyBoard = gameBoard.clone();
        System.out.println("Board Copied");
        copyBoard.showBoardState();
    }
}
