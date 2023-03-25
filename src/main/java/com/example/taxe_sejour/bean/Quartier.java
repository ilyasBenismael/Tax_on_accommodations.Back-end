package com.example.taxe_sejour.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Quartier")
public class Quartier {
    @Id@GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String code;
    private String libelle;
    private String nom;
    @ManyToOne
    private Secteur secteur;


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

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }
}
