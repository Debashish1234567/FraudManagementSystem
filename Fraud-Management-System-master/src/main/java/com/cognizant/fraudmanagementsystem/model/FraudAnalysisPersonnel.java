package com.cognizant.fraudmanagementsystem.model;

import java.util.Date;

public class FraudAnalysisPersonnel {
    
    private String id;
    private String firstName;
    private String lastName;
    private Date dob;
    private String gender;
    private String contactNo;
    private String email;
    private String password;
    private int isAuthorized = 1;
    private String firstAnswer;
    private String secondAnswer;
    private String thirdAnswer;

    public FraudAnalysisPersonnel() { }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIsAuthorized() {
        return isAuthorized;
    }

    public void setIsAuthorized(int isAuthorized) {
        this.isAuthorized = isAuthorized;
    }

    public String getFirstAnswer() {
        return firstAnswer;
    }

    public void setFirstAnswer(String firstAnswer) {
        this.firstAnswer = firstAnswer;
    }

    public String getSecondAnswer() {
        return secondAnswer;
    }

    public void setSecondAnswer(String secondAnswer) {
        this.secondAnswer = secondAnswer;
    }

    public String getThirdAnswer() {
        return thirdAnswer;
    }

    public void setThirdAnswer(String thirdAnswer) {
        this.thirdAnswer = thirdAnswer;
    }

    @Override
    public String toString() {
        return "FraudAnalysisPersonnel [contactNo=" + contactNo + ", dob=" + dob + ", email=" + email + ", firstAnswer="
                + firstAnswer + ", firstName=" + firstName + ", gender=" + gender + ", id=" + id + ", isAuthorized="
                + isAuthorized + ", lastName=" + lastName + ", password=" + password + ", secondAnswer=" + secondAnswer
                + ", thirdAnswer=" + thirdAnswer + "]";
    }

    
}
