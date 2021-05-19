package com.example.dtomapstruct.dto;

import com.example.dtomapstruct.jpa.Product;
import lombok.Data;
import org.mapstruct.Mapper;


import java.util.List;
//@Data
@Mapper
public interface ProductMapper {
   //ProductDTO toProductDTO(Product product);
    List<ProductDTO> toProductDTOs(List<Product> products);
    Product toProduct(ProductDTO productDTO);

}
