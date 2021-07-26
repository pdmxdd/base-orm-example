package dev.paulmatthews.baseormexample.controllers;

import dev.paulmatthews.baseormexample.data.PersonRepository;
import dev.paulmatthews.baseormexample.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Iterator;

@Controller
public class PersonController {
    @Autowired
    PersonRepository personRepository;

    @GetMapping
    public String getAllPeople(Model model) {
        ArrayList<Person> people = new ArrayList<>();
        for (Person person : personRepository.findAll()) {
            people.add(person);
        }
        model.addAttribute("people", people);
        return "people";
    }

    @PostMapping
    public String createPerson(Person newPerson, Model model) {
        System.out.println(newPerson);
        System.out.println(newPerson.getId());
        System.out.println(newPerson.getFirstName());
        System.out.println(newPerson.getLastName());
        personRepository.save(newPerson);

        ArrayList<Person> people = new ArrayList<>();
        for (Person person : personRepository.findAll()) {
            people.add(person);
        }
        model.addAttribute("people", people);
        return "people";
    }
}
