package dao;

import Utilities.Utility;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Order;
import domain.Person;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class OrdersDao {
    private String baseUrl = "http://localhost:8090/api/order/";
    ObjectMapper mapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;

    public List<Order> getAllOrders(){
        List<Order> orders = new ArrayList<>();
        String target = baseUrl + "list";
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = Utility.createHttpHeaders();
            ResponseEntity<String> response = restTemplate.exchange(target, HttpMethod.GET, new HttpEntity<String>("parameters", headers), String.class);
            orders = mapper.readValue(response.getBody(), new TypeReference<List<Order>>() {});
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return orders;
    }
}
