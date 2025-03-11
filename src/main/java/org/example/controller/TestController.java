package org.example.controller;

import org.example.entity.eProducts;
import org.example.repository.products.CustomizedProductsCrudRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value="/test")
public class TestController {

    private final CustomizedProductsCrudRepository productsRepository;

    TestController(
            CustomizedProductsCrudRepository productsRepository
    ){
        this.productsRepository = productsRepository;
    }

    @GetMapping(value="/")
    public eProducts getProducts(){
        return productsRepository.findById(1).orElse(null);
    }
}
