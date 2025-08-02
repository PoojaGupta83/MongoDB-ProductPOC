package com.product.management.service;

import com.product.management.entity.Product;
import com.product.management.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

//This service class is used to provide business logic related to products
@Service
public class ProductService {

    private final ProductRepository productRepo;

    //constructor Injection
        public ProductService(ProductRepository productRepo){
            this.productRepo=productRepo;
        }

        public Product saveProduct(Product product){
            return productRepo.save(product);
        }

        public List<Product> findAll(){
            return productRepo.findAll();
        }

        public Optional<Product> findById(String id){
            return productRepo.findById(id);
        }

        public void updateProduct(Product product) {
            productRepo.save(product);
        }
        public void deleteProduct(String id){
            productRepo.deleteById(id);
        }

        public List<Product> expensiveProduct(Double minPrice){
            return productRepo
                    .findAll()
                    .stream()
                    .filter(product->product.getPrice()>minPrice)
                    .collect(java.util.stream.Collectors.toList());
        }
}
