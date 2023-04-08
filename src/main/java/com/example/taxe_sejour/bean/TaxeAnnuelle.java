package com.example.taxe_sejour.bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "TaxeAnnuelle")
public class TaxeAnnuelle {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ref;
    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private Trimestre trim;
    @ManyToOne
    private Local local;
    @ManyToOne
    private CategorieLocal categorieLocal;
    private int montantBase;
    private  int annee;
    private float total;
    private float majoration;

    public float getMajoration() {
        return majoration;
    }

    public void setMajoration(float majoration) {
        this.majoration = majoration;
    }

    public TaxeAnnuelle() {

    }

     public TaxeAnnuelle(Redevable redevable,Local local,CategorieLocal categorieLocal,int annee,float total){
        this.redevable = redevable;
        this.local = local;
        this.categorieLocal = categorieLocal;
        this.annee = annee;
        this.total = total;
    }


    public CategorieLocal getCategorieLocal() {
        return categorieLocal;
    }

    public void setCategorieLocal(CategorieLocal categorieLocal) {
        this.categorieLocal = categorieLocal;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public int getMontantBase() {
        return montantBase;
    }

    public void setMontantBase(int montantBase) {
        this.montantBase = montantBase;
    }

    public Trimestre getTrim() {
        return trim;
    }

    public void setTrim(Trimestre trim) {
        this.trim = trim;
    }

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public Redevable getRedevable() {
        return redevable;
    }

    public void setRedevable(Redevable redevable) {
        this.redevable = redevable;
    }


    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
}
