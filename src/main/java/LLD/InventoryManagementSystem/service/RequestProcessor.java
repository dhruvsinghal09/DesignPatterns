package main.java.LLD.InventoryManagementSystem.service;

import main.java.LLD.InventoryManagementSystem.models.InventoryRequest;
import main.java.LLD.InventoryManagementSystem.service.factory.ProductInventoryFactory;
import main.java.LLD.InventoryManagementSystem.service.strategy.RequestHandler;

import java.util.concurrent.BlockingQueue;

public class RequestProcessor implements Runnable{

    private BlockingQueue<InventoryRequest> queue;
    private ProductInventoryFactory productInventoryFactory;

    public RequestProcessor(BlockingQueue<InventoryRequest> queue,ProductInventoryFactory factory){
        this.queue=queue;
        this.productInventoryFactory=factory;
    }

    @Override
    public void run() {
        while(true){
            try {
                InventoryRequest inventoryRequest = queue.take();
                System.out.println("Currently processing request " + inventoryRequest.getRequestId());
                process(inventoryRequest);
            } catch (InterruptedException e){
                System.out.println("Exception occurred in request processing for requestId " + e);
            } catch (Exception e){
                System.out.println("Exception occurred in request processing for requestId " + e);
            }
        }
    }

    private void process(InventoryRequest inventoryRequest) {
        RequestHandler requestHandler = productInventoryFactory.getRequestHandler(inventoryRequest);
        requestHandler.handle(inventoryRequest);
    }
}
