package com.example.taxe_sejour.bean;

import jakarta.persistence.*;

import java.util.Date;


@Entity
@Table(name = "InfoRecuTrim")
    public class InfoRecuTrim {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String ref;
        private String referenceLocal;
        private String categorieLocalName;
        private int annee;
        private String cin;
        private int trim;
        private int nombreNuite;
        private Date datePresentation;




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getTrim() {
        return trim;
    }

    public void setTrim(int trim) {
        this.trim = trim;
    }

    public int getNombreNuite() {
        return nombreNuite;
    }

    public void setNombreNuite(int nombreNuite) {
        this.nombreNuite = nombreNuite;
    }

    public Date getDatePresentation() {
        return datePresentation;
    }

    public void setDatePresentation(Date datePresentation) {
        this.datePresentation = datePresentation;
    }


    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }
}
