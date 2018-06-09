package controllers;

import dao.ProductsDao;
import domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String products(Model model) {
        ProductsDao productsDao = new ProductsDao();
        model.addAttribute("products", productsDao.getAllProducts());
        return "products";
    }

    @GetMapping("/createProduct")
    public String createProduct(){
        return "createProduct";
    }

    @PostMapping("/createProduct")
    public String createProduct(@ModelAttribute("product")Product product){
        new ProductsDao().createProduct(product);
        return "redirect:/products";
    }
}
