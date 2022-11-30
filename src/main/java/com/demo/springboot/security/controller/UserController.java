package com.demo.springboot.security.controller;

import java.util.List;

import com.demo.springboot.security.model.Animal;
import com.demo.springboot.security.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.demo.springboot.security.service.AnimalService;
import com.demo.springboot.security.service.UserService;


@Controller
public class UserController {

    @Autowired
    private AnimalService animalService;

    @Autowired
    private UserService userService;
    
    @RequestMapping(value = {"/home"}, method = RequestMethod.GET)
    public String homePage(Model model){
        List<Animal> animals = animalService.List();
        model.addAttribute("animals", animals);
        return "user/home";
    }
}
