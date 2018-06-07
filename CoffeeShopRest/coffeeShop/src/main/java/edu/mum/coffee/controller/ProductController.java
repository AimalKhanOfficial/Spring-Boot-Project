package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Product;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {

    @GetMapping("/ListAllProducts")
    public List<Product> ListAllProducts(){
        return new ArrayList<>();
    }
}
