package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/products")
    public String products(){
        return "products";
    }

    @GetMapping("/persons")
    public String persons(){
        return "persons";
    }

    @GetMapping("/orders")
    public String orders(){
        return "orders";
    }

    @GetMapping("/*")
    public String index(){
        return "index";
    }

}
