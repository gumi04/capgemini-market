package com.capgemini.market.domain.service;

import com.capgemini.market.domain.Client;
import com.capgemini.market.domain.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clientRepository;

    public List<Client> getAll(){
        return clientRepository.getAll();
    }

    public Optional<Client> getClient(String id){
        return  clientRepository.getClient(id);
    }

    public  Client save(Client client){
        return  clientRepository.save(client);
    }


    public boolean delete(String id){
        return  getClient(id).map(c->{
            clientRepository.delete(id);
            return true;
        }).orElse(false);
    }

    public boolean updateClientName(String name,String id){
        return getClient(id).map(client -> {
            clientRepository.updateClientName(name,id);
            return true;
        }).orElse(false);
    }


    public Client update(Client client){
        return clientRepository.update(client);
    }

}
