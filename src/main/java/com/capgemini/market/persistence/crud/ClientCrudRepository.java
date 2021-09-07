package com.capgemini.market.persistence.crud;

import com.capgemini.market.persistence.entity.Cliente;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;

public interface ClientCrudRepository  extends CrudRepository<Cliente,String> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE clientes set nombre = ? where id = ?",nativeQuery = true)
    void updateClientName(String nombre, String id );

}
