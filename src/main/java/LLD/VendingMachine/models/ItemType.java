package main.java.LLD.VendingMachine.models;

public enum ItemType {
    COKE(10),
    PEPSI(10),
    FANTA(8),
    LIMCA(9);

    private int value;

    ItemType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
