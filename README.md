# Electric-Car-Motor-Configurator
REST application using Spring Boot and JSON server.

## App description

App that configures the electric motor for a specific car.

It`s created with Controller/Models/Repository and Services.

Model:
Car(String carName, float powerNeeded)
Client(String companyName,String carName, String regDate, int totalMotorsBought, int totalSumOfMotors)
Motor(String motorTechnology, int motorPrice, float motorPower, float motorConsumption, String motorCompatibity, int returnedMotors)
Transaction(Long motorId,Long clientId, Long carId, int motorPieces, String transactionDate, float totalSum)

Based on the client needs for the car, the application finds the right power and compatibility for it.

The application uses a command line to add the entityes and they can be shown in the frontend part of the project.
