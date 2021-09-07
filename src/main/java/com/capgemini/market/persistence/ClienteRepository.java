package com.capgemini.market.persistence;


import com.capgemini.market.domain.Client;
import com.capgemini.market.domain.repository.ClientRepository;
import com.capgemini.market.persistence.crud.ClientCrudRepository;
import com.capgemini.market.persistence.entity.Cliente;
import com.capgemini.market.persistence.mapper.ClientMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ClienteRepository  implements ClientRepository {
    @Autowired
    private ClientCrudRepository clientCrudRepository;
    @Autowired
    private ClientMapper clientMapper;

    @Override
    public List<Client> getAll() {
        List<Cliente> clientes = (List<Cliente>) clientCrudRepository.findAll();
        return clientMapper.toClients(clientes);
    }

    @Override
    public Optional<Client> getClient(String id) {
        return clientCrudRepository.findById(id).map(c-> clientMapper.toClient(c));
    }

    @Override
    public Client save(Client client) {
        Cliente cliente= clientMapper.toCliente(client);
        return clientMapper.toClient(clientCrudRepository.save(cliente));
    }

    @Override
    public void delete(String id) {
        clientCrudRepository.deleteById(id);
    }

    @Override
    public void updateClientName(String name, String id) {
        clientCrudRepository.updateClientName(name,id);
    }

    @Override
    public Client update(Client client) {
        Cliente cliente=clientMapper.toCliente(client);
         return  clientMapper.toClient(clientCrudRepository.save(cliente));
    }
}
