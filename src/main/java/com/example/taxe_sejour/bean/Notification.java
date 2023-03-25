package com.example.taxe_sejour.bean;

import jakarta.persistence.*;

@Entity
@Table(name = "Notification")
public class Notification {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int annee;
    private int trimestre;
    private int numero;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(int trimestre) {
        this.trimestre = trimestre;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
}
