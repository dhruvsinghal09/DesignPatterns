package main.java.LLD.InventoryManagementSystem;

import main.java.LLD.InventoryManagementSystem.models.InventoryRequest;
import main.java.LLD.InventoryManagementSystem.models.RequestType;
import main.java.LLD.InventoryManagementSystem.repository.InventoryManager;
import main.java.LLD.InventoryManagementSystem.service.InventorySystem;

public class Main {

    public static void main(String[] args){
        InventoryManager manager = new InventoryManager();
        manager.addProduct("P1",0);
        manager.addProduct("P2",0);
        manager.addProduct("P3",0);
        manager.addProduct("P4",0);
        manager.addProduct("P5",0);
        System.out.println("Product P1 is " + manager.getProduct("P1"));
        InventorySystem system = new InventorySystem(manager);
        InventoryRequest r1 = new InventoryRequest("R1","P1",10, RequestType.ADD_STOCK);
        InventoryRequest r2 = new InventoryRequest("R2","P2",10,RequestType.RESERVE);
        system.submit(r1);
        system.submit(r2);
        InventoryRequest r3 = new InventoryRequest("R3","P1",8,RequestType.RESERVE);
        InventoryRequest r4 = new InventoryRequest("R4","P1",6,RequestType.PURCHASE);
        system.submit(r3);
        system.submit(r4);
        system.start();
        system.stopAndWait();
        //system.submit(r2);

    }
}
