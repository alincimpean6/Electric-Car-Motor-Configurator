package com.project.carmotor.carmotor.Service;

import com.project.carmotor.carmotor.Controller.ClientController;
import com.project.carmotor.carmotor.Domain.Client;
import com.project.carmotor.carmotor.Domain.ClientValidator;
import com.project.carmotor.carmotor.Repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private ClientController clientController;
    private ClientValidator clientValidator;

    public ClientService(ClientController clientController, ClientValidator clientValidator) {
        this.clientController = clientController;
        this.clientValidator = clientValidator;
    }

    public void add(String companyName,String carName, String regDate) throws Exception {
        Client client = new Client(companyName,carName,regDate);
        this.clientValidator.validate(client,clientController);
        this.clientController.newClient(client);
    }

    public void add(String companyName,String carName, String regDate, int totalMotorsBought, int totalSumOfMotors) throws Exception {
        Client client = new Client(companyName,carName, regDate, totalMotorsBought, totalSumOfMotors);
        this.clientValidator.validate(client,clientController);
        this.clientController.newClient(client);
    }

    public void update(Long id,String companyName,String carName, String regDate) throws Exception {
        Client client = new Client(companyName,carName, regDate);
        this.clientController.replaceClient(client,id);
    }

    public void update(Long id,String companyName,String carName, String regDate, int totalMotorsBought, int totalSumOfMotors) throws Exception {
        Client client = new Client(companyName,carName, regDate, totalMotorsBought, totalSumOfMotors);
        this.clientController.replaceClient(client,id);
    }

    public void delete(Long carID) throws Exception {
        this.clientController.deleteClient(carID);
    }

    public List<Client> getAll() {
        return this.clientController.all();
    }
}



