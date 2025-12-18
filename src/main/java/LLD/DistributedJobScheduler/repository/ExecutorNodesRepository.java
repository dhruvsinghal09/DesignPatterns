package main.java.LLD.DistributedJobScheduler.repository;

import main.java.LLD.DistributedJobScheduler.common.models.ExecutorNode;
import main.java.LLD.DistributedJobScheduler.common.models.Job;

import java.util.*;
import java.util.stream.Collectors;

public class ExecutorNodesRepository {

    private Map<String, ExecutorNode> nodesMap;

    public ExecutorNodesRepository() {
        nodesMap = new HashMap<>();
    }

    public void addNode(ExecutorNode node) {
        System.out.println("Node added: " + node.getNodeId());
        nodesMap.put(node.getNodeId(), node);
    }

    public void deleteNode(String nodeId) {
        if (nodesMap.containsKey(nodeId)) {
            System.out.println("Node removed: " + nodeId);
            nodesMap.remove(nodeId);
            return;
        }
        System.out.println("Node with ID " + nodeId + " does not exist.");
    }

    public List<ExecutorNode> getAllNodes() {
        Collection<ExecutorNode> list = nodesMap.values();
        return list.stream().sorted(Comparator.comparing(ExecutorNode::getCurrentLoad)).collect(Collectors.toList());
    }

    public void removeJobfromNode(String nodeId, Job job ){
        if(nodesMap.containsKey(nodeId)){
            ExecutorNode node = nodesMap.get(nodeId);
            node.removeJob(job);
            System.out.println("Job with ID " + job.getJobId() + " removed from node " + nodeId);
            return;
        }
        System.out.println("Node with ID " + nodeId + " does not exist.");
    }
}
