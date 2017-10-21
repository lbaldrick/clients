package com.baldrick.clients.service;

import com.baldrick.clients.model.Client;
import com.baldrick.clients.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    ClientRepository clientRepository;

    public Optional<Client> findByUsername(String username) {
        return clientRepository.findByUsername(username);
    }

    public Optional<Client> findByEmail(String email) {
        return clientRepository.findByEmail(email);
    }

    public void createClient(Client client) {
        clientRepository.insert(client);
    }
}
