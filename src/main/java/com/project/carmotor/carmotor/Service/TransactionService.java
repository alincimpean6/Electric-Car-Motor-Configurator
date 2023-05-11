package com.project.carmotor.carmotor.Service;

import com.project.carmotor.carmotor.Controller.CarController;
import com.project.carmotor.carmotor.Controller.ClientController;
import com.project.carmotor.carmotor.Controller.MotorController;
import com.project.carmotor.carmotor.Controller.TransactionController;
import com.project.carmotor.carmotor.Domain.*;
import com.project.carmotor.carmotor.Repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {

    private TransactionController transactionController;
    private TransactionValidator transactionValidator;
    private CarController carController;
    private MotorController motorController;
    private ClientController clientController;
    private ClientService clientService;

    public TransactionService(TransactionController transactionController, TransactionValidator transactionValidator, CarController carController, MotorController motorController, ClientController clientController, ClientService clientService){
        this.transactionController = transactionController;
        this.transactionValidator = transactionValidator;
        this.carController = carController;
        this.clientController = clientController;
        this.motorController = motorController;
        this.clientService = clientService;
    }

    public void add(Long motorId,Long clientId, Long carId, int motorPieces, String transactionDate) throws Exception {
        Transaction transaction = new Transaction(motorId,clientId, carId, motorPieces, transactionDate);
        this.transactionValidator.validate( transaction, carController, motorController, clientController);
        this.transactionController.newTransaction(transaction);
        calculateTransaction(transaction);
    }

    public void add(Long motorId,Long clientId, Long carId, int motorPieces, String transactionDate, float totalSum) throws Exception {
        Transaction transaction = new Transaction( motorId, clientId, carId, motorPieces, transactionDate, totalSum);
        this.transactionValidator.validate( transaction, carController, motorController, clientController);
        this.transactionController.newTransaction(transaction);
    }

    public void update(Long id,Long motorId,Long clientId, Long carId, int motorPieces, String transactionDate) throws Exception {
        Transaction transaction = new Transaction(motorId,clientId, carId, motorPieces, transactionDate);
        this.transactionController.replaceTransaction(transaction,id);
        calculateTransaction(transaction);
    }

    public void update(Long id,Long motorId,Long clientId, Long carId, int motorPieces, String transactionDate, float totalSum) throws Exception {
        Transaction transaction = new Transaction( motorId, clientId, carId, motorPieces, transactionDate, totalSum);
        this.transactionController.replaceTransaction(transaction,id);
    }

    public void calculateTransaction(Transaction transaction) throws Exception {
        //Transaction
        int pieces = transaction.getMotorPieces();
        float motorPrice = motorController.one(transaction.getMotorId()).getMotorPrice();
        float total = motorPrice * pieces;
        float totalSumBefore = transaction.getTotalSum();
        update(transaction.getId(),transaction.getMotorId(),transaction.getClientId(),transaction.getCarId(),transaction.getMotorPieces(),transaction.getTransactionDate(),totalSumBefore + total);
        //Client
        int totalMotorsBoughtBefore = clientController.one(transaction.getClientId()).getTotalSumOfMotors();
        int totalMotorsBoughtUpdate = totalMotorsBoughtBefore+ transaction.getMotorPieces();
        int totalSumOfMotorsBefore = clientController.one(transaction.getClientId()).getTotalSumOfMotors();
        int totalSumOfMotorsUpdate = (int) (totalSumOfMotorsBefore+total);

        Client client = clientController.one(transaction.getClientId());
        clientService.update(transaction.getClientId(),client.getCompanyName(),client.getCarName(),client.getRegDate(),totalMotorsBoughtUpdate,totalSumOfMotorsUpdate);
    }

    public void delete(Long id) throws Exception {
        this.transactionController.deleteTransaction(id);
    }

    public List<Transaction> getAll() {
        return this.transactionController.all();
    }
}



