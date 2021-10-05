package xom.test;
import sun.util.calendar.LocalGregorianCalendar;

import javax.validation.constraints.*;

import java.util.Date;

public class Appointement {
 @Size(min = 10 , max = 100 , message = "patient name must be between 10 and 100 characters")
 private String patient_name;
 @Positive(message = "Age should be possitive number")
 @Max(value = 150, message = "Age should not be greater than 150")
 private int Patient_age ;
 @Pattern(regexp = "\\d+\\s+[a-zA-Z]+" , message = "address should  be in the form of building number followed by street name")
 private String patient_address;
 @Email(message = "Email should be valid")
 private String Patient_email;
 @Size(min = 10 , max = 100 , message = "Doctor name must be between 10 and 100 characters")
 private String Doctor_name;
 @FutureOrPresent(message = "date must be in the future")
 private Date Appointement_date;


 public Appointement(String patient_name , int patient_age , String patient_address , String patient_email , String Doctor_name , Date Appointement_date ){
 this.Appointement_date = Appointement_date;
 this.Doctor_name =Doctor_name;
 this.patient_address = patient_address;
 this.patient_name = patient_name;
 this.Patient_age = patient_age;
 this.Patient_email = patient_email;
 }


 public Date getAppointement_date() {
  return Appointement_date;
 }


 public int getPatient_age() {
  return Patient_age;
 }

 public String getDoctor_name() {
  return Doctor_name;
 }

 public String getPatient_address() {
  return patient_address;
 }

 public String getPatient_email() {
  return Patient_email;
 }

 public String getPatient_name() {
  return patient_name;
 }

 public void setPatient_age(int patient_age) {
  Patient_age = patient_age;
 }

 public void setAppointement_date(Date appointement_date) {
  Appointement_date = appointement_date;
 }

 public void setDoctor_name(String doctor_name) {
  Doctor_name = doctor_name;
 }

 public void setPatient_address(String patient_address) {
  this.patient_address = patient_address;
 }

 public void setPatient_email(String patient_email) {
  Patient_email = patient_email;
 }

 public void setPatient_name(String patient_name) {
  this.patient_name = patient_name;
 }
}
