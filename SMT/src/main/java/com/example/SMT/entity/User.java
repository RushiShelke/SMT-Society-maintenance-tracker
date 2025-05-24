package com.example.SMT.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")
public class User {

    @Id
    private String id;

    private String societyname;
    private String name;
    private String email;
    private String password;
    private String societyregno;
    private String phoneNumber;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pincode;
    private String country;
    private String noOfMembers;

    // Default constructor
    public User() {}

    // Parameterized constructor (password bhi add karna agar constructor use kar raha hai)
    public User(String societyname, String noOfMembers,String email,String name, String password, String societyregno, String phoneNumber, String addressLine1, String addressLine2, String city, String state, String pincode, String country) {
        this.societyname = societyname;
        this.name = name;
        this.email = email;
        this.password = password;
        this.societyregno = societyregno;
        this.phoneNumber = phoneNumber;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.pincode = pincode;
        this.state = state;
        this.country = country;
        this.noOfMembers = noOfMembers;
    }

    // Getters and Setters


    public String getNoOfMembers() {return noOfMembers;}
    public void setNoOfMembers(String noOfMembers) {this.noOfMembers = noOfMembers;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSocietyname() {
        return societyname;
    }

    public void setSocietyname(String societyname) {
        this.societyname = societyname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Password getter and setter
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSocietyregno() {return societyregno;}
    public void setSocietyregno(String societyregno) {this.societyregno=societyregno;}

    public String getPhoneNumber() {return phoneNumber;}
    public void setPhoneNumber(String phoneNumber) {this.phoneNumber = phoneNumber;}

    public String getAddressLine1() {return  addressLine1;}
    public void setAddressLine1(String addressLine1) {this.addressLine1 = addressLine1;}

    public String getAddressLine2() {return addressLine2;}
    public void setAddressLine2(String addressLine2) {this.addressLine2 = addressLine2;}

    public String getCity() {return city;}
    public void setCity(String city) {this.city = city;}

    public String getPincode() {return pincode;}
    public void setPincode(String pincode) {this.pincode = pincode;}

    public String getState() {return state;}
    public void setState(String state) {this.state = state;}

    public String getCountry() {return country;}
    public void setCountry(String country) {this.country = country;}
}
