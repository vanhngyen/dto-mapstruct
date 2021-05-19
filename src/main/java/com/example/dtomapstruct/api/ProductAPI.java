package com.example.dtomapstruct.api;

import com.example.dtomapstruct.dto.ProductDTO;
import com.example.dtomapstruct.dto.ProductMapper;
import com.example.dtomapstruct.jpa.Product;
import com.example.dtomapstruct.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductAPI {
    private final ProductService productService;
    private final ProductMapper productMapper;
    //Return list ProductDTO sau khi da mapping voi Product
    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll(){
        return ResponseEntity.ok(productMapper.toProductDTOs(productService.findAllProduct()));

    }
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct( @RequestBody ProductDTO productDTO){
        productService.saveProduct(productMapper.toProduct(productDTO));

        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }
    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct( @PathVariable Integer id,@RequestBody ProductDTO productDTO ){
        Product product = productMapper.toProduct(productDTO);
        product.setId(id);
        productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Integer id){
        productService.deleteById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }



}
