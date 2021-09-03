package com.capgemini.market.persistence.crud;

import com.capgemini.market.persistence.entity.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

//recibe dos paramametros la entity (Tabla) , Tipo de llave primaria
public interface ProductoCrudRepository extends CrudRepository<Producto,Integer> {

    //lista de productos de una categoria en especifico
    List<Producto> findByIdCategoriaOrderByNombreAsc(Integer idCategoria); //QueryMethods


    ///pude ser llenado o no
    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(Integer cantidadStock,Boolean estado);

    /*
    //query nativo
    @Query(value = "SELECT * FROM productos WHERE id_categoria = ? order by nombre desc",nativeQuery = true)
    List<Producto>  findByCategory(Integer idCategoria);*/
}
