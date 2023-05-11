package com.project.carmotor.carmotor.Controller;

import com.project.carmotor.carmotor.Domain.Client;
import com.project.carmotor.carmotor.Domain.Motor;
import com.project.carmotor.carmotor.Repository.ClientRepository;
import com.project.carmotor.carmotor.Repository.MotorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@AutoConfiguration
@RestController
public class MotorController {

    @Autowired
    private final MotorRepository repository;

    MotorController(MotorRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/motors")
    public List<Motor> all() {
        return repository.findAll();
    }

    @PostMapping("/motors")
    public Motor newMotor(@RequestBody Motor newMotor) {
        return repository.save(newMotor);
    }

    @PutMapping("/motors/{id}")
    public Motor replaceMotor(@RequestBody Motor newMotor, @PathVariable Long id) {

        return repository.findById(id)
                .map(motor -> {

                    motor.setMotorConsumption(newMotor.getMotorConsumption());
                    motor.setMotorPower(newMotor.getMotorPower());
                    motor.setMotorPrice(newMotor.getMotorPrice());
                    motor.setReturnedMotors(newMotor.getReturnedMotors());
                    motor.setMotorTechnology(newMotor.getMotorTechnology());
                    motor.setMotorCompatibity(newMotor.getMotorCompatibity());
                    return repository.save(motor);
                })
                .orElseGet(() -> {
                    newMotor.setId(id);
                    return repository.save(newMotor);
                });
    }

    @GetMapping("/motors/{id}")
    public Motor one(@PathVariable Long id) {
        Motor motor = repository.findById(id)
                .orElse(null);
        return motor;
    }

    @DeleteMapping("/motors/{id}")
    public void deleteMotor(@PathVariable Long id) {
        repository.deleteById(id);
    }
}