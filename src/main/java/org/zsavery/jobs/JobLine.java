package org.zsavery.jobs;

import java.time.LocalDate;
import java.util.Objects;

public class JobLine implements hasStatus{
    private Job job;
    private Status status;
    private LocalDate updated;

    public JobLine(Job job) {
        super();
        this.job = job;
        this.status = Status.INTERESTED;
        updateListing();
    }

    public JobLine(Job job, Status status) {
        super();
        this.job = job;
        this.status = status;
        updateListing();
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
        updateListing();
    }

    public void updateListing() {
        this.updated = LocalDate.now();
    }

    public LocalDate lastUpdate() {
        return this.updated;
    }

    public void setAddress(String address) {
        this.job.setAddress(address);
        updateListing();
    }

    public void setCompany(String company) {
        this.job.setCompany(company);
        updateListing();
    }

    public void setPosition(String position) {
        this.job.setPosition(position);
        updateListing();
    }

    public void setSalary(double salary) {
        this.job.setSalary(0);
        updateListing();
    }

    @Override
    public void setStatus(Status status) {
        this.status = status;
        updateListing();

    }

    @Override
    public Status getStatus() {

        return this.status;
    }

    @Override
    public String toString() {
        return "JobListing [job=" + job + ", status=" + status + ", updated=" + updated + "]";
    }

    @Override
    public int hashCode() {
        return Objects.hash(job);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        JobLine other = (JobLine) obj;
        return Objects.equals(job, other.job);
    }

}
