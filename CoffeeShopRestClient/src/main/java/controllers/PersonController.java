package controllers;

import dao.PersonsDao;
import domain.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PersonController {
    @GetMapping("/persons")
    public String persons(Model model) {
        PersonsDao personsDao = new PersonsDao();
        model.addAttribute("persons", personsDao.getAllPersons());
        return "persons";
    }

    @GetMapping("/createPerson")
    public String createPerson(Model model) {
        return "createPerson";
    }

    @GetMapping("/editPerson/{personId}")
    public String editPerson(@PathVariable("personId") String personId, Model model) {
        model.addAttribute("person", new PersonsDao().getPersonById(personId));
        return "editPerson";
    }

    @PostMapping("/editPerson")
    public String editPerson(@ModelAttribute("person") Person person) {
        new PersonsDao().updatePerson(person);
        return "redirect:/persons";
    }

    @PostMapping("/createPerson")
    public String createPerson(@ModelAttribute("person") Person person){
        new PersonsDao().createPerson(person);
        return "redirect:/persons";
    }
}
