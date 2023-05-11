package com.project.carmotor.carmotor.Controller;

import com.project.carmotor.carmotor.Domain.Client;
import com.project.carmotor.carmotor.Domain.Motor;
import com.project.carmotor.carmotor.Domain.Transaction;
import com.project.carmotor.carmotor.Repository.ClientRepository;
import com.project.carmotor.carmotor.Repository.MotorRepository;
import com.project.carmotor.carmotor.Repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@ComponentScan
@AutoConfiguration
@RestController
public class TransactionController {

    @Autowired
    private final TransactionRepository repository;

    TransactionController(TransactionRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/transactions")
    public List<Transaction> all() {
        return repository.findAll();
    }

    @PostMapping("/transactions")
    public Transaction newTransaction(@RequestBody Transaction newTransaction) {
        return repository.save(newTransaction);
    }

    @PutMapping("/transactions/{id}")
    public Transaction replaceTransaction(@RequestBody Transaction newTransaction, @PathVariable Long id) {

        return repository.findById(id)
                    .map(transaction -> {
                    transaction.setTransactionDate(newTransaction.getTransactionDate());
                    transaction.setCarId(newTransaction.getCarId());
                    transaction.setClientId(newTransaction.getClientId());
                    transaction.setMotorId(newTransaction.getMotorId());
                    transaction.setMotorPieces(newTransaction.getMotorPieces());
                    transaction.setTotalSum(newTransaction.getTotalSum());
                    return repository.save(transaction);
                })
                .orElseGet(() -> {
                    newTransaction.setId(id);
                    return repository.save(newTransaction);
                });
    }

    @GetMapping("/transactions/{id}")
    Transaction one(@PathVariable Long id) {
        Transaction transaction = repository.findById(id)
                .orElse(null);
        return transaction;
    }

    @DeleteMapping("/transactions/{id}")
    public void deleteTransaction(@PathVariable Long id) {
        repository.deleteById(id);
    }
}