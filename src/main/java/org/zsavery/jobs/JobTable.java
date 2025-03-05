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

    @Override
    public String toString() {
        if (jobRows.isEmpty()) {
            return "JobTable=[]";
        }
        StringBuilder result = new StringBuilder();
        result.append("JobTable=[\n");
        for (int i = 0; i < jobRows.size(); i++){
            result.append("\t[").append(jobRows.get(i).toString());
            if (i != jobRows.size()) {
                result.append("],\n");
            }
        }
        result.append("]\n]");
        return result.toString();
    }
}
