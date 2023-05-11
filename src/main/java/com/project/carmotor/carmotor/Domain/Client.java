package com.project.carmotor.carmotor.Domain;

import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Client {
    private @Id @GeneratedValue Long id;
    private String companyName;
    private String carName;
    private String regDate;
    private int totalMotorsBought;
    private int totalSumOfMotors;

    public Client(String companyName,String carName, String regDate) {
        this.companyName = companyName;
        this.carName = carName;
        this.regDate = regDate;
        this.totalMotorsBought = 0;
        this.totalSumOfMotors = 0;
    }

    public Client(String companyName,String carName, String regDate, int totalMotorsBought, int totalSumOfMotors) {
        this.companyName = companyName;
        this.carName = carName;
        this.regDate = regDate;
        this.totalMotorsBought = totalMotorsBought;
        this.totalSumOfMotors = totalSumOfMotors;
    }

    public Client(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getTotalMotorsBought() {
        return totalMotorsBought;
    }

    public void setTotalMotorsBought(int totalMotorsBought) {
        this.totalMotorsBought = totalMotorsBought;
    }

    public int getTotalSumOfMotors() {
        return totalSumOfMotors;
    }

    public void setTotalSumOfMotors(int totalSumOfMotors) {
        this.totalSumOfMotors = totalSumOfMotors;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", carName='" + carName + '\'' +
                ", regDate=" + regDate +
                ", totalMotorsBought=" + totalMotorsBought +
                ", totalSumOfMotors=" + totalSumOfMotors +
                '}';
    }
}
