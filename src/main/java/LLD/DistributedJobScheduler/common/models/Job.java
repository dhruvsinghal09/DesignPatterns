package main.java.LLD.DistributedJobScheduler.common.models;

import main.java.LLD.DistributedJobScheduler.common.enums.Frequency;
import main.java.LLD.DistributedJobScheduler.common.enums.JobStatus;

import java.time.Instant;
import java.util.UUID;

public class Job {
    
    private String jobId;
    private String jobName;
    private final int priority;
    private long scheduledTime;
    private JobStatus status;
    private Frequency frequency;

    public Job(String jobName, int priority, long scheduledTime,Frequency frequency) {
        this.jobId = UUID.randomUUID().toString();;
        this.jobName = jobName;
        this.priority = priority;
        this.scheduledTime = scheduledTime;
        this.status=JobStatus.SCHEDULED;
        this.frequency=frequency;
    }

    public Frequency getFrequency(){
        return frequency;
    }

    public void setStatus(JobStatus status){
        this.status=status;
    }

    public JobStatus getStatus(){
        return status;
    }

    public String getJobId() {
        return jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public int getPriority() {
        return priority;
    }

    public long getScheduledTime() {
        return scheduledTime;
    }

    @Override
    public String toString() {
        return "Job{" +
                "jobId='" + jobId + '\'' +
                ", jobName='" + jobName + '\'' +
                ", priority=" + priority +
                ", scheduledTime=" + Instant.ofEpochMilli(scheduledTime) +
                ", status=" + status +
                ", frequency=" + frequency +
                '}';
    }
}
