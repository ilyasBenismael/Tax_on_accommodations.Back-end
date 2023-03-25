package com.example.taxe_sejour.bean;


import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "Trimestre")
public class Trimestre {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;
    private int nombreTrim;

    private Date dateMax;
    private Date dateMin;



    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNombreTrim() {
        return nombreTrim;
    }

    public void setNombreTrim(int nombreTrim) {
        this.nombreTrim = nombreTrim;
    }

    public Date getDateMax() {
        return dateMax;
    }

    public void setDateMax(Date dateMax) {
        this.dateMax = dateMax;
    }

    public Date getDateMin() {
        return dateMin;
    }

    public void setDateMin(Date dateMin) {
        this.dateMin = dateMin;
    }
}
