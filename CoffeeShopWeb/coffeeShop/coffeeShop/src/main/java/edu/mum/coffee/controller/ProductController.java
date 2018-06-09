package edu.mum.coffee.controller;

import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping("/*")
    public String getAllProducts(Model model){
        model.addAttribute("products", productService.getAllProduct());
        return "products";
    }
}
