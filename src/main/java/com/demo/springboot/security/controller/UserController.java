package com.demo.springboot.security.controller;

import com.demo.springboot.security.model.Animal;
import com.demo.springboot.security.model.User;
import com.demo.springboot.security.service.AnimalService;
import com.demo.springboot.security.service.UserDetailServiceImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class UserController {
  @Autowired
  private AnimalService animalService;

  @Autowired
  private UserDetailServiceImpl userService;

  @RequestMapping(value = { "/home" }, method = RequestMethod.GET)
  public String homePage(Model model) {
    List<Animal> animals = animalService.List();
    model.addAttribute("animals", animals);
    return "user/home";
  }

  @RequestMapping(value = { "/editUser" }, method = RequestMethod.GET)
  public String register(Model model) {
    // model.addAttribute("user", new User());
    return "editUser";
  }

  @RequestMapping(value = { "/editUser" }, method = RequestMethod.POST)
  public String updateName(
    Authentication authentication,
    @RequestParam("id") Long id,
    @RequestParam("pic") MultipartFile pic,
    @RequestParam("firstName") String firstName,
    @RequestParam("lastName") String lastName,
    @RequestParam("email") String email,
    @RequestParam("password") String password,
    @RequestParam("CEP") String CEP,
    @RequestParam("mobile") String mobile
  ) {
    userService.updateUser(
      id,
      pic,
      firstName,
      lastName,
      email,
      password,
      CEP,
      mobile
    );

    String url = "/";
    Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
    List<String> roles = new ArrayList<String>();
    for (GrantedAuthority a : authorities) {
      roles.add(a.getAuthority());
    }
    if (roles.contains("ADMIN")) {
      url = "/admin/dashboard";
    } else if (roles.contains("USER")) {
      url = "/home";
    }
    return url;
  }
}
