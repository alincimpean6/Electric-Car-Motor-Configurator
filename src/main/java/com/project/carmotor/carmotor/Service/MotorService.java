package com.project.carmotor.carmotor.Service;

import com.project.carmotor.carmotor.Controller.ClientController;
import com.project.carmotor.carmotor.Controller.MotorController;
import com.project.carmotor.carmotor.Domain.*;
import com.project.carmotor.carmotor.Repository.ClientRepository;
import com.project.carmotor.carmotor.Repository.MotorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MotorService {

    private MotorController motorController;
    private MotorValidator motorValidator;

    public MotorService(MotorController motorController, MotorValidator motorValidator) {
        this.motorController = motorController;
        this.motorValidator = motorValidator;
    }


    public void add(String motorTechnology, int motorPrice, float motorPower, float motorConsumption, String motorCompatibity) throws Exception {
        Motor motor = new Motor(motorTechnology, motorPrice, motorPower, motorConsumption, motorCompatibity);
        this.motorValidator.validate(motor);
        this.motorController.newMotor(motor);
    }

    public void add(String motorTechnology, int motorPrice, float motorPower, float motorConsumption, String motorCompatibity, int returnedMotors)throws Exception {
        Motor motor = new Motor(motorTechnology, motorPrice, motorPower, motorConsumption, motorCompatibity, returnedMotors);
        this.motorValidator.validate(motor);
        this.motorController.newMotor(motor);
    }

    public void update(Long id,String motorTechnology, int motorPrice, float motorPower, float motorConsumption, String motorCompatibity) throws Exception {
        Motor motor = new Motor(motorTechnology, motorPrice, motorPower, motorConsumption, motorCompatibity);
        this.motorController.replaceMotor(motor,id);
    }

    public void update(Long id,String motorTechnology, int motorPrice, float motorPower, float motorConsumption, String motorCompatibity, int returnedMotors)throws Exception {
        Motor motor = new Motor(motorTechnology, motorPrice, motorPower, motorConsumption, motorCompatibity, returnedMotors);
        this.motorController.replaceMotor(motor,id);
    }

    public void updateReturn(Long id,int returnedMotorsUser) throws Exception {
        int returnedMotors = motorController.one(id).getReturnedMotors();
        int setReturnedMotors = returnedMotorsUser + returnedMotors;
        update(id,motorController.one(id).getMotorTechnology(),motorController.one(id).getMotorPrice(),motorController.one(id).getMotorPower(),motorController.one(id).getMotorConsumption(),motorController.one(id).getMotorCompatibity(),setReturnedMotors);
    }

    public void delete(Long id) throws Exception {
        this.motorController.deleteMotor(id);
    }

    public List<Motor> getAll() {
        return this.motorController.all();
    }
}



