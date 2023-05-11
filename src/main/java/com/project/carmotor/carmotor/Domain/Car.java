package com.project.carmotor.carmotor.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Car {
    private @Id @GeneratedValue Long id;
    private String carName;
    private float powerNeeded;

    public Car(String carName, float powerNeeded) {
        this.carName = carName;
        this.powerNeeded = powerNeeded;
    }

    public Car(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public float getPowerNeeded() {
        return powerNeeded;
    }

    public void setPowerNeeded(float powerNeeded) {
        this.powerNeeded = powerNeeded;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", carName='" + carName + '\'' +
                ", powerNeeded=" + powerNeeded +
                '}';
    }
}
