package com.demo.springboot.security.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "animal")
public class Animal {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL, optional = false)
  @JoinColumn(name = "partner_id")
  private User user;
  
  @Column(name = "porte")
  private String porte;

  @NotNull(message = "Last Name cannot be empty")
  @Column(name = "nome")
  private String nome;

  @NotNull(message = "Last Name cannot be empty")
  @Column(name = "raca")
  private String raca;

  @NotNull(message = "Last Name cannot be empty")
  @Column(name = "sexo")
  private String sexo;

  @NotNull(message = "Last Name cannot be empty")
  @Column(name = "estado")
  private String estado;

  @NotNull(message = "Last Name cannot be empty")
  @Column(name = "cidade")
  private String cidade;

  @NotNull(message = "Last Name cannot be empty")
  @Column(name = "tipo")
  private String tipo;

  @NotNull(message = "Last Name cannot be empty")
  @Column(name = "descricao")
  private String descricao;

  @NotNull(message = "Last Name cannot be empty")
  @Column(name = "data_nasc")
  private String data_nasc;

  @OneToOne(mappedBy = "animal")
  private Adoption adoptions;

  @Lob
  @Column(columnDefinition = "MEDIUMBLOB")
  private String imagem;

  public Long getId() {
    return this.id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getNome() {
    return this.nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getRaca() {
    return this.raca;
  }

  public String getSexo() {
    return this.sexo;
  }

  public void setSexo(String sexo) {
    this.sexo = sexo;
  }

  public String getEstado() {
    return this.estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getCidade() {
    return this.cidade;
  }

  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  public void setRaca(String raca) {
    this.raca = raca;
  }

  public String getDescricao() {
    return this.descricao;
  }

  public void setDescricao(String descricao) {
    this.descricao = descricao;
  }

  public String getTipo() {
    return this.tipo;
  }

  public void setTipo(String tipo) {
    this.tipo = tipo;
  }

  public String getData_nasc() {
    return this.data_nasc;
  }

  public void setData_nasc(String data_nasc) {
    this.data_nasc = data_nasc;
  }

  public String getImagem() {
    return this.imagem;
  }

  public void setImagem(String imagem) {
    this.imagem = imagem;
  }

  public User getUser() {
    return this.user;
  }

  public void setUser(User partner) {
    this.user = partner;
  }

  public String getPorte() {
    return this.porte;
  }

  public void setPorte(String porte) {
    this.porte = porte;
  }

  public Adoption getAdoptions() {
    return this.adoptions;
  }

  public void setAdoptions(Adoption adoptions) {
    this.adoptions = adoptions;
  }
  
}
