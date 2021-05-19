package com.example.dtomapstruct.service;

import com.example.dtomapstruct.jpa.Product;
import com.example.dtomapstruct.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class ProductService {
    private final ProductRepository productRepository;

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    public Optional<Product> findById(Integer id){
        return productRepository.findById(id);
    }
    public void deleteById(Integer id){
        productRepository.deleteById(id);
    }

}
