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
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PersonsDao {
    private String baseUrl = "http://localhost:8090/api/person/";
    ObjectMapper mapper = new ObjectMapper();

    public List<Person> getAllPersons(){
        List<Person> persons = new ArrayList<>();
        String target = baseUrl + "list";
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = Utility.createHttpHeaders();
            ResponseEntity<String> response = restTemplate.exchange(target, HttpMethod.GET, new HttpEntity<String>("parameters", headers), String.class);
            persons = mapper.readValue(response.getBody(), new TypeReference<List<Person>>() {});
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return persons;
    }

    public Person getPersonById(String id){
        Person person = new Person();
        String target = baseUrl + "getbyid/{personId}";
        RestTemplate restTemplate = new RestTemplate();
        try {
            HttpHeaders headers = Utility.createHttpHeaders();
            HttpEntity<?> httpEntity = new HttpEntity<Object>(headers);
            ResponseEntity<String> response = restTemplate.exchange(target, HttpMethod.GET, httpEntity, String.class, id);
            person = mapper.readValue(response.getBody(), new TypeReference<Person>() {});
        } catch (Exception ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
        return person;
    }
}
