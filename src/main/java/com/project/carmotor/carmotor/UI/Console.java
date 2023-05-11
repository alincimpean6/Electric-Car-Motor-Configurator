package com.project.carmotor.carmotor.UI;


import com.project.carmotor.carmotor.Domain.*;
import com.project.carmotor.carmotor.Service.CarService;
import com.project.carmotor.carmotor.Service.ClientService;
import com.project.carmotor.carmotor.Service.MotorService;
import com.project.carmotor.carmotor.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

@Component
public class Console {
    private final CarService carService;
    private final ClientService clientService;
    private final MotorService motorService;
    private final TransactionService transactionService;
    private Scanner scanner;

    @Autowired
    public Console(CarService carService, ClientService clientService, MotorService motorService, TransactionService transactionService) {
        this.carService = carService;
        this.clientService = clientService;
        this.motorService = motorService;
        this.transactionService = transactionService;
        this.scanner = new Scanner(System.in);
    }

    private void showMenu() {
        System.out.println("1. Car menu");
        System.out.println("2. Client menu");
        System.out.println("3. Motor menu");
        System.out.println("4. Transaction menu");
    }

    private void showCarMenu() {
        System.out.println("1. Add a car");
        System.out.println("2. Update a car");
        System.out.println("3. Delete a car");
        System.out.println("4. Show all cars");
        System.out.println("0. Back");
        runShowCarMenu();
    }

    private void showClientMenu() {
        System.out.println("1. Add a client");
        System.out.println("2. Update a client");
        System.out.println("3. Delete a client");
        System.out.println("4. Show all clients");
        System.out.println("0. Back");
        runShowClientMenu();
    }

    private void showMotorMenu() {
        System.out.println("1. Add a motor");
        System.out.println("2. Update a motor");
        System.out.println("3. Delete a motor");
        System.out.println("4. Show all motors");
        System.out.println("5. Return a motor");
        System.out.println("0. Back");
        runShowMotorMenu();
    }

    private void showTransactionMenu() {
        System.out.println("1. Add a transaction");
        System.out.println("2. Update a tranaction");
        System.out.println("3. Delete a transaction");
        System.out.println("4. Show all transactions");
        System.out.println("0. Back");
        runShowTransactionMenu();
    }

    public void runConsole() {
        while (true) {
            this.showMenu();
            int option = this.scanner.nextInt();
            switch (option) {
                case 1:
                    this.showCarMenu();
                    break;
                case 2:
                    this.showClientMenu();
                    break;
                case 3:
                    this.showMotorMenu();
                    break;
                case 4:
                    this.showTransactionMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Unsupported command.");
            }
        }
    }

    public void runShowCarMenu() {
        while (true) {
            int option = this.scanner.nextInt();
            switch (option) {
                case 1:
                    handleAddCar();
                    showCarMenu();
                    break;
                case 2:
                    handleUpdateCar();
                    showCarMenu();
                    break;
                case 3:
                    handleDeleteCar();
                    showCarMenu();
                    break;
                case 4:
                    handleShowCars();
                    showCarMenu();
                    break;
                case 0:
                    this.runConsole();
                    break;
                default:
                    System.out.println("Unsupported command.");
            }
        }
    }

    private void handleAddCar() {
        try {
            System.out.print("Enter the car brand Name: ");
            String carName = this.scanner.next();
            System.out.print("Enter the power needed for the motor (kW): ");
            float powerNeeded = this.scanner.nextFloat();
            this.carService.add(carName,powerNeeded);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (CarValidatorException var10) {
            System.out.println(var10.getMessage());
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleUpdateCar() {
        try {
            System.out.print("Enter the ID you want to edit: ");
            Long id = scanner.nextLong();
            System.out.print("Enter the car brand Name: ");
            String carName = this.scanner.next();
            System.out.print("Enter the power needed for the motor (kW): ");
            float powerNeeded = this.scanner.nextFloat();
            this.carService.update(id,carName,powerNeeded);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (CarValidatorException var10) {
            System.out.println(var10.getMessage());
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleDeleteCar() {
        try {
            System.out.print("Enter the ID you want to delete: ");
            Long id = scanner.nextLong();
            this.carService.delete(id);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (CarValidatorException var10) {
            System.out.println(var10.getMessage());
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleShowCars() {
        Iterator var1 = this.carService.getAll().iterator();

        while(var1.hasNext()) {
            Car c = (Car)var1.next();
            System.out.println(c);
        }
    }

    public void runShowMotorMenu() {
        while (true) {
            int option = this.scanner.nextInt();
            switch (option) {
                case 1:
                    handleAddMotor();
                    showMotorMenu();
                    break;
                case 2:
                    handleUpdateMotor();
                    showMotorMenu();
                    break;
                case 3:
                    handleDeleteMotor();
                    showMotorMenu();
                    break;
                case 4:
                    handleShowMotors();
                    showMotorMenu();
                    break;
                case 5:
                    handleReturnMotor();
                    showMotorMenu();
                    break;
                case 0:
                    this.runConsole();
                    break;
                default:
                    System.out.println("Unsupported command.");
            }
        }
    }

    private void handleAddMotor() {
        try {
            System.out.print("Enter the motor technology (Synchronous/Asynchronous): ");
            String motorTechnology = this.scanner.next();

            System.out.print("Enter the motor price: ");
            int motorPrice = this.scanner.nextInt();

            System.out.print("Enter the motor power: ");
            int motorPower = this.scanner.nextInt();

            System.out.print("Enter the motor current consumption: ");
            float motorConsumption = this.scanner.nextFloat();

            System.out.print("Enter the car name that the motor is compatible with: ");
            String motorCompatibity = this.scanner.next();

            this.motorService.add(motorTechnology, motorPrice, motorPower, motorConsumption, motorCompatibity);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (MotorValidatorException var10) {
            System.out.println(var10.getMessage());
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleUpdateMotor() {
        try {
            System.out.print("Enter the ID you want to update: ");
            Long id = scanner.nextLong();

            System.out.print("Enter the motor technology (Synchronous/Asynchronous): ");
            String motorTechnology = this.scanner.next();

            System.out.print("Enter the motor price: ");
            int motorPrice = this.scanner.nextInt();

            System.out.print("Enter the motor power: ");
            int motorPower = this.scanner.nextInt();

            System.out.print("Enter the motor current consumption: ");
            float motorConsumption = this.scanner.nextFloat();

            System.out.print("Enter the car name that the motor is compatible with: ");
            String motorCompatibity = this.scanner.next();

            this.motorService.update(id,motorTechnology, motorPrice, motorPower, motorConsumption, motorCompatibity);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (CarValidatorException var10) {
            System.out.println(var10.getMessage());
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleDeleteMotor() {
        try {
            System.out.print("Enter the ID you want to delete: ");
            Long id = scanner.nextLong();
            this.motorService.delete(id);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (CarValidatorException var10) {
            System.out.println(var10.getMessage());
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleShowMotors() {
        Iterator var1 = this.motorService.getAll().iterator();

        while(var1.hasNext()) {
            Motor c = (Motor)var1.next();
            System.out.println(c);
        }
    }

    private void handleReturnMotor() {
        try {
            System.out.print("Enter the ID of the motor: ");
            Long id = scanner.nextLong();

            System.out.print("Enter the numbers of motors to return: ");
            int returnedMotors = scanner.nextInt();

            this.motorService.updateReturn(id, returnedMotors);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    public void runShowClientMenu() {
        while (true) {
            int option = this.scanner.nextInt();
            switch (option) {
                case 1:
                    handleAddClient();
                    showClientMenu();
                    break;
                case 2:
                    handleUpdateClient();
                    showClientMenu();
                    break;
                case 3:
                    handleDeleteClient();
                    showClientMenu();
                    break;
                case 4:
                    handleShowClients();
                    showClientMenu();
                    break;
                case 0:
                    this.runConsole();
                    break;
                default:
                    System.out.println("Unsupported command.");
            }
        }
    }

    private void handleAddClient() {
        try {
            System.out.print("Enter the company name: ");
            String companyName = this.scanner.next();

            System.out.print("Enter the car name: ");
            String carName = this.scanner.next();

            System.out.print("Enter the registration date: ");
            String regDate = this.scanner.next();

            this.clientService.add(companyName,carName, regDate);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (ClientValidatorException var10) {
            System.out.println(var10.getMessage());
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleUpdateClient() {
        try {
            System.out.print("Enter the ID of the client: ");
            Long id = scanner.nextLong();

            System.out.print("Enter the company name: ");
            String companyName = this.scanner.next();

            System.out.print("Enter the car name: ");
            String carName = this.scanner.next();

            System.out.print("Enter the registration date: ");
            String regDate = this.scanner.next();

            this.clientService.update(id,companyName,carName, regDate);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleDeleteClient() {
        try {
            System.out.print("Enter the ID you want to delete: ");
            Long id = scanner.nextLong();

            this.clientService.delete(id);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleShowClients() {
        Iterator var1 = this.clientService.getAll().iterator();

        while(var1.hasNext()) {
            Client c = (Client)var1.next();
            System.out.println(c);
        }
    }

    public void runShowTransactionMenu() {
        while (true) {
            int option = this.scanner.nextInt();
            switch (option) {
                case 1:
                    handleAddTransaction();
                    showTransactionMenu();
                    break;
                case 2:
                    handleUpdateTransaction();
                    showTransactionMenu();
                    break;
                case 3:
                    handleDeleteTransaction();
                    showTransactionMenu();
                    break;
                case 4:
                    handleShowTransactions();
                    showTransactionMenu();
                    break;
                case 0:
                    this.runConsole();
                    break;
                default:
                    System.out.println("Unsupported command.");
            }
        }
    }

    private void handleAddTransaction() {
        try {
            System.out.print("Enter the motor ID: ");
            Long motorId = scanner.nextLong();

            System.out.print("Enter the client ID: ");
            Long clientId = scanner.nextLong();

            System.out.print("Enter the car ID: ");
            Long carId = scanner.nextLong();

            System.out.print("Enter the motor pieces: ");
            int motorPieces = scanner.nextInt();

            System.out.print("Enter the transaction date: ");
            String transactionDate = this.scanner.next();

            this.transactionService.add( motorId, clientId,  carId,  motorPieces,  transactionDate);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleUpdateTransaction() {
        try {
            System.out.print("Enter the transaction ID: ");
            Long id = scanner.nextLong();

            System.out.print("Enter the motor ID: ");
            Long motorId = scanner.nextLong();

            System.out.print("Enter the client ID: ");
            Long clientId = scanner.nextLong();

            System.out.print("Enter the car ID: ");
            Long carId = scanner.nextLong();

            System.out.print("Enter the motor pieces: ");
            int motorPieces = scanner.nextInt();

            System.out.print("Enter the transaction date: ");
            String transactionDate = this.scanner.next();

            this.transactionService.update(id, motorId, clientId,  carId,  motorPieces,  transactionDate);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleDeleteTransaction() {
        try {
            System.out.print("Enter the ID you want to delete: ");
            Long id = scanner.nextLong();

            this.transactionService.delete(id);
        } catch (InputMismatchException var9) {
            System.out.println("Wrong data type entered.");
            this.scanner.next();
        } catch (Exception var11) {
            System.out.println(var11.getMessage());
        }
    }

    private void handleShowTransactions() {
        Iterator var1 = this.transactionService.getAll().iterator();

        while(var1.hasNext()) {
            Transaction c = (Transaction) var1.next();
            System.out.println(c);
        }
    }
}
