package com.capgemini.market.domain.repository;

import com.capgemini.market.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductRepository {
    List<Product> getAll();
    Optional<List<Product>> getByCategory(Integer categoryId);
    Optional<List<Product>> getScarseProducts(Integer quantity);
    Optional<Product> getProduct(Integer productId);
    Product save(Product product);
    void delete(Integer productId);
    Long getCountProduct();
    void updateProductName(String name,Integer productId);
    Product update(Product product);
}
