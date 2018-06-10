package edu.mum.coffee.controller;

import edu.mum.coffee.domain.Product;
import edu.mum.coffee.service.PersonService;
import edu.mum.coffee.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @Autowired
    ProductService productService;

    @Autowired
    PersonService personService;

    @GetMapping(value = {"/*", "/products"})
    public String getAllProducts(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        model.addAttribute("persons", personService.getAllPerson());
        return "products";
    }

    @GetMapping("/createProduct")
    public String createProduct(){
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute("product")Product product){
        productService.save(product);
        return "redirect:/products";
    }

    @GetMapping("/editProduct/{productId}")
    public String editPerson(@PathVariable("productId") int productId, Model model) {
        model.addAttribute("product", productService.findById(productId));
        return "editProduct";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId") int productId) {
        productService.delete(productService.findById(productId));
        return "redirect:/products";
    }

    @PostMapping("/editProduct")
    public String editPerson(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/products";
    }
}
