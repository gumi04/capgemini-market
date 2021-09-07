package com.capgemini.market.web.controller;

import com.capgemini.market.domain.Product;
import com.capgemini.market.domain.service.ProductService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //controlador de api rest
@RequestMapping("api/products") //path donde aceptara peticiones
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    @ApiOperation("Get all supermarket prodcuts")
    @ApiResponse(code = 200,message = "OK")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Search a product with and ID")
    @ApiResponses({
            @ApiResponse( code=200, message = "OK"),
            @ApiResponse( code=404, message = "Product not found")
    })
    public ResponseEntity<Product> getProduct(@ApiParam(value = "The id of the product", required = true,example = "7") @PathVariable("id") Integer producId){
        return   productService.getProduct(producId).
                map(product ->  new ResponseEntity<>(product,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    @ApiOperation("Get all prodcuts of the category")
    @ApiResponses({
            @ApiResponse( code=200, message = "OK"),
            @ApiResponse( code=404, message = "Products not founds")
    })
    public ResponseEntity<List<Product>> getByCategory(@ApiParam(value = "The id of the product", required = true,example = "1") @PathVariable("categoryId") Integer categoryId){
        return  productService.getByCategory(categoryId)
                .map( products ->  new ResponseEntity<>(products,HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    @ApiOperation("Save product into db")
    @ApiResponse(code = 201,message = "Product Create")
    public ResponseEntity<Product> save(@RequestBody Product product){
        return   new ResponseEntity<>(productService.save(product),HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("Delete a product specific")
    @ApiResponses({
            @ApiResponse( code=200, message = "OK"),
            @ApiResponse( code=404, message = "Product not founds")
    })
    public  ResponseEntity delete(@PathVariable("id") Integer productId){
        if(productService.delete(productId)){
            return  new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/count")
    public Long getCountProduct(){
        return  productService.getCountProduct();
    }


    //@PatchMapping()
    @PutMapping("/update/{name}/{id}")
    @ApiOperation("Update name a product Specific")
    @ApiResponses({
            @ApiResponse( code=200, message = "OK"),
            @ApiResponse( code=404, message = "Product not found")
    })
    public  ResponseEntity updateProductName( @PathVariable("name") String name,@PathVariable("id") Integer productId){
        if(productService.updateProduct(name,productId)){
            return  new ResponseEntity(HttpStatus.OK);
        }else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/save")
    @ApiResponse(code = 200,message = "Product Update")
    public ResponseEntity<Product> update(@RequestBody Product product){
        return  new ResponseEntity<>(productService.update(product),HttpStatus.OK);
    }
}
