package com.demo.springboot.security.controller;

import java.util.List;

import com.demo.springboot.security.model.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demo.springboot.security.service.AnimalService;

@Controller
public class UserController {

    @Autowired
    private AnimalService animalService;

    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String homePage(Model model){
        List<Animal> animals = animalService.List();
        model.addAttribute("animals", animals);
        return "user/home";
    }
}
