package controllers;

import dao.PersonsDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {
    @GetMapping("/persons")
    public String persons(Model model) {
        PersonsDao personsDao = new PersonsDao();
        model.addAttribute("persons", personsDao.getAllPersons());
        return "persons";
    }
}
