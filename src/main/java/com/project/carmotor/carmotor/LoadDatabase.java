package com.project.carmotor.carmotor;

import com.project.carmotor.carmotor.Domain.Car;
import com.project.carmotor.carmotor.Domain.Client;
import com.project.carmotor.carmotor.Domain.Motor;
import com.project.carmotor.carmotor.Domain.Transaction;
import com.project.carmotor.carmotor.Repository.CarRepository;
import com.project.carmotor.carmotor.Repository.ClientRepository;
import com.project.carmotor.carmotor.Repository.MotorRepository;
import com.project.carmotor.carmotor.Repository.TransactionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;

@ComponentScan
@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(CarRepository carRepository, ClientRepository clientRepository, MotorRepository motorRepository, TransactionRepository transactionRepository) {

        return args -> {
            log.info("Preloading " + carRepository.save(new Car("Ferrari",150F)));
            log.info("Preloading " + carRepository.save(new Car("VW", 1.5F)));
            log.info("Preloading " + clientRepository.save(new Client("Bavaria Motors","BMW", "18.05.2020")));
            log.info("Preloading " + clientRepository.save(new Client("VAG","VW","18.05.2022")));
            log.info("Preloading " + motorRepository.save(new Motor("Synchronous", 100, 1.5F, 4, "BMW")));
            log.info("Preloading " + motorRepository.save(new Motor("Synchronous", 120, 2.5F, 4, "VW")));
            //log.info("Preloading " + transactionRepository.save(new Transaction(1L,1L,1L,100,"18.05.2020")));
            //log.info("Preloading " + transactionRepository.save(new Transaction(2L,2L,2L,120,"18.05.2025")));
        };
    }
}