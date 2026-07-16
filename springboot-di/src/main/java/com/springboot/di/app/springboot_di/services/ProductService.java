package com.springboot.di.app.springboot_di.services;

import java.util.List;
import java.util.stream.Collectors;

import com.springboot.di.app.springboot_di.model.Product;
import com.springboot.di.app.springboot_di.repository.ProductRepository;

public class ProductService {

    private ProductRepository productRepository= new ProductRepository();

    public List<Product> findAll(){
        return productRepository.findAll().stream().map(p -> {
           Double priceImp = p.getPrice() * 1.25d;
           Product newProduct = new Product( p.getId(),p.getName(),priceImp.longValue());
            return newProduct;
        }).collect(Collectors.toList());
    }

    public Product findById(Long Id){
        return productRepository.findById(Id);
    }

}
