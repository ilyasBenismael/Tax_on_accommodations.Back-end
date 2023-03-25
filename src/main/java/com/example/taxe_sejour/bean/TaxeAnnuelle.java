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



    private Date datePresentation;


    private Double chiffreAffaire;



    private boolean isPaid;

    @ManyToOne
    private Trimestre trim;//Nombre trim

    @ManyToOne
    private Local local;//Local declaree pendant les trim

    @ManyToOne
    private TauxTrim taxeTrim;

    @ManyToOne
    private Redevable redevable;//les Infos de User

    @ManyToOne
    private CategorieLocal categorieLocal;//Categorie du local



    public TauxTrim getTaxeTrim() {
        return taxeTrim;
    }

    public void setTaxeTrim(TauxTrim taxeTrim) {
        this.taxeTrim = taxeTrim;
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

    public CategorieLocal getCategorieLocal() {
        return categorieLocal;
    }

    public void setCategorieLocal(CategorieLocal categorieLocal) {
        this.categorieLocal = categorieLocal;
    }

    public Date getDatePresentation() {
        return datePresentation;
    }

    public void setDatePresentation(Date datePresentation) {
        this.datePresentation = datePresentation;
    }


    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public Double getChiffreAffaire() {
        return chiffreAffaire;
    }

    public void setChiffreAffaire(Double chiffreAffaire) {
        this.chiffreAffaire = chiffreAffaire;
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
}
