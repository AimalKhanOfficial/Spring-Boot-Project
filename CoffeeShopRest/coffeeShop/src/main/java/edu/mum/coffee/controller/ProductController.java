package edu.mum.coffee.controller;

import edu.mum.coffee.Utility.HttpCustomResponse;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/product/")
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    HttpCustomResponse customResponse;

    @PostMapping("create")
    public HttpCustomResponse Create(@RequestBody Product product) {
        Product productRes = productService.save(product);
        if (productRes != null) {
            customResponse.setResponseCode(200);
            customResponse.setResponseDescription("Success, Product was added with ID: " + productRes.getId());
        } else {
            customResponse.setResponseCode(400);
            customResponse.setResponseDescription("The request did not execute as expected.");
        }
        return customResponse;
    }

    @GetMapping("list")
    public List<Product> List() {
        return productService.getAllProduct();
    }

    @PutMapping("update")
    public HttpCustomResponse Update(@RequestBody Product product) {
        Product productRes = productService.save(product);
        if (productRes != null) {
            customResponse.setResponseCode(200);
            customResponse.setResponseDescription("Success, Product was updated with ID: " + productRes.getId());
        } else {
            customResponse.setResponseCode(400);
            customResponse.setResponseDescription("The request did not execute as expected.");
        }
        return customResponse;
    }

    @DeleteMapping("delete")
    public HttpCustomResponse Delete(@RequestBody Product product) {
        try {
            productService.delete(product);
            customResponse.setResponseCode(200);
            customResponse.setResponseDescription("Success, Product was deleted");
        } catch (Exception ex) {
            customResponse.setResponseCode(400);
            customResponse.setResponseDescription("Something went wrong, try again later.");
        }
        return customResponse;
    }

    @GetMapping("getbyid/{productId}")
    public Product getById(@PathVariable int productId) {
        return productService.findById(productId);
    }
}
