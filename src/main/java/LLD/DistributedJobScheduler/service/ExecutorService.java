package main.java.LLD.DistributedJobScheduler.service;

import main.java.LLD.DistributedJobScheduler.repository.ExecutorNodesRepository;
import main.java.LLD.DistributedJobScheduler.repository.JobRepository;
import main.java.LLD.DistributedJobScheduler.common.enums.JobStatus;
import main.java.LLD.DistributedJobScheduler.common.models.ExecutorNode;
import main.java.LLD.DistributedJobScheduler.common.models.Job;

import java.util.Iterator;
import java.util.List;

public class ExecutorService {

    private ExecutorNodesRepository nodesRepository;
    private JobRepository jobRepository;

    public ExecutorService(ExecutorNodesRepository nodesRepository,JobRepository jobRepository){
        this.nodesRepository=nodesRepository;
        this.jobRepository=jobRepository;
    }

    private void executeJobsOnNode(ExecutorNode node){
        Iterator<Job> iterator = node.getJobsToExecute().iterator();
        while (iterator.hasNext()){
            Job job = iterator.next();
            jobRepository.updateStatus(job.getJobId(), JobStatus.RUNNING);
            System.out.println("Executing job: " + job.getJobId() + " on node: " + node.getNodeId());
            try{
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                jobRepository.updateStatus(job.getJobId(),JobStatus.FAILED);
                Thread.currentThread().interrupt();
                return;
            }
            System.out.println("Completed job: " + job.getJobId() + " on node: " + node.getNodeId());
            jobRepository.updateStatus(job.getJobId(),JobStatus.COMPLETED);
            iterator.remove();
        }
    }

    public void executeAllJobs(){
        List<ExecutorNode> nodes = nodesRepository.getAllNodes();
        for(ExecutorNode node : nodes){
            executeJobsOnNode(node);
        }
    }


}
