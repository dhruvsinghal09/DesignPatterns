package main.java.LLD.InventoryManagementSystem.service.strategy;

import main.java.LLD.InventoryManagementSystem.models.InventoryRequest;
import main.java.LLD.InventoryManagementSystem.repository.InventoryManager;

public class AddProductHandler implements RequestHandler{

    private InventoryManager inventoryManager;

    public AddProductHandler(InventoryManager manager){
        this.inventoryManager=manager;
    }
    @Override
    public void handle(InventoryRequest request) {
        inventoryManager.addProduct(request.getProductId(), request.getQuantity());
    }
}
