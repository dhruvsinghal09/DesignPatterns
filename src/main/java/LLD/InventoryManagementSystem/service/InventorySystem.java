package main.java.LLD.InventoryManagementSystem.service;


import main.java.LLD.InventoryManagementSystem.models.InventoryRequest;
import main.java.LLD.InventoryManagementSystem.repository.InventoryManager;
import main.java.LLD.InventoryManagementSystem.service.factory.ProductInventoryFactory;

import java.util.concurrent.*;

public class InventorySystem {

    private ExecutorService executorService;
    private BlockingQueue<InventoryRequest> queue;
    private InventoryManager manager;


    public InventorySystem(InventoryManager manager){
        this.queue=new LinkedBlockingQueue<>();
        this.executorService = Executors.newFixedThreadPool(3);
        this.manager=manager;
    }

    public void start(){
        for(int i=0;i<3;i++){
            executorService.submit(
                    new RequestProcessor(
                            queue,
                            new ProductInventoryFactory(manager)
                    )
            );
        }
    }

    public void submit(InventoryRequest request){
        System.out.println("Request submitted " + request);
        queue.offer(request);
    }

    public void stopAndWait(){
        executorService.shutdownNow();
        try{
            executorService.awaitTermination(10,TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
