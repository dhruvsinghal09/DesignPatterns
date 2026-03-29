package main.java.LLD.VendingMachine.models;

public class ItemShelf {
    private Item item;
    private boolean soldOut;
    private int codeNumber;

    public ItemShelf(int codeNumber){
        this.soldOut=false;
        this.codeNumber=codeNumber;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isSoldOut() {
        return soldOut;
    }

    public void setSoldOut(boolean soldOut) {
        this.soldOut = soldOut;
    }

    public int getCodeNumber() {
        return codeNumber;
    }

    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }
}
