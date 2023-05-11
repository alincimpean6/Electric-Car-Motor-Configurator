package com.project.carmotor.carmotor.Service;

import com.project.carmotor.carmotor.Controller.CarController;
import com.project.carmotor.carmotor.Controller.ClientController;
import com.project.carmotor.carmotor.Domain.Car;
import com.project.carmotor.carmotor.Domain.CarValidator;
import com.project.carmotor.carmotor.Domain.Client;
import com.project.carmotor.carmotor.Repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private CarController carController;
    private ClientController clientController;
    private CarValidator carValidator;

    public CarService(CarController carController, ClientController clientController, CarValidator carValidator) {
        this.carController = carController;
        this.clientController = clientController;
        this.carValidator = carValidator;
    }

    public void add(String carName, float powerNeeded) throws Exception {
        Car auto = new Car(carName, powerNeeded);
        this.carValidator.validate(auto,carController,clientController);
        this.carController.newCar(auto);
    }

    public void update(Long id, String carName, float powerNeeded) throws Exception {
        Car auto = new Car(carName, powerNeeded);
        this.carController.replaceCar(auto,id);
    }

    public void delete(Long carID) throws Exception {
        this.carController.deleteCar(carID);
    }

    public List<Car> getAll() {
        return this.carController.all();
    }
}



