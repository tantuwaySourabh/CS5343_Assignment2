import java.util.PriorityQueue;

class q2 {
    private static PriorityQueue<PQScheduler> pQueue = new PriorityQueue<>();
    private static PQScheduler currentJob = null;

    public static void addJob(PQScheduler job) {
        pQueue.add(job);
    }

    public static void startCPU() {
        while(!pQueue.isEmpty()) {
            currentJob = pQueue.poll();
            System.out.println("add "+currentJob.getJobName() + " with length "+ currentJob.getJobTimeSlice()+" and priority "+ currentJob.getJobPriority());

            for(int i=1; i < currentJob.getJobTimeSlice();i++) {
                System.out.println("no new job this slice");
            }
        }
    }

    public static void main(String[] args) throws Exception {
        
        PQScheduler job1 = new PQScheduler(0, 3, "job1");
        PQScheduler job2 = new PQScheduler(-3, 2, "job2");
        PQScheduler job3 = new PQScheduler(3, 1, "job3");

        addJob(job1);
        addJob(job2);
        addJob(job3);

        startCPU();

    }
}

class PQScheduler implements Comparable<PQScheduler> {

    public PQScheduler(int jPriority, int jTimeSlice, String jName) throws Exception {
        if(jPriority >= -20 && jPriority <= 19) this.jobPriority = jPriority;
        else throw new Exception("Priority: out of range: "+jPriority);
        
        if(jTimeSlice <= 100 && jTimeSlice >= 1){
            this.jobTimeSlice = jTimeSlice;
        }
        else {
            throw new Exception("TimeSlice: out of range: "+jTimeSlice);
        } 

        this.jobName = jName;
    }

    private int jobPriority;
    private int jobTimeSlice;
    private String jobName;
    

    public int getJobPriority() {
        return jobPriority;
    }


    public void setJobPriority(int jobPriority) throws Exception {
        if(jobPriority >= -20 && jobPriority <= 19) this.jobPriority = jobPriority;
        else throw new Exception("Priority: out of range: "+jobPriority);
    }


    public int getJobTimeSlice() {
        return jobTimeSlice;
    }


    public void setJobTimeSlice(int jobTimeSlice) throws Exception {
        if(jobTimeSlice <= 100 && jobTimeSlice >= 1) this.jobTimeSlice = jobTimeSlice;
        else throw new Exception("TimeSlice: out of range: "+jobTimeSlice);
    }


    public String getJobName() {
        return jobName;
    }


    public void setJobName(String jobName) {
        this.jobName = jobName;
    }


    @Override
    public int compareTo(PQScheduler job) {
        return this.jobPriority + job.jobPriority;
    }

}