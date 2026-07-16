package com.springboot.di.app.springboot_di.repository;

import java.util.Arrays;
import java.util.List;

import com.springboot.di.app.springboot_di.model.Product;

public class ProductRepository {

    private List<Product> data;

    public ProductRepository() {
        this.data = Arrays.asList(
            new Product(1L,"Memoria Corsair",350L),
            new Product(2L,"Cpu Intel core i9",850L),
            new Product(3L,"Rx 9070 Xt",650L),
            new Product(4L,"Msi 850 wifi",150L)
        );
        
    }

    public List<Product> findAll(){
        return data;
    }

    public Product findById(Long id){
        return data.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
    }
    
}
