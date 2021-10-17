package entities;

import entities.Employees;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Entity(name = "projects")
public class Projects {
    @Id
    @Column(name = "_id")
    private long ID;
    @Column(name = "name")
    private String name ;
    @Column(name = "start_date")
    private Date StartingDate;
    @ManyToOne
    @JoinColumn(name = "project_manager")
    private Employees PM ;

    @ManyToMany(mappedBy = "enrolledprojects")
     private List<Employees> enrolledemployees ;

    public Projects() {
    }

    public Projects(String name, Date startingDate, Employees PM) {
        this.name = name;
        StartingDate = startingDate;
        this.PM = PM;
        this.enrolledemployees = new ArrayList<Employees>();
    }

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

    public void setPM(Employees PM) {
        this.PM = PM;
    }

    public Date getStartingDate() {
        return StartingDate;
    }

    public void setStartingDate(Date startingDate) {
        StartingDate = startingDate;
    }

    public List<Employees> getEnrolledemployees() {
        return enrolledemployees;
    }

    public void setEnrolledemployees(List<Employees> enrolledemployees) {
        this.enrolledemployees = enrolledemployees;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "ID=" + ID +
                ", name='" + name + '\'' +
                ", StartingDate=" + StartingDate +
                ", PM=" + PM +
                ", enrolledemployees=" + enrolledemployees +
                '}';
    }
}
