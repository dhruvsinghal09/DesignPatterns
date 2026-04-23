package main.java.LLD.InventoryManagementSystem.service.strategy;

import main.java.LLD.InventoryManagementSystem.models.InventoryRequest;
import main.java.LLD.InventoryManagementSystem.repository.InventoryManager;

public class PurchaseHandler implements RequestHandler{

    private InventoryManager inventoryManager;

    public PurchaseHandler(InventoryManager manager){
        this.inventoryManager=manager;
    }
    @Override
    public void handle(InventoryRequest request) {
        inventoryManager.purchase(request.getProductId(), request.getQuantity());
    }
}
