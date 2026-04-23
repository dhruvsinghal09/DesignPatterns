package main.java.LLD.InventoryManagementSystem.repository;

import main.java.LLD.InventoryManagementSystem.models.InventoryRecord;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;

public class InventoryManager {

    private ConcurrentHashMap<String, InventoryRecord> inventory;

    private ConcurrentHashMap<String, ReentrantLock> locks;

    public InventoryManager(){
        inventory=new ConcurrentHashMap<>();
        locks=new ConcurrentHashMap<>();
    }

    public void addProduct(String productId,int quantity){
        System.out.println("Inside InventoryManager for addProduct with productId " + productId);
        inventory.computeIfAbsent(productId,r->new InventoryRecord(productId));
        ReentrantLock lock = acquireLock(productId);
        lock.lock();
        try{
            InventoryRecord record = inventory.get(productId);
            record.getAvailable().getAndAdd(quantity);
            System.out.println("Inside InventoryManager for addProduct with product successfully added with id " + productId);
        }finally {
            lock.unlock();
        }
    }

    public void addStock(String productId,int quantity){
        System.out.println("Inside InventoryManager for addStock with product id " + productId);
        InventoryRecord record = helper(productId);
        if(null==record){
            throw new RuntimeException("Exception occurred while adding stock. Product Doesn't exists in our inventory.");
        }
        ReentrantLock lock = acquireLock(productId);
        lock.lock();
        try{
            record.getAvailable().getAndAdd(quantity);
            System.out.println("Inside InventoryManager for addStock with stock successfully added for product id " + productId);

        }finally {
            lock.unlock();
        }
    }

    public void reserveStock(String productId,int quantity){
        System.out.println("Inside InventoryManager for reserveStock with product id " + productId);
        InventoryRecord record = helper(productId);
        if(null==record){
            throw new RuntimeException("Exception occurred while reserving stock. Product Doesn't exists in our inventory.");
        }
        ReentrantLock lock = acquireLock(productId);
        lock.lock();
        try{
            int available = record.getAvailable().get();
            if(available<quantity)
                throw new RuntimeException("Exception occurred while reserving stock. Inventory has lesser stocks available.");
            record.getAvailable().addAndGet(-quantity);
            record.setReserved(record.getReserved()+quantity);
            System.out.println("Inside InventoryManager for reserveStock with stock successfully reserved for product id " + productId);
        }finally {
            lock.unlock();
        }
    }

    public void releaseStock(String productId,int quantity){
        System.out.println("Inside InventoryManager for releaseStock with product id " + productId);
        InventoryRecord record = helper(productId);
        if(null==record){
            throw new RuntimeException("Exception occurred while releasing stock. Product Doesn't exists in our inventory.");
        }
        ReentrantLock lock = acquireLock(productId);
        lock.lock();
        try{
            int reserved = record.getReserved();
            if(reserved<quantity){
                throw new RuntimeException("Exception occurred while releasing stock. Inventory has lesser reserved stocks.");
            }
            record.setReserved(record.getReserved()-quantity);
            record.getAvailable().addAndGet(quantity);
            System.out.println("Inside InventoryManager for releaseStock with stock released reserved for product id " + productId);
        }finally {
            lock.unlock();
        }
    }

    public void purchase(String productId,int quantity){
        System.out.println("Inside InventoryManager for purchase with product id " + productId);
        InventoryRecord record = helper(productId);
        if(null==record){
            throw new RuntimeException("Exception occurred while releasing stock. Product Doesn't exists in our inventory.");
        }
        ReentrantLock lock = acquireLock(productId);
        lock.lock();
        try{
            int reserved = record.getReserved();
            if(reserved<quantity){
                throw new RuntimeException("Exception occurred while releasing stock. Inventory has lesser reserved stocks than the purchase order.");
            }
            record.setReserved(record.getReserved()-quantity);
            System.out.println("Inside InventoryManager for purchase with product successfully purchased for product id " + productId);
        }finally {
            lock.unlock();
        }
    }

    public InventoryRecord getProduct(String productId){
        return inventory.get(productId);
    }

    private InventoryRecord helper(String productId){
        return inventory.get(productId);
    }

    private ReentrantLock acquireLock(String productId) {
        return locks.computeIfAbsent(productId,l->new ReentrantLock());
    }
}
