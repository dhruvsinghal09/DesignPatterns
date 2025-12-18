package main.java.LLD.DistributedJobScheduler;

import main.java.LLD.DistributedJobScheduler.common.enums.Frequency;
import main.java.LLD.DistributedJobScheduler.common.models.Job;
import main.java.LLD.DistributedJobScheduler.repository.ExecutorNodesRepository;
import main.java.LLD.DistributedJobScheduler.repository.JobRepository;
import main.java.LLD.DistributedJobScheduler.service.Coordinator;
import main.java.LLD.DistributedJobScheduler.service.ExecutorService;
import main.java.LLD.DistributedJobScheduler.service.JobSubmissionService;
import main.java.LLD.DistributedJobScheduler.service.SchedulerService;

public class MainJobScheduler {
    public static void main(String[] args){
        JobRepository jobRepository = new JobRepository();
        Job j1 = new Job("job 1",0,1737282600L, Frequency.DAILY);
        Job j2 = new Job("job 2",0,1737212600L,Frequency.WEEKLY);
        Job j3 = new Job("job 3",0,1737134600L,Frequency.MONTHLY);
        Job j4 = new Job("job 4",0,2324382600L,Frequency.MONTHLY);

        JobSubmissionService jobSubmissionService = new JobSubmissionService(jobRepository);
        //Post request to controller to add job to our DB.
        jobSubmissionService.saveJob(j1);
        jobSubmissionService.saveJob(j2);
        jobSubmissionService.saveJob(j3);
        jobSubmissionService.saveJob(j4);

        System.out.println(jobSubmissionService.getAllJobs());


        ExecutorNodesRepository nodesRepository = new ExecutorNodesRepository();

        // A Central coordinator between Scheduler Service and Executor Service
        Coordinator zookeeper = new Coordinator(nodesRepository);

        // coordinator can add nodes according to the traffic in live systems.
        zookeeper.addNode();
        zookeeper.addNode();
        zookeeper.addNode();

        /*
        Scheduler Service interacts with zookeeper to push jobs so that zookeeper can effectively distribute
         */
        SchedulerService schedulerService = new SchedulerService(jobRepository,zookeeper);

        // Scheduler service picks jobs for execution.
        schedulerService.pickJobs();

        //Executor service listens to the jobs pushed
        ExecutorService executorService = new ExecutorService(nodesRepository,jobRepository);

        //Executor service executes the jobs
        executorService.executeAllJobs();

        //Check status of the jobs.
        System.out.println(jobSubmissionService.getAllJobs());

    }
}
