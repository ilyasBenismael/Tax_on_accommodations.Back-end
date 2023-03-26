package com.example.taxe_sejour.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "InfoAnnuelle")
public class InfoAnnuelle {


    @Id  @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ref;
    private String referenceLocal;
    private String categorieLocalName;
    private int annee;
    private String cin;
    private String SdatePresentation;
    private Date datePresentation;


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

    public Date getDatePresentation() {
        return datePresentation;
    }

    public void setDatePresentation(Date datePresentation) {
        this.datePresentation = datePresentation;
    }

    public String getSdatePresentation() {
        return SdatePresentation;
    }

    public void setSdatePresentation(String sdatePresentation) {
        SdatePresentation = sdatePresentation;
    }
}

