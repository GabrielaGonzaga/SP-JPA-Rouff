package com.demo.springboot.security.service;

import com.demo.springboot.security.model.Adoption;
import com.demo.springboot.security.model.Animal;
import com.demo.springboot.security.model.User;
import com.demo.springboot.security.repository.AdoptionRepository;
import com.demo.springboot.security.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdoptionService {
  @Autowired
  private AdoptionRepository adoptionRepo;

  @Autowired
  private AnimalService animalService;

  @Autowired
  private UserRepository userRepo;

  public List<Adoption> List() {
    return adoptionRepo.findAll();
  }

  public void Save(
    Long animal_id,
    Long adopter_id,
    Long partner_id,
    Boolean status
  ) {
    Animal animal = animalService.animalfindById(animal_id);
    User adopter = userRepo.findById(adopter_id).get();
    User partner = userRepo.findById(partner_id).get();

    Adoption obj = new Adoption();
    obj.setAnimal(animal);
    obj.setUser(partner);
    obj.setUsers(adopter);
    obj.setStatus(status);

    adoptionRepo.save(obj);
  }

  public void delete(Long id) {
    adoptionRepo.deleteById(id);
  }

  public void updateStatus(Long id, Boolean status) {
    Adoption obj = adoptionRepo.findById(id).get();
    System.out.print("EEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEE" + id);
    System.out.print("CCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCCC" + status);
    System.out.print(
      "DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" + obj.getStatus() + obj.getId()
    );
    

    obj.setStatus(status);

    adoptionRepo.save(obj);
  }
}
