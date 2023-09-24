package com.developerclan.elasticsearch.service.impl;

import com.developerclan.elasticsearch.dto.ProductDto;
import com.developerclan.elasticsearch.model.Product;
import com.developerclan.elasticsearch.repository.ProductRepository;
import com.developerclan.elasticsearch.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id : " + id));
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Long id, ProductDto productDto) {
        Product prod = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found with id :" + id));
        BeanUtils.copyProperties(productDto, prod);
        return productRepository.save(prod);
    }

    @Override
    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
