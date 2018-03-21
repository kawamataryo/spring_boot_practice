package com.example.demo.controller;

import com.example.demo.form.PersonForm;
import com.example.demo.form.SearchForm;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class HomeController {

  @Autowired
  PersonRepository personRepository;

  @RequestMapping(method = RequestMethod.GET)
  public String get(Model model) {
    model.addAttribute("message", "please enter this textbox");
    model.addAttribute("persons", personRepository.findAll());
    return "home";
  }

  @RequestMapping(value = "search", method = RequestMethod.GET)
  public String search(@ModelAttribute("searchForm") @Valid SearchForm searchForm,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("message", "Error");
    } else {
      Integer age = searchForm.getAge();
      model.addAttribute("age", age);
      model.addAttribute("result", personRepository.findByAgeIs(age));
    }
    return "searchResult";
  }

  @RequestMapping(method = RequestMethod.POST)
  public String post(@ModelAttribute("personForm") @Valid PersonForm personForm,
      BindingResult result, Model model) {
    if (result.hasErrors()) {
      model.addAttribute("message", "Error");
    } else {
      String name = personForm.getName();
      Integer age = personForm.getAge();
      personRepository.save(new Person(name, age));
      model.addAttribute("message", "Success save person name: " + name + ", age: " + age);
    }
    model.addAttribute("persons", personRepository.findAll());
    return "home";
  }
}
