package com.barclays.codefest.hopetalk.controller.service;

import com.barclays.codefest.hopetalk.repository.ClientRepository;
import com.barclays.codefest.hopetalk.repository.model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client getClientById(int clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(() -> new ResourceNotFoundException("Client is not found for this id :: " + clientId));
    }

    public Client getClientByName(String clientName) {
        return null;
    }
}
