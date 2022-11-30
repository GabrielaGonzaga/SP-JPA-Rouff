package com.demo.springboot.security.repository;

import com.demo.springboot.security.model.Adoption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdoptionRepository extends JpaRepository<Adoption, Long> {}
