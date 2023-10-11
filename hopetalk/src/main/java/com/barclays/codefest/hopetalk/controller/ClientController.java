package com.barclays.codefest.hopetalk.controller;

import com.barclays.codefest.hopetalk.controller.service.ClientService;
import com.barclays.codefest.hopetalk.repository.model.Client;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@NoArgsConstructor
public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @RequestMapping("/clients")
    public List<Client> getAllClients() {
           return clientService.getAllClients();
    }

    @RequestMapping("/clients/clientById/{clientId}")
    public Client getClientById(@PathVariable("clientId") int clientId) {
          return clientService.getClientById(clientId);
    }

    @RequestMapping("/clients/{clientName}")
    public Client getClientByName(@PathVariable("clientName") String clientName) {
          return clientService.getClientByName(clientName);
    }
}

