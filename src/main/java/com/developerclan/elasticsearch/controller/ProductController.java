package com.developerclan.elasticsearch.controller;

import com.developerclan.elasticsearch.dto.ProductDto;
import com.developerclan.elasticsearch.model.Product;
import com.developerclan.elasticsearch.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/findAll")
    Iterable<Product> findAll() {
        return productService.getAllProducts();
    }

    @GetMapping("find/{id}")
    Product findProduct(@PathVariable("id") Long id) {
        return this.productService.findById(id);
    }

    @PostMapping("/save")
    Product saveProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    @PutMapping("update/{id}")
    Product updateProduct(@PathVariable("id") Long id, @RequestBody ProductDto productDto) {
        return this.productService.updateProduct(id, productDto);
    }

    @DeleteMapping("delete/{id}")
    void updateProduct(@PathVariable("id") Long id) {
        this.productService.deleteProduct(id);
    }
}
