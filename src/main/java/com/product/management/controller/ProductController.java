package com.product.management.controller;

import com.product.management.entity.Product;
import com.product.management.exception.ProductException;
import com.product.management.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public Product addProduct(@Valid @RequestBody Product product){
   return productService.saveProduct(product);
    }

    @GetMapping
    public List<Product> getAllProducts(){
    return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable String id){
    return productService.findById(id).orElseThrow(()->new ProductException(id));

    }


    public void updateProduct(@RequestBody Product product) {
        productService.updateProduct(product);
    }


    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable String id) {
        productService.deleteProduct(id);
    }

    @GetMapping("/expensive")
    public List<Product> getExpensiveProducts(@RequestParam Double minPrice) {
        return productService.expensiveProduct(minPrice);
    }
}
