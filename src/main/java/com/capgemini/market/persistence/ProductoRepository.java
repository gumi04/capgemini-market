package com.capgemini.market.persistence;

import com.capgemini.market.domain.Product;
import com.capgemini.market.domain.repository.ProductRepository;
import com.capgemini.market.persistence.crud.ProductoCrudRepository;
import com.capgemini.market.persistence.entity.Producto;
import com.capgemini.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Column;
import java.util.List;
import java.util.Optional;

//@Component generalizacion  se utiliza con clases genericas
@Repository //le indicamos a spring que es un componente que  interactua con db, spring
public class ProductoRepository implements ProductRepository {
    @Autowired //los objt que reciben esta notacion le cedemos el control a spring para que haga lasinstancias solo con componenes de spring
    private ProductoCrudRepository productoCrudRepository;
    @Autowired
    private ProductMapper mapper;


    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(Integer categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(Integer quantity) {
        Optional<List<Producto>> productos = productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(Integer productId) {
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }

    @Override
    public Product save(Product product) {
        Producto producto= mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete(Integer idProducto){
        productoCrudRepository.deleteById(idProducto);
    }

    @Override
    public Long getCountProduct() {
        return  productoCrudRepository.count();
    }

    @Override
    public void updateProductName(String name,Integer productId) {
        productoCrudRepository.updateProduct(name,productId);
    }

    @Override
    public Product update(Product product) {
        Producto producto= mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    //named Querys son personalizados


}
