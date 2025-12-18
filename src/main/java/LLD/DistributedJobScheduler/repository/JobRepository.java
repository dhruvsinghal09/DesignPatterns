package main.java.LLD.DistributedJobScheduler.repository;

import main.java.LLD.DistributedJobScheduler.common.enums.JobStatus;
import main.java.LLD.DistributedJobScheduler.common.models.Job;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobRepository {

    private final Map<String, Job> jobStorage;

    public JobRepository(){
        jobStorage=new HashMap<>();
    }

    public void saveJob(Job job){
        if(jobStorage.containsKey(job.getJobId())){
            System.out.println("Job with ID " + job.getJobId() + " already exists.");
            return;
        }
        jobStorage.put(job.getJobId(), job);
        System.out.println("Job with ID " + job.getJobId() + " saved successfully.");
    }

    public void deleteJob(String jobId){
        if(jobStorage.containsKey(jobId)){
            jobStorage.remove(jobId);
            System.out.println("Job with ID " + jobId + " deleted successfully.");
            return;
        }
        System.out.println("Job with ID " + jobId + " does not exist.");
    }

    public List<Job> getAllJobs(){
        return jobStorage.values().stream().toList();
    }

    public void updateStatus(String jobId, JobStatus status){
        if(jobStorage.containsKey(jobId)){
            Job job = jobStorage.get(jobId);
            job.setStatus(status);
            System.out.println("Job with ID " + jobId + " status updated to " + status);
            return;
        }
        System.out.println("Job with ID " + jobId + " does not exist.");
    }
}
