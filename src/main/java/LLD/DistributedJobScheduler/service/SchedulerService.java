package main.java.LLD.DistributedJobScheduler.service;

import main.java.LLD.DistributedJobScheduler.repository.JobRepository;
import main.java.LLD.DistributedJobScheduler.common.models.Job;

import java.util.List;

public class SchedulerService {

    private JobRepository jobRepository;

    private Coordinator coordinator;

    public SchedulerService(JobRepository jobRepository,Coordinator coordinator){
        this.jobRepository=jobRepository;
        this.coordinator=coordinator;
    }

    public void pickJobs(){
        List<Job> jobs = jobRepository.getAllJobs();
        coordinator.assignListOfJobsToExecutors(jobs);
    }

}
