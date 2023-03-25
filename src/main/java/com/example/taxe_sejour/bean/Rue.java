package com.example.taxe_sejour.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Rue")
public class Rue {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nom;

    private String code;
    private String libelle;
    @ManyToOne
    private Quartier quartier;


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Quartier getQuartier() {
        return quartier;
    }

    public void setQuartier(Quartier quartier) {
        this.quartier = quartier;
    }
}
