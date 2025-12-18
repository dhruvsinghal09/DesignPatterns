package main.java.LLD.DistributedJobScheduler.common.models;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class ExecutorNode {

    private String nodeId;
    private String nodeAddress;
    private int capacity;
    private AtomicInteger currentLoad;
    private List<Job> jobsToExecute;

    public ExecutorNode(int capacity) {
        this.nodeId = UUID.randomUUID().toString();
        this.nodeAddress = UUID.randomUUID().toString();
        this.capacity = capacity;
        currentLoad= new AtomicInteger(0);
        jobsToExecute=new ArrayList<>();
    }

    public String getNodeId() {
        return nodeId;
    }

    public String getNodeAddress() {
        return nodeAddress;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getCurrentLoad() {
        return currentLoad.get();
    }

    public void addJobsToExecute(Job job){
        currentLoad.getAndIncrement();
        jobsToExecute.add(job);
    }

    public List<Job> getJobsToExecute(){
        return jobsToExecute;
    }

    public void removeJob(Job job){
        jobsToExecute.remove(job);
        currentLoad.getAndDecrement();
    }
}
