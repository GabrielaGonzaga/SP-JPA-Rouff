package com.demo.springboot.security.model;

import java.time.LocalDateTime;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "adoption")
public class Adoption {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "animal_id")
  private Animal animal;

  @OneToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "partner_id")
  private User user;

  @OneToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "adopter_id")
  private User users;

  @CreationTimestamp
  @Column(name = "created_at", updatable = false)
  private LocalDateTime createdAt;

  @Column(name = "status", updatable = false)
  private Boolean status;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Animal getAnimal() {
    return this.animal;
  }

  public void setAnimal(Animal animal) {
    this.animal = animal;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User adopter) {
    this.user = adopter;
  }

  public User getUsers() {
    return this.users;
  }

  public void setUsers(User partner) {
    this.users = partner;
  }

  public LocalDateTime getCreatedAt() {
    return this.createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public Boolean isStatus() {
    return this.status;
  }

  public Boolean getStatus() {
    return this.status;
  }

  public void setStatus(Boolean status) {
    this.status = status;
  }


}