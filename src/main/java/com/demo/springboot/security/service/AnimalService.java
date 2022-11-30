package com.demo.springboot.security.service;

import com.demo.springboot.security.model.Animal;
import com.demo.springboot.security.model.User;
import com.demo.springboot.security.repository.AnimalRepository;
import com.demo.springboot.security.repository.UserRepository;

import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

@Service
public class AnimalService {

    @Autowired
    private AnimalRepository animalRepo;
    
    @Autowired
    private UserRepository userRepo;

    public List<Animal> List() {
        return animalRepo.findAll();
    }
    
    public Animal animalfindById(Long id){
        return animalRepo.findById(id).get();
    }

    public void Save(
        Long partner_id, 
        MultipartFile file,
        String raca, 
        String data_nasc, 
        String nome, 
        String descricao, 
        String sexo, 
        String estado, 
        String cidade, 
        String tipo
    ) {
        Animal obj = new Animal();
        String fileName = StringUtils.cleanPath(file.getOriginalFilename());
        if (fileName.contains("..")) {
            System.out.println("not a a valid file");
        }
        try {
            obj.setImagem(Base64.getEncoder().encodeToString(file.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        User partner = userRepo.findById(partner_id).get();

        obj.setUser(partner);
        obj.setNome(nome);
        obj.setRaca(raca);
        obj.setEstado(estado);
        obj.setCidade(cidade);
        obj.setSexo(sexo);
        obj.setTipo(tipo);
        obj.setData_nasc(data_nasc);
        obj.setDescricao(descricao);

        animalRepo.save(obj);
    }

    public void delete(Long id){
    	animalRepo.deleteById(id);
    }
   
    public void updateName(Long id ,String nome){
        Animal obj = new Animal();

    	obj = animalRepo.findById(id).get();
    	obj.setNome(nome);
    	animalRepo.save(obj);    
    }

}
