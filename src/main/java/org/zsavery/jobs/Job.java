package org.zsavery.jobs;

import java.util.Objects;

public class Job {
    private String address;
    private String company;
    private double salary;
    private String position;

    public Job(String address, String company, double salary, String position) {
        super();
        this.address = address;
        this.company = company;
        this.salary = salary;
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address, company, position, salary);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Job other = (Job) obj;
        return Objects.equals(address, other.address) && Objects.equals(company, other.company)
                && Objects.equals(position, other.position)
                && Double.doubleToLongBits(salary) == Double.doubleToLongBits(other.salary);
    }

    @Override
    public String toString() {
        return "Job [address=" + address + ", company=" + company + ", salary=" + salary + ", position=" + position
                + "]";
    }

}
