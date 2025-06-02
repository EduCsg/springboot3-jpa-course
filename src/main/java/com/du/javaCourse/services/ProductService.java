package com.du.javaCourse.services;

import com.du.javaCourse.entities.Product;
import com.du.javaCourse.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        Optional<Product> productOpt = productRepository.findById(id);
        return productOpt.get();
    }

}
