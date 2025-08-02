package com.product.management.controller;

import com.product.management.entity.Product;
import com.product.management.exception.ProductException;
import com.product.management.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/products")
@Tag(name = "Product Controller", description = "APIs for Product using MongoDB")
public class ProductController {

    private final ProductService productService;

public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @Operation(summary="Create Product")
    public Product addProduct(@Valid @RequestBody Product product){
   return productService.saveProduct(product);
    }

    @GetMapping
    @Operation(summary="Get All Products")
    public List<Product> getAllProducts(){
    return productService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary="Get Product By Id")
    public Product getProductById(@PathVariable String id){
    return productService.findById(id).orElseThrow(()->new ProductException(id));

    }


    @Operation(summary="Update Product")
    @PutMapping
    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }


    @Operation(summary="Delete Product")
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

    @Operation(summary="Get Expensive Price")
    @GetMapping("/expensive")
    public List<Product> getExpensiveProducts(@RequestParam Double minPrice) {
        return productService.expensiveProduct(minPrice);
    }
}
