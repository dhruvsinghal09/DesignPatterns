package main.java.LLD.InventoryManagementSystem.service.strategy;

import main.java.LLD.InventoryManagementSystem.models.InventoryRequest;
import main.java.LLD.InventoryManagementSystem.repository.InventoryManager;

public class ReserveHandler implements RequestHandler{

    private InventoryManager inventoryManager;

    public ReserveHandler(InventoryManager manager){
        this.inventoryManager=manager;
    }

    @Override
    public void handle(InventoryRequest request) {
        inventoryManager.reserveStock(request.getProductId(), request.getQuantity());
    }
}
