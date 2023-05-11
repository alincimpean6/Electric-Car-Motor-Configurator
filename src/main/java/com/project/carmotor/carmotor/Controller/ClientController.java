package com.project.carmotor.carmotor.Controller;

import com.project.carmotor.carmotor.Domain.Client;
import com.project.carmotor.carmotor.Domain.Motor;
import com.project.carmotor.carmotor.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@AutoConfiguration
@RestController
public class ClientController {

    @Autowired
    private final ClientRepository repository;

    ClientController(ClientRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/clients")
    public List<Client> all() {
        return repository.findAll();
    }

    @PostMapping("/clients")
    public Client newClient(@RequestBody Client newClient) {
        return repository.save(newClient);
    }

    @GetMapping("/clients/{id}")
    public Client one(@PathVariable Long id) {
        Client client = repository.findById(id)
                .orElse(null);
        return client;
    }

    @PutMapping("/clients/{id}")
    public Client replaceClient(@RequestBody Client newClient, @PathVariable Long id) {

        return repository.findById(id)
                .map(client -> {
                    client.setCarName(newClient.getCarName());
                    client.setCompanyName(newClient.getCompanyName());
                    client.setRegDate(newClient.getRegDate());
                    client.setTotalMotorsBought(newClient.getTotalMotorsBought());
                    client.setTotalSumOfMotors(newClient.getTotalSumOfMotors());
                    return repository.save(client);
                })
                .orElseGet(() -> {
                    newClient.setId(id);
                    return repository.save(newClient);
                });
    }

    @DeleteMapping("/clients/{id}")
    public void deleteClient(@PathVariable Long id) {
        repository.deleteById(id);
    }
}