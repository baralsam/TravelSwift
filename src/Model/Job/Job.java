/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.Job;

import Model.Roles.Customer;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class Job {
    String jobName;
    String jobDescription;
    String jobType;
    String organizationName;
    private Map<Customer, String> applicants;

    public Job( String jobName, String jobDescription, String jobType, String organizationName) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.jobType = jobType;
        this.organizationName = organizationName;
        this.applicants = new HashMap<>();
    }

    

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getOrganizationName() {
        return organizationName;
    }

    public void setOrganizationName(String organizationName) {
        this.organizationName = organizationName;
    }

    public Map<Customer, String> getApplicants() {
        return applicants;
    }

    public void setApplicants(Map<Customer, String> applicants) {
        this.applicants = applicants;
    }
    
    public void addApplicant(Customer c) {
        this.applicants.put(c, "Pending");
    }
    
    public void acceptCus(Customer c) {
        if (applicants.containsKey(c)) {
            applicants.put(c, "Accepted");
            c.getAppliedJobs().put(this, "Accepted");
        }
    }
    
    public void rejectCus(Customer c) {
        if (applicants.containsKey(c)) {
            applicants.put(c, "Rejected");
            c.getAppliedJobs().put(this, "Rejected");
        }
    }
    
    @Override 
    public String toString(){
        return this.jobName;
    }
    
}
