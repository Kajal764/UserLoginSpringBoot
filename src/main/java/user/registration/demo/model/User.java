package user.registration.demo.model;

import user.registration.demo.dto.UserDto;
import user.registration.demo.dto.loginDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public int id;
    public String fname;
    public String emailId;
    public String password;
    public String mobileNo;

    public User(loginDto logindto) {
        this.emailId=logindto.emailId;
        this.password=logindto.password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public User() {
    }

    public User(UserDto userDto) {
        this.emailId=userDto.emailId;
        this.fname=userDto.fname;
        this.mobileNo=userDto.mobileNo;
        this.password=userDto.password;
    }


}
