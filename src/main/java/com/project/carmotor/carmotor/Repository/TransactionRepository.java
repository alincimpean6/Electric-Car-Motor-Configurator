package com.project.carmotor.carmotor.Repository;

import com.project.carmotor.carmotor.Domain.Car;
import com.project.carmotor.carmotor.Domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

}