package com.project.carmotor.carmotor.Domain;

import org.springframework.stereotype.Component;

@Component
public class MotorValidator {
    public void validate(Motor motor) throws MotorValidatorException {
        StringBuilder sb = new StringBuilder();

        String type = motor.getMotorTechnology();
        if (!type.equals("Synchronous") && !type.equals("Asynchronous")) {
            sb.append("The type must be one of: Synchronous,Asynchronous\n");
        }
    }
}
