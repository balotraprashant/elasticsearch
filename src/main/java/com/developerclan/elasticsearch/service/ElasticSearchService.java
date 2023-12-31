package com.developerclan.elasticsearch.service;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import co.elastic.clients.elasticsearch.core.SearchResponse;
import com.developerclan.elasticsearch.entity.Product;
import com.developerclan.elasticsearch.util.ElasticSearchUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.function.Supplier;

@Service
public class ElasticSearchService {

    @Autowired
    private ElasticsearchClient elasticsearchClient;

    public SearchResponse<Product> fuzzySearch(String approximateProductName) throws IOException {
        Supplier<Query> supplier = ElasticSearchUtil.createSupplierQuery(approximateProductName);
        SearchResponse<Product> response = elasticsearchClient
                .search(s -> s.index("products").query(supplier.get()), Product.class);
        System.out.println("Elastic Search Supplier Fuzzy Query " + supplier.get().toString());
        return response;
    }
}
