package org.zsavery.jobs;

import java.util.LinkedList;

public class JobTable {
    private LinkedList<JobLine> jobRows;

    public JobTable() {
        jobRows = new LinkedList<>();

    }
    public void addJobLine(Job job, Status status) {
        jobRows.add(new JobLine(job, status));
    }

    public void addJobLine(Job job) {
        jobRows.add(new JobLine(job));
    }

    public void addJobLine(JobLine jobLine) {
        jobRows.add(jobLine);
    }

    public void addJobLine(String address, String company, double salary, String position) {
        jobRows.add(new JobLine(new Job(address, company, salary, position)));
    }

    public void addJobLine(String address, String company, double salary, String position, Status status) {
        jobRows.add(new JobLine(new Job(address, company, salary, position), status));
    }

    public void removeJobLine(Job job) {
        jobRows.removeIf(jobLine -> jobLine.getJob().equals(job));

    }

    public void removeJobLine(JobLine jobLine) {
        this.jobRows.remove(jobLine);

    }

    public void removeJobLine(String address, String company, double salary, String position) {
        Job jobQuery = new Job(address, company, salary, position);
        jobRows.removeIf(jobLine -> jobLine.getJob().equals(jobQuery));

    }

    public JobLine getJobLine(String address, String company, double salary, String position) {
        for (JobLine jobLine : jobRows) {
            if (jobLine.equals(new JobLine(new Job(address, company, salary, position)))) {
                return jobLine;
            }
        }
        return null;
    }

    public JobLine getJobLine(Job job) {
        for (JobLine jobLine : jobRows) {
            if (jobLine.equals(new JobLine(job))) {
                return jobLine;
            }
        }
        return null;
    }

    public JobLine getJobLine(int index){
        return jobRows.get(index);

    }

    public JobLine getJobLine(JobLine jobLine) {
        for (JobLine myJobLine : jobRows) {
            if (myJobLine.equals(jobLine)) {
                return jobLine;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (jobRows.isEmpty()) {
            return "JobTable=[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("JobTable=[\n");
        for (int i = 0; i < jobRows.size(); i++){
            result.append("\tjobLine=[").append(jobRows.get(i).toString());
            if (i != jobRows.size()-1) {
                result.append("],\n");
            }
        }
        result.append("]\n]");
        return result.toString();
    }
}
