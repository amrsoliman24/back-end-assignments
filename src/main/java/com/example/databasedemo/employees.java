package com.example.databasedemo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity(name = "employees")
public class employees {
    @Id
    @Column (name = "id")
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
    List<projects> manaagedprojects ;

    @ManyToOne
    @JoinColumn(name = "role_id")
     private role role ;

    @ManyToMany
    @JoinTable(
            name = "employees_projects",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employee_id")

    )
    List<projects> enrolledprojects ;



   public  employees( String name , String email , String Phone , String ssn , role role) {

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
