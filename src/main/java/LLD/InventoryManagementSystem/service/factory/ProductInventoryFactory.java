package main.java.LLD.InventoryManagementSystem.service.factory;

import main.java.LLD.InventoryManagementSystem.models.InventoryRequest;
import main.java.LLD.InventoryManagementSystem.repository.InventoryManager;
import main.java.LLD.InventoryManagementSystem.service.strategy.*;

public class ProductInventoryFactory {

    private InventoryManager manager;

    public ProductInventoryFactory(InventoryManager manager){
        this.manager=manager;
    }

    public RequestHandler getRequestHandler(InventoryRequest request){
        return switch (request.getRequestType()){
            case RELEASE -> new ReleaseHandler(manager);
            case RESERVE -> new ReserveHandler(manager);
            case ADD_STOCK -> new AddStocksHandler(manager);
            case PURCHASE -> new PurchaseHandler(manager);
            case null, default -> throw new RuntimeException("Invalid RequestType ");
        };
    }
}
