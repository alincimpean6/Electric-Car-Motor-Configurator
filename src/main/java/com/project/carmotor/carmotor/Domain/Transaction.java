package com.project.carmotor.carmotor.Domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
public class Transaction {
    private @Id @GeneratedValue Long id;
    private Long motorId;
    private Long clientId;
    private Long carId;
    private int motorPieces;
    private String transactionDate;
    private float totalSum;

    public Transaction(Long motorId,Long clientId, Long carId, int motorPieces, String transactionDate) {
        this.motorId = motorId;
        this.clientId = clientId;
        this.carId = carId;
        this.motorPieces = motorPieces;
        this.transactionDate = transactionDate;
        this.totalSum = 0;
    }

    public Transaction(Long motorId,Long clientId, Long carId, int motorPieces, String transactionDate, float totalSum) {
        this.motorId = motorId;
        this.clientId = clientId;
        this.carId = carId;
        this.motorPieces = motorPieces;
        this.transactionDate = transactionDate;
        this.totalSum = totalSum;
    }

    public Transaction (){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMotorId() {
        return motorId;
    }

    public void setMotorId(Long motorId) {
        this.motorId = motorId;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public int getMotorPieces() {
        return motorPieces;
    }

    public void setMotorPieces(int motorPieces) {
        this.motorPieces = motorPieces;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public float getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(float totalSum) {
        this.totalSum = totalSum;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "motorId=" + motorId +
                ", clientId=" + clientId +
                ", carId=" + carId +
                ", motorPieces=" + motorPieces +
                ", transactionDate=" + transactionDate +
                ", totalSum=" + totalSum +
                '}';
    }
}
