package main.java.LLD.DistributedJobScheduler.service;

import main.java.LLD.DistributedJobScheduler.repository.ExecutorNodesRepository;
import main.java.LLD.DistributedJobScheduler.common.models.ExecutorNode;
import main.java.LLD.DistributedJobScheduler.common.models.Job;

import java.util.List;

public class Coordinator {

    private ExecutorNodesRepository nodesRepository;

    public Coordinator(ExecutorNodesRepository nodesRepository){
        this.nodesRepository=nodesRepository;
    }

    /*
    If we are using Queues then this method assignJobToExecutor would not be here, instead we would have a producer at
    SchedulerService which would push jobs to the queue and each ExecutorNode would have a consumer
    which would pull jobs from the queue when they are free to execute a new job.
     */
    public void assignJobToExecutor(Job job){
        List<ExecutorNode> nodes = nodesRepository.getAllNodes();
        for(ExecutorNode node : nodes){
            if(node.getCapacity()>node.getCurrentLoad()){
                node.addJobsToExecute(job);
                return;
            }
        }
        System.out.println("No available executor node found for job: " + job.getJobId());
    }

    public void assignListOfJobsToExecutors(List<Job> jobs){
        for(Job job : jobs){
            assignJobToExecutor(job);
        }
    }

    public String addNode() {
        ExecutorNode node = new ExecutorNode(5);
        nodesRepository.addNode(node);
        return node.getNodeId();
    }

    public void deleteNode(String nodeId) {
        nodesRepository.deleteNode(nodeId);
    }
}
