package com.project.carmotor.carmotor.Repository;

import com.project.carmotor.carmotor.Domain.Car;
import com.project.carmotor.carmotor.Domain.Motor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotorRepository extends JpaRepository<Motor, Long> {

}