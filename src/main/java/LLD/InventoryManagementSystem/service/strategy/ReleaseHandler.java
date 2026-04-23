package main.java.LLD.InventoryManagementSystem.service.strategy;

import main.java.LLD.InventoryManagementSystem.models.InventoryRequest;
import main.java.LLD.InventoryManagementSystem.repository.InventoryManager;

public class ReleaseHandler implements RequestHandler{

    private InventoryManager inventoryManager;

    public ReleaseHandler(InventoryManager manager){
        this.inventoryManager=manager;
    }
    @Override
    public void handle(InventoryRequest request) {
        inventoryManager.releaseStock(request.getProductId(), request.getQuantity());
    }
}
