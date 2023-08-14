package com.example.demo.controller;
import com.example.demo.model.ProductEntity;
import com.example.demo.service.runservice.ProductServiceRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produk")
public class ProductController {
    @Autowired
    private ProductServiceRun productServiceRun;

//     GET
    @GetMapping(path = "/all")
    public List<ProductEntity> getAllProductDetails(){
        return productServiceRun.getAllProduct();
    }
    @GetMapping(path = "/{id}")
    public Optional<ProductEntity> getProductIdVersion(@PathVariable("id") Long id){
        return productServiceRun.getProductId(id);
    }
//     POST
    @PostMapping(path = "/add")
    public ProductEntity createProductDetails(@RequestBody ProductEntity productEntity){
        return productServiceRun.saveProductId(productEntity);
    }

//     PUT
    @PutMapping(path = "/edit")
    public ProductEntity updateProductIdDetails(@RequestBody ProductEntity productEntity) {
        return  productServiceRun.updateProductId(productEntity);
    }
//     DELETE
    @DeleteMapping(path = "/delete/{id}")
    public void deleteProductDetails(@PathVariable("id")Long id){
        productServiceRun.deleteProduct(id);
    }
}
