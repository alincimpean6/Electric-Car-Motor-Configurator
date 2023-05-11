
package com.project.carmotor.carmotor.Domain;

import com.project.carmotor.carmotor.Controller.ClientController;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ClientValidator {
    private ClientController clientController;
    public void validate(Client company, ClientController clientController) throws ClientValidatorException {
        this.clientController = clientController;

        StringBuilder sbClient = new StringBuilder();

        boolean found = false;
        String companyName = company.getCompanyName();
        for (Client c : clientController.all()) {
            int value = c.getCompanyName().compareTo(companyName);
            if (value == 0) {
                found = true;
            }
        }

        if (found == true) {
            sbClient.append("There already exists that company!\n");
        }
    }
}
