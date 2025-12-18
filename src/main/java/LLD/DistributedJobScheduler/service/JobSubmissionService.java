package main.java.LLD.DistributedJobScheduler.service;

import main.java.LLD.DistributedJobScheduler.repository.JobRepository;
import main.java.LLD.DistributedJobScheduler.common.models.Job;

import java.util.List;

public class JobSubmissionService {

    private final JobRepository jobRepository;

    public JobSubmissionService(JobRepository jobRepository){
        this.jobRepository=jobRepository;
    }

    public void saveJob(Job job){
        jobRepository.saveJob(job);
    }

    public void deleteJob(String jobId){
        jobRepository.deleteJob(jobId);
    }

    public List<Job> getAllJobs(){
        return jobRepository.getAllJobs();
    }
}
