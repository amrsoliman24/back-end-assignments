package com.example.databasedemo;

import javax.persistence.*;
import java.util.List;

@Entity(name = "projects")
public class projects {

    @Id
    private long ID;
    private String name ;
    @ManyToOne
    @JoinColumn(name = "project_manager")
    private employees PM ;

    @ManyToMany
    @JoinTable(
            name = "employees_projects",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")

    )
    List<employees> enrolledemployees ;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public employees getPM() {
        return PM;
    }

    public void setEnrolledemployees(List<employees> enrolledemployees) {
        this.enrolledemployees = enrolledemployees;
    }

    public List<employees> getEnrolledemployees() {
        return enrolledemployees;
    }

    public void setPM(employees PM) {
        this.PM = PM;
    }
}
