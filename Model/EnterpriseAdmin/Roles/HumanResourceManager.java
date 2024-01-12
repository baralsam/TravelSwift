/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model.EnterpriseAdmin.Roles;

import Model.Job.Job;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class HumanResourceManager extends Profile {
    private String name;
    List<Job> jobPostings;

    public HumanResourceManager(String username, String password, String name) {
        super(username, password);
        this.name = name;
        jobPostings = new ArrayList<>();
    }
    
    @Override
    public String getRole(){
        return  "Human Resource";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Job> getJobPostings() {
        return jobPostings;
    }

    public void setJobPostings(List<Job> jobPostings) {
        this.jobPostings = jobPostings;
    }
    
    
}
