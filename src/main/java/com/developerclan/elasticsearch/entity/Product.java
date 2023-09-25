package com.developerclan.elasticsearch.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "products")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    @Id
    private Long id;
    private String name;
    private String description;
    private int quantity;
    private double price;
}
