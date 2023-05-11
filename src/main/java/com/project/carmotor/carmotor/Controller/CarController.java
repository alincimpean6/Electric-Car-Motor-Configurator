package com.project.carmotor.carmotor.Controller;

import com.project.carmotor.carmotor.Domain.Car;
import com.project.carmotor.carmotor.Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@AutoConfiguration
@RestController
public class CarController {

    @Autowired
    private final CarRepository repository;

    public CarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cars")
    public List<Car> all() {
        return repository.findAll();
    }

    @PostMapping("/cars")
    public Car newCar(@RequestBody Car newCar) {
        return repository.save(newCar);
    }

    @GetMapping("/cars/{id}")
    public Car one(@PathVariable Long id) {
        Car car = repository.findById(id)
                .orElse(null);
        return car;
    }

    @PutMapping("/cars/{id}")
    public Car replaceCar(@RequestBody Car newCar, @PathVariable Long id) {

        return repository.findById(id)
                .map(car -> {
                    car.setCarName(newCar.getCarName());
                    car.setPowerNeeded(newCar.getPowerNeeded());
                    return repository.save(car);
                })
                .orElseGet(() -> {
                    newCar.setId(id);
                    return repository.save(newCar);
                });
    }

    @DeleteMapping("/cars/{id}")
    public void deleteCar(@PathVariable Long id) {
        repository.deleteById(id);
    }
}