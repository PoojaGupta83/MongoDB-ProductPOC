package com.product.management.service;

import com.product.management.entity.Product;
import com.product.management.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
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

        public Product findById(String id){
            Optional<Product> product=productRepo.findById(id);
            return product.map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound().build()).getBody();
        }

        public void updateProduct(Product product,String id) {
            productRepo.findById(id).map(existing-> {
                existing.setName(product.getName());
                existing.setCategory(product.getCategory());
                existing.setPrice(product.getPrice());
                productRepo.save(product);
            });
        }
        public void deleteProduct(String id) {
            if (productRepo.existsById(id)) {
                productRepo.deleteById(id);
            }
        }

        public List<Product> expensiveProduct(Double minPrice){
            return productRepo
                    .findAll()
                    .stream()
                    .filter(product->product.getPrice()>minPrice)
                    .collect(java.util.stream.Collectors.toList());
        }
}
