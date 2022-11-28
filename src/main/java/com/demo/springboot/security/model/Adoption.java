package com.demo.springboot.security.model;

public class Adoption {
  private Long id;

  private Long animal_id;

  private Long partner_id;

  private String date;

  private Long adopter_id;
}
// @OneToOne(cascade = CascadeType.ALL, optional = false)
// @JoinColumn(name = "user_id")
