package com.project.carmotor.carmotor.Domain;
import com.project.carmotor.carmotor.Controller.CarController;
import com.project.carmotor.carmotor.Controller.ClientController;
import com.project.carmotor.carmotor.Repository.CarRepository;
import org.springframework.stereotype.Component;

@Component
public class CarValidator {
    private CarController carController;
    private ClientController clientController;

    public void validate(Car car, CarController carController, ClientController clientController) throws CarValidatorException {
        this.carController = carController;
        StringBuilder sb = new StringBuilder();

        boolean carFound = false;

        String carName = car.getCarName();
        for(Client cl: clientController.all())
        {
            if(cl.getCarName().compareTo(carName) == 0) {
                carFound = true;
                break;
            }
        }

        if (carFound == false) {
            sb.append("There is not any client with that car name\n");
        }

        if (car.getPowerNeeded() < 0) {
            sb.append("The power needed can not be negative!\n");
        }

        if (sb.length() > 0) {
            throw new CarValidatorException(sb.toString());
        }
    }
}