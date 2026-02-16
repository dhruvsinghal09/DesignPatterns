package main.java.LLD.SnakeAndLadders.models;

import java.util.concurrent.ThreadLocalRandom;

public class Board {

    Cell[] cells;

    public Board(int boardWidth,int boardLength){
        cells=new Cell[boardLength*boardLength];
        initializeCells();
    }

    public void initializeCells(){
        int n = cells.length;
        for(int i=0;i<n;i++){
            cells[i]=new Cell();
        }
    }

    public Cell[] getCells() {
        return cells;
    }

    public void setNoOfSnakes(int no){
        while(no-->0){
            int start = ThreadLocalRandom.current().nextInt(1,cells.length-1);
            int end = ThreadLocalRandom.current().nextInt(1,cells.length-1);
            if(end>=start){
                continue;
            }
            Jump jump = new Jump(start,end);
            alignToCell(jump);
            no--;
        }
    }

    public void setNoOfLadders(int no){
        while(no-->0){
            int start = ThreadLocalRandom.current().nextInt(1,cells.length-1);
            int end = ThreadLocalRandom.current().nextInt(1,cells.length-1);
            if(start>=end){
                continue;
            }
            Jump jump = new Jump(start,end);
            alignToCell(jump);
            no--;
        }
    }

    private void alignToCell(Jump jump){
        int index = ThreadLocalRandom.current().nextInt(1, cells.length-1);
        while(cells[index].getJump()!=null){
            index = ThreadLocalRandom.current().nextInt(1, cells.length-1);
        }
        cells[index].setJump(jump);
    }


}
