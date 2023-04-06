package com.example.taxe_sejour.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "infoAnnuelle")
public class InfoAnnuelle {


    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long id;

    private String ref;
    private String referenceLocal;
    private String categorieLocalName;
    private int annee;
    private String cin;
    private String datePresentation;
    private int chiffreAffaire;


    public String getDatePresentation() {
        return datePresentation;
    }

    public void setDatePresentation(String datepPresentation) {
        this.datePresentation = datepPresentation;
    }

    public int getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(int chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
    }



    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getReferenceLocal() {
        return referenceLocal;
    }

    public void setReferenceLocal(String referenceLocal) {
        this.referenceLocal = referenceLocal;
    }

    public String getCategorieLocalName() {
        return categorieLocalName;
    }

    public void setCategorieLocalName(String categorieLocalName) {
        this.categorieLocalName = categorieLocalName;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }


}

