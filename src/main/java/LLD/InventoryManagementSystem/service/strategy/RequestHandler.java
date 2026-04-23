package main.java.LLD.InventoryManagementSystem.service.strategy;

import main.java.LLD.InventoryManagementSystem.models.InventoryRequest;

public interface RequestHandler {

    void handle(InventoryRequest request);
}
