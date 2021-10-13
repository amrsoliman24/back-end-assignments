package Dtos;

import entities.Employees;

public class Empserlaizer {
    private  String name ;
    private String email ;
    private String phone ;
    private String ssn ;
    private int age ;
    private String rolename  ;

    public Empserlaizer(){};
    public Empserlaizer(Employees Employee){
        this.name = Employee.getName();
        this.email = Employee.getEmail();
        this.phone = Employee.getPhone();
        this.ssn   = Employee.getSsn();
        this.age = Employee.getAge();
        this.rolename = Employee.getRole().getName();
    };
    public int getAge() {
        return age;
    }

    public String getRole() {
        return rolename;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getSsn() {
        return ssn;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setRole(String role) {
        this.rolename = role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
