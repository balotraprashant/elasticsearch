package com.developerclan.elasticsearch.controller;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;
import com.developerclan.elasticsearch.entity.Product;
import com.developerclan.elasticsearch.service.ElasticSearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product/search")
public class ElasticSearchController {

    @Autowired
    private ElasticSearchService elasticSearchService;

    @GetMapping("fuzzy/{approximateProductName}")
    List<Product> fuzzySearch(@PathVariable("approximateProductName") String approximateProductName) throws IOException {
        SearchResponse<Product> response = elasticSearchService.fuzzySearch(approximateProductName);
        List<Hit<Product>> hits = response.hits().hits();
        System.out.println(hits);
        List<Product> products = new ArrayList<>();
        for (Hit<Product> hit: hits){
            products.add(hit.source());
        }
        return products;
    }
}
