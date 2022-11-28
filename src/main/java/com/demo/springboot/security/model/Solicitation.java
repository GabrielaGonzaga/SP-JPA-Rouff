package com.demo.springboot.security.model;


public class Solicitation{

    private Long id;

    private Long animal_id;

    private Long partner_id;

    private String date;

    private Long adopter_id;

    private Boolean status;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAnimal_id() {
        return this.animal_id;
    }

    public void setAnimal_id(Long animal_id) {
        this.animal_id = animal_id;
    }

    public Long getPartner_id() {
        return this.partner_id;
    }

    public void setPartner_id(Long partner_id) {
        this.partner_id = partner_id;
    }

    public String getDate() {
        return this.date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getAdopter_id() {
        return this.adopter_id;
    }

    public void setAdopter_id(Long adopter_id) {
        this.adopter_id = adopter_id;
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
