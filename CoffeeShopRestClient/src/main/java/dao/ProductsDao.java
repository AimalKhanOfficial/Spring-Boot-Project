package dao;

import Utilities.Utility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import domain.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class ProductsDao {

    private String baseUrl = "http://localhost:8090/api/product/";
    ObjectMapper mapper = new ObjectMapper();

    public List<Product> getAllProducts(){
        List<Product> products = new ArrayList<>();
        String target = baseUrl + "list";
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = Utility.createHttpHeaders();
            ResponseEntity<String> response = restTemplate.exchange(target, HttpMethod.GET, new HttpEntity<String>("parameters", headers), String.class);
            products = mapper.readValue(response.getBody(), new TypeReference<List<Product>>() {});
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return products;
    }

    public void createProduct(Product product){
        String target = baseUrl + "create";
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = Utility.createHttpHeaders();
            ResponseEntity<Product> response = restTemplate.exchange(target, HttpMethod.POST, new HttpEntity<Product>(product, headers), Product.class);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    public void updateProduct(Product product){
        String target = baseUrl + "update";
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = Utility.createHttpHeaders();
            ResponseEntity<Product> response = restTemplate.exchange(target, HttpMethod.PUT, new HttpEntity<Product>(product, headers), Product.class);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    public void deleteProduct(Product product){
        String target = baseUrl + "delete";
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = Utility.createHttpHeaders();
            ResponseEntity<Product> response = restTemplate.exchange(target, HttpMethod.DELETE, new HttpEntity<Product>(product, headers), Product.class);
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }

    public Product getProductById(String id){
        Product product = new Product();
        String target = baseUrl + "getbyid/{productId}";
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = Utility.createHttpHeaders();
            HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);
            ResponseEntity<String> response = restTemplate.exchange(target, HttpMethod.GET, httpEntity, String.class, id);
            product = mapper.readValue(response.getBody(), new TypeReference<Product>() {});
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return product;
    }
}
