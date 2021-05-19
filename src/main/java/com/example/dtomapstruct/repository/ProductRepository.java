package com.example.dtomapstruct.repository;

import com.example.dtomapstruct.jpa.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Integer> {
}
