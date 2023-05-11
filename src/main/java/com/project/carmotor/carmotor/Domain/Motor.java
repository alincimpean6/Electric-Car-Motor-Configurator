package com.project.carmotor.carmotor.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Motor {
    private @Id @GeneratedValue Long id;
    private String motorTechnology;
    private int motorPrice;
    private float motorPower;
    private float motorConsumption;
    private String motorCompatibity;
    private int returnedMotors;

    public Motor(String motorTechnology, int motorPrice, float motorPower, float motorConsumption, String motorCompatibity) {

        this.motorTechnology = motorTechnology;
        this.motorPrice = motorPrice;
        this.motorPower = motorPower;
        this.motorConsumption = motorConsumption;
        this.motorCompatibity = motorCompatibity;
        this.returnedMotors = 0;
    }

    public Motor(String motorTechnology, int motorPrice, float motorPower, float motorConsumption, String motorCompatibity, int returnedMotors) {

        this.motorTechnology = motorTechnology;
        this.motorPrice = motorPrice;
        this.motorPower = motorPower;
        this.motorConsumption = motorConsumption;
        this.motorCompatibity = motorCompatibity;
        this.returnedMotors = returnedMotors;
    }

    public Motor(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotorTechnology() {
        return motorTechnology;
    }

    public void setMotorTechnology(String motorTechnology) {
        this.motorTechnology = motorTechnology;
    }

    public int getMotorPrice() {
        return motorPrice;
    }

    public void setMotorPrice(int motorPrice) {
        this.motorPrice = motorPrice;
    }

    public float getMotorPower() {
        return motorPower;
    }

    public void setMotorPower(float motorPower) {
        this.motorPower = motorPower;
    }

    public float getMotorConsumption() {
        return motorConsumption;
    }

    public void setMotorConsumption(float motorConsumption) {
        this.motorConsumption = motorConsumption;
    }

    public String getMotorCompatibity() {
        return motorCompatibity;
    }

    public void setMotorCompatibity(String motorCompatibity) {
        this.motorCompatibity = motorCompatibity;
    }

    public int getReturnedMotors() {
        return returnedMotors;
    }

    public void setReturnedMotors(int returnedMotors) {
        this.returnedMotors = returnedMotors;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "id=" + id +
                ", motorTechnology='" + motorTechnology + '\'' +
                ", motorPrice=" + motorPrice +
                ", motorPower=" + motorPower +
                ", motorConsumption=" + motorConsumption +
                ", motorCompatibity='" + motorCompatibity + '\'' +
                ", returnedMotors=" + returnedMotors +
                '}';
    }
}
