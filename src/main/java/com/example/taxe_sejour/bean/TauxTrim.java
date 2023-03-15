package com.example.taxe_sejour.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class TauxTrim {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private Date dateAppMin;
    private Date dateAppMax;
    private double montantNuit;
    private double montantRetard;
    private double montantMajoration;

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    @ManyToOne
    private CategorieLocal categorieLocal;

    public Date getDateAppMin() {
        return dateAppMin;
    }

    public void setDateAppMin(Date dateAppMin) {
        this.dateAppMin = dateAppMin;
    }

    public Date getDateAppMax() {
        return dateAppMax;
    }

    public void setDateAppMax(Date dateAppMax) {
        this.dateAppMax = dateAppMax;
    }

    public double getMontantNuit() {
        return montantNuit;
    }

    public void setMontantNuit(double montantNuit) {
        this.montantNuit = montantNuit;
    }

    public double getMontantRetard() {
        return montantRetard;
    }

    public void setMontantRetard(double montantRetard) {
        this.montantRetard = montantRetard;
    }

    public double getMontantMajoration() {
        return montantMajoration;
    }

    public void setMontantMajoration(double montantMajoration) {
        this.montantMajoration = montantMajoration;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public CategorieLocal getCategorieLocal() {
        return categorieLocal;
    }

    public void setCategorieLocal(CategorieLocal categorieLocal) {
        this.categorieLocal = categorieLocal;
    }





}

