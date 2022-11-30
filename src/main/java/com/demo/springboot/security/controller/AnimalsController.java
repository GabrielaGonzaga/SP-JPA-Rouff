package com.demo.springboot.security.controller;

import com.demo.springboot.security.model.Animal;
import com.demo.springboot.security.service.AnimalService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class AnimalsController {
  @Autowired
  private AnimalService animalService;

  // @GetMapping("/home")
  // public String ListAnimalsAdm(Model model) {
  //   List<Animal> animals = animalService.List();
  //   model.addAttribute("animals", animals);
  //   return "home";
  // }

  @RequestMapping("/admin/newAnimal")
  public String NewAnimal(Model model) {
    System.out.println("NewAnimal");
    model.addAttribute("newAnimal", "Novo Animal");
    return "admin/newAnimal";
  }

  @PostMapping("/admin/newAnimal")
  public String newAnimal(
    @RequestParam("file") MultipartFile file,
    @RequestParam("nome") String nome,
    @RequestParam("data_nasc") String data_nasc,
    @RequestParam("raca") String raca,
    @RequestParam("partner_id") Long partner_id,
    @RequestParam("estado") String estado,
    @RequestParam("cidade") String cidade,
    @RequestParam("sexo") String sexo,
    @RequestParam("descricao") String descricao,
    @RequestParam("tipo") String tipo
  ) {
    animalService.Save(
      partner_id,
      file,
      raca,
      data_nasc,
      nome,
      descricao,
      sexo,
      estado,
      cidade,
      tipo
    );
    return "redirect:/admin/animals";
  }

  @GetMapping("/deleteAnimal/{id}")
  public String deleteAnimal(@PathVariable("id") Long id) {
    animalService.delete(id);
    return "redirect:/admin/animals";
  }

  @GetMapping("/findAnimal")
  @ResponseBody
  public Animal findAnimal(Long id ) {
    return animalService.animalfindById(id);
  }

  @PostMapping("/updateAnimal")
  public String updateName(
    @RequestParam("id") Long id,
    @RequestParam("nome") String nome
  ) {
    animalService.updateName(id, nome);
    return "redirect:/admin/animals";
  }

  
  @GetMapping("/admin/animals")
  public String TestListAnimals(Model model) {
    List<Animal> tanimals = animalService.List();
    model.addAttribute("tanimals", tanimals);
    return "admin/animals";
  }

  @GetMapping("/user/home")
  public String ListAnimals(Model model) {
    List<Animal> animals = animalService.List();
    model.addAttribute("animals", animals);
    return "home";
  }

}
