package com.example.taxe_sejour.bean;

import jakarta.persistence.*;


@Entity
@Table(name = "CategorieLocal")
public class CategorieLocal {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Long id;
    private String libelle;
    private String code;


    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
