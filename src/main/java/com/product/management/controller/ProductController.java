package com.product.management.controller;

import com.product.management.entity.Product;
import com.product.management.exception.ProductException;
import com.product.management.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


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
    public ResponseEntity<Product> addProduct(@Valid @RequestBody Product product){
    return ResponseEntity.ok(productService.saveProduct(product));
    }

    @GetMapping
    @Operation(summary="Get All Products")
    public ResponseEntity<List<Product>> getAllProducts(){
    return ResponseEntity.ok(productService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary="Get Product By Id")
    public ResponseEntity<Product> getProductById(@PathVariable String id){
      return ResponseEntity.ok(productService.findById(id));
}


    @PutMapping("/{id}")
    @Operation(summary="Update Product")
    public void updateProduct(@RequestBody Product product,@RequestParam String id) {
        productService.updateProduct(product,id);

    }


    @DeleteMapping("/{id}")
    @Operation(summary="Delete Product")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/expensive")
    @Operation(summary="Get Expensive Price")
    public List<Product> getExpensiveProducts(@RequestParam Double minPrice) {
        return productService.expensiveProduct(minPrice);
    }



}
