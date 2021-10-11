package database_entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;
@Entity(name = "projects")
public class Projects {
    @Id
    @Column(name = "_id")
    private long ID;
    private String name ;
    private Date StartingDate;
    @ManyToOne
    @JoinColumn(name = "project_manager")
    private Employees PM ;

    @ManyToMany
    List<Employees> enrolledemployees ;

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

    public Employees getPM() {
        return PM;
    }

    public void setEnrolledemployees(List<Employees> enrolledemployees) {
        this.enrolledemployees = enrolledemployees;
    }

    public List<Employees> getEnrolledemployees() {
        return enrolledemployees;
    }

    public void setPM(Employees PM) {
        this.PM = PM;
    }

    public Date getStartingDate() {
        return StartingDate;
    }

    public void setStartingDate(Date startingDate) {
        StartingDate = startingDate;
    }
}
