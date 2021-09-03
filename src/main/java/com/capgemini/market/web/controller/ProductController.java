package com.capgemini.market.web.controller;

import com.capgemini.market.domain.Product;
import com.capgemini.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //controlador de api rest
@RequestMapping("api/products") //path donde aceptara peticiones
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public List<Product> getAll(){
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Product> getProduct(@PathVariable("id") Integer producId){
        return  productService.getProduct(producId);
    }
    @GetMapping("/category/{categoryId}")
    public Optional<List<Product>> getByCategory(@PathVariable("categoryId") Integer categoryId){
        return  productService.getByCategory(categoryId);
    }
    @PostMapping("/save")
    public Product save(@RequestBody Product product){
        return  productService.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public  boolean delete(@PathVariable("id") Integer productId){
        return  productService.delete(productId);
    }

    @GetMapping("/count")
    public Long getCountProduct(){
        return  productService.getCountProduct();
    }
}
