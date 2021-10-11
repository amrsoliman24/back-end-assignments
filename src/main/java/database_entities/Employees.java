package database_entities;

import javax.persistence.*;
import java.util.List;

@Entity(name = "employees")
@Table
public class Employees {
    @Id
    @Column(name = "id")
    private long Id;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone ;
    @Column(name = "national_id")
    private String ssn ;

    @OneToMany(mappedBy = "PM")
    List<Projects> manaagedprojects ;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private role role ;

    @ManyToMany
    @JoinTable(
            name = "employees_projects",
            joinColumns = @JoinColumn(name = "employee_id"),
            inverseJoinColumns = @JoinColumn(name = "project_id")

    )
    List<Projects> enrolledprojects ;


public Employees(){};
    public  Employees( String name , String email , String Phone , String ssn , role role) {

        this.name = name;
        this.email = email;
        this.phone = Phone;
        this.ssn = ssn ;
        this.role = role ;
    }
    public long getId() {
        return Id;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getSsn() {
        return ssn;
    }



    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(long id) {
        Id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public database_entities.role getRole() {
        return role;
    }

    public void setRole(database_entities.role role) {
        this.role = role;
    }

    public List<Projects> getEnrolledprojects() {
        return enrolledprojects;
    }

    public void setEnrolledprojects(List<Projects> enrolledprojects) {
        this.enrolledprojects = enrolledprojects;
    }

    @Override
    public String toString() {
        return "employees{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone=" + phone +
                ", ssn=" + ssn +
                ", role='" + role + '\'' +
                '}';
    }

}
