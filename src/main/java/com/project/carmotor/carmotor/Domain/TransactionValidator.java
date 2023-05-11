package com.project.carmotor.carmotor.Domain;

import com.project.carmotor.carmotor.Controller.CarController;
import com.project.carmotor.carmotor.Controller.ClientController;
import com.project.carmotor.carmotor.Controller.MotorController;
import com.project.carmotor.carmotor.Repository.CarRepository;
import com.project.carmotor.carmotor.Repository.ClientRepository;
import com.project.carmotor.carmotor.Repository.MotorRepository;
import org.springframework.stereotype.Component;

@Component
public class TransactionValidator {
    public void validate(Transaction transaction, CarController carController, MotorController motorController, ClientController clientController) throws TransactionValidatorException {

        StringBuilder sb = new StringBuilder();

        if (motorController.one(transaction.getMotorId()) == null) {
            sb.append("The motor with the id: " + transaction.getMotorId() + " does not exist!\n");
        }

        if (clientController.one(transaction.getClientId()) == null) {
            sb.append("The client with the id: " + transaction.getClientId() + " does not exist!");
        }

        if (carController.one(transaction.getCarId()) == null) {
            sb.append("The car with the id: " + transaction.getCarId() + " does not exist!");
        }


        if(motorController.one(transaction.getMotorId()).getMotorCompatibity() != carController.one(transaction.getCarId()).getCarName()){
            sb.append("The motor is not compatible with the Car.");
        }

        if(carController.one(transaction.getCarId()).getPowerNeeded() > motorController.one(transaction.getMotorId()).getMotorPower()){
            sb.append("The motor with the power you have entered is not enough for the car.");
        }

        if (sb.length() > 0) {
            throw new TransactionValidatorException(sb.toString());
        }
    }
}
