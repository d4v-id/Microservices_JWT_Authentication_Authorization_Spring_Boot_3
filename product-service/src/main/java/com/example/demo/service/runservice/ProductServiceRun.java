package com.example.demo.service.runservice;

import com.example.demo.model.ProductEntity;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceRun implements ProductService {
    @Autowired
    private ProductRepository productRepository;

//    GET
    @Override
    public List<ProductEntity> getAllProduct() {
        // Need Business Logic
        return (List<ProductEntity>) productRepository.findAll();
    }
    @Override
    public Optional<ProductEntity> getProductId(Long idProduk) {
        return productRepository.findById(idProduk);
    }


//    POST
    @Override
    public ProductEntity saveProductId(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

//    PUT
    @Override
    public ProductEntity updateProductId(ProductEntity productEntity) {
        return productRepository.save(productEntity);
    }

//    DELETE
    @Override
    public void deleteProduct(Long idProduk) {
        productRepository.deleteById(idProduk);
    }

//    private ProductVersion productToV1(ProductEntity distribusiEntity){
//        return this.modelMapper.map(distribusiEntity, ProductVersion.class);
//    }

}

