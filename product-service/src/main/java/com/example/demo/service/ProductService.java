package com.example.demo.service;

import com.example.demo.model.ProductEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> getAllProduct();
    Optional<ProductEntity> getProductId(Long idProduk);
    ProductEntity saveProductId(ProductEntity productEntity);
    ProductEntity updateProductId(ProductEntity productEntity);
//    Version
    void deleteProduct(Long idProduk);
}
