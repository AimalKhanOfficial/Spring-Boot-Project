package edu.mum.coffee.controller;

import edu.mum.coffee.Utility.HttpCustomResponse;
import edu.mum.coffee.domain.Address;
import edu.mum.coffee.domain.Person;
import edu.mum.coffee.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/Person/")
public class PersonController {

    @Autowired
    PersonService personService;

    @PostMapping("Create")
    public HttpCustomResponse Create(@RequestBody Person person) {
        Person personRes = personService.savePerson(person);
        HttpCustomResponse customResponse = new HttpCustomResponse();
        if (personRes != null) {
            customResponse.setResponseCode(200);
            customResponse.setResponseDescription("Success, Person was added with ID: " + personRes.getId());
        } else {
            customResponse.setResponseCode(400);
            customResponse.setResponseDescription("The request did not execute as expected.");
        }
        return customResponse;
    }

    @PutMapping("Update")
    public HttpCustomResponse Update(@RequestBody Person person) {
        HttpCustomResponse customResponse = new HttpCustomResponse();
        try {

            //Updation Logic
            /*Person personRes = personService.findById(person.getId());
            personRes.setFirstName(person.getFirstName());
            personRes.setLastName(person.getLastName());
            personRes.setEmail(person.getEmail());
            personRes.setAddress(person.getAddress());
            personRes.setPhone(person.getPhone());
            personRes.setEnable(person.isEnable());
            personService.savePerson(personRes);*/

            //OR we could just do - since the id is already being provided - Result: Works Perfectly!
            personService.savePerson(person);


            customResponse.setResponseCode(200);
            customResponse.setResponseDescription("Success, Person was Updated with ID: " + person.getId());
        } catch (Exception ex) {
            customResponse.setResponseCode(400);
            customResponse.setResponseDescription("Something went wrong, try again later.");
        }
        return customResponse;
    }

    @GetMapping("List")
    public List<Person> List() {
        return personService.getAllPerson();
    }

    /*@DeleteMapping("Delete")
    public HttpCustomResponse Delete(@RequestBody Person person) {
        HttpCustomResponse customResponse = new HttpCustomResponse();
        try {
            personService.removePerson(person);
            customResponse.setResponseCode(200);
            customResponse.setResponseDescription("Success, Person was deleted with ID: " + person.getId());
        } catch (Exception ex) {
            customResponse.setResponseCode(400);
            customResponse.setResponseDescription("Something went wrong, try again later.");
        }
        return customResponse;
    }*/


}
