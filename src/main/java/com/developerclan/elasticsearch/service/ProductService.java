package com.developerclan.elasticsearch.service;

import com.developerclan.elasticsearch.dto.ProductDto;
import com.developerclan.elasticsearch.model.Product;

public interface ProductService {
    Iterable<Product> getAllProducts();
    Product findById(Long id);
    Product insertProduct(Product product);
    Product updateProduct(Long id, ProductDto productDto);
    void deleteProduct(Long id);
}
