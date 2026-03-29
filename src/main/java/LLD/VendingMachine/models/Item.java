package main.java.LLD.VendingMachine.models;

public class Item {
    private ItemType item;
    private int price;

    public Item(ItemType type){
        this.item=type;
        this.price=type.getValue();
    }

    public ItemType getItem() {
        return item;
    }

    public void setItem(ItemType item) {
        this.item = item;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
