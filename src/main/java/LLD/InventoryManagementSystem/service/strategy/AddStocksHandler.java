package main.java.LLD.InventoryManagementSystem.service.strategy;

import main.java.LLD.InventoryManagementSystem.models.InventoryRequest;
import main.java.LLD.InventoryManagementSystem.repository.InventoryManager;

public class AddStocksHandler implements RequestHandler{

    private InventoryManager inventoryManager;

    public AddStocksHandler(InventoryManager manager){
        this.inventoryManager=manager;
    }
    @Override
    public void handle(InventoryRequest request) {
        inventoryManager.addStock(request.getProductId(), request.getQuantity());
    }
}
