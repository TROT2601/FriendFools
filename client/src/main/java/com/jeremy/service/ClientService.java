package com.jeremy.service;

import com.jeremy.model.Client;
import com.jeremy.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService implements BaseService<Client, String> {

    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void create(Client client) {
        this.clientRepository.save(client);
    }

    @Override
    public void update(Client client) {
        this.clientRepository.save(client);
    }

    @Override
    public void delete(Client client) {
        this.clientRepository.delete(client);
    }

    @Override
    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    @Override
    public Client findById(String codClient) {
        return clientRepository.findById(codClient).orElseGet(null);
    }

    @Override
    public List<Client> saveAll(List<Client> c) {
        return clientRepository.saveAll(c);
    }
}
