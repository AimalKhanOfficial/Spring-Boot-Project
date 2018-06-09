package edu.mum.coffee.controller;

import edu.mum.coffee.Utility.HttpCustomResponse;
import edu.mum.coffee.domain.Address;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/person/")
public class PersonController {

    @Autowired
    PersonService personService;

    @Autowired
    HttpCustomResponse customResponse;

    @PostMapping("create")
    public HttpCustomResponse Create(@RequestBody Person person) {
        Person personRes = personService.savePerson(person);
        if (personRes != null) {
            customResponse.setResponseCode(200);
            customResponse.setResponseDescription("Success, Person was added with ID: " + personRes.getId());
        } else {
            customResponse.setResponseCode(400);
            customResponse.setResponseDescription("The request did not execute as expected.");
        }
        return customResponse;
    }

    @PutMapping("update")
    public HttpCustomResponse Update(@RequestBody Person person) {
        Person personRes = personService.savePerson(person);
        if (personRes != null) {
            customResponse.setResponseCode(200);
            customResponse.setResponseDescription("Success, Person was Updated with ID: " + person.getId());
        } else {
            customResponse.setResponseCode(400);
            customResponse.setResponseDescription("The request did not execute as expected.");
        }
        return customResponse;
    }

    @GetMapping("list")
    public List<Person> List() {
        return personService.getAllPerson();
    }

    @GetMapping("getbyid/{personId}")
    public Person getById(@PathVariable Long personId) {
        return personService.findById(personId);
    }
}
