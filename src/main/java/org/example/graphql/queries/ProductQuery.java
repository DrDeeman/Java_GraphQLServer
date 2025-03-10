package org.example.graphql.queries;

import graphql.com.google.common.collect.Lists;
import org.example.entity.eProducts;
import org.example.repository.products.CustomizedProductsCrudRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class ProductQuery {


    private final CustomizedProductsCrudRepository productsRepository;

    ProductQuery(
            CustomizedProductsCrudRepository productsRepository
    ) {
        this.productsRepository = productsRepository;
    }

    @QueryMapping
    public eProducts getProduct(@Argument final int id) {
        return productsRepository.findById(id).orElseThrow();
    }

    @QueryMapping
    public List<eProducts> getProductsAll() {
        return Lists.newArrayList(productsRepository.findAll());
    }
}
