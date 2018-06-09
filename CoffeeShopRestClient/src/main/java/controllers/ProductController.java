package controllers;

import dao.PersonsDao;
import dao.ProductsDao;
import domain.Person;
import domain.Product;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/editProduct/{productId}")
    public String editPerson(@PathVariable("productId") String productId, Model model) {
        model.addAttribute("product", new ProductsDao().getProductById(productId));
        return "editProduct";
    }

    @GetMapping("/deleteProduct/{productId}")
    public String deleteProduct(@PathVariable("productId") String productId) {
        ProductsDao personsDao = new ProductsDao();
        personsDao.deleteProduct(personsDao.getProductById(productId));
        return "redirect:/products";
    }

    @PostMapping("/editProduct")
    public String editPerson(@ModelAttribute("product") Product product) {
        new ProductsDao().updateProduct(product);
        return "redirect:/products";
    }
}
