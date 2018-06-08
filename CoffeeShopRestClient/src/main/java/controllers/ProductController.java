package controllers;

import dao.ProductsDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {

    @GetMapping("/products")
    public String products(Model model) {
        ProductsDao productsDao = new ProductsDao();
        model.addAttribute("products", productsDao.getAllProducts());
        return "products";
    }
}
