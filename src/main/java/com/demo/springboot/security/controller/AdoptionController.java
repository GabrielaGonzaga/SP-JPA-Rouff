package com.demo.springboot.security.controller;

import java.util.List;
import java.util.Optional;

import com.demo.springboot.security.model.Adoption;
import com.demo.springboot.security.model.Animal;
import com.demo.springboot.security.model.Solicitation;
import com.demo.springboot.security.model.User;
import com.demo.springboot.security.service.AdoptionService;
import com.demo.springboot.security.service.AnimalService;
import com.demo.springboot.security.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdoptionController {
  @Autowired
  private AdoptionService adoptionService;

  @GetMapping("/admin/solicitations")
  public String Solicitations(Model model) {
    List<Adoption> solicitations = adoptionService.List();
    model.addAttribute("solicitations", solicitations);
    return "admin/solicitations";
  }

  @GetMapping("/user/mySolicitations")
  public String mySolicitations(Model model) {
    List<Adoption> mySolicitations = adoptionService.List();
    model.addAttribute("mySolicitations", mySolicitations);
    return "user/mySolicitations";
  }

  @RequestMapping("/user/newSolicitation")
  public String NewSoli(Model model) {
    System.out.println("newSolicitation");
    model.addAttribute("newSolicitation", "newSolicitation");
    return "user/newSolicitation";
  }

  @PostMapping("/user/newSolicitation")
  public String newSolicitation(
      @RequestParam("animal_id") Long animal_id,
      @RequestParam("adopter_id") Long adopter_id,
      @RequestParam("partner_id") Long partner_id,
      @RequestParam("status") Boolean status) {
    adoptionService.Save(
        animal_id,
        adopter_id,
        partner_id,
        status);
    return "redirect:user/mySolicitations";
  }

  @GetMapping("/delSolicitation")
  public String deleteAnimal(@PathVariable("id") Long id) {
    adoptionService.delete(id);
    return "redirect:/user/mySolicitations";
  }

  @PostMapping("/setStatus{id}")
  public String setStatus(
      @RequestParam("id") Long id,
      @RequestParam("status") Boolean status) {
    adoptionService.updateStatus(id, status);
    return "redirect:/admin/solicitations";
  }


  // @GetMapping("/user/mySolicitations")
  // public String mySolicitations(@PathVariable("id") Long id, Model model) {
  // Optional<Adoption> mySolicitations = adoptionService.adfindById(id);
  // model.addAttribute("mySolicitations", mySolicitations);

  // return "/user/mySolicitations";
  // }

}
