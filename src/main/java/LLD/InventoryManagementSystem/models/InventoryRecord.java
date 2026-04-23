package main.java.LLD.InventoryManagementSystem.models;

import java.util.concurrent.atomic.AtomicInteger;

public class InventoryRecord {
    private String productId;
    private AtomicInteger available;
    private int reserved;

    public InventoryRecord(String productId) {
        this.productId = productId;
        this.available = new AtomicInteger(0);
        this.reserved = 0;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public AtomicInteger getAvailable() {
        return available;
    }

    public int getReserved() {
        return reserved;
    }

    public void setReserved(int reserved) {
        this.reserved = reserved;
    }

    @Override
    public String toString() {
        return "InventoryRecord{" +
                "productId='" + productId + '\'' +
                ", available=" + available +
                ", reserved=" + reserved +
                '}';
    }
}
