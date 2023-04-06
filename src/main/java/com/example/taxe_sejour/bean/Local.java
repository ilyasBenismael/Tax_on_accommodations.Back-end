package com.example.taxe_sejour.bean;

import jakarta.persistence.*;

@Entity
public class Local {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String ref;

    private String cin;

    private String categorieLocalName;
    private String rueCode;

    private int dernierAnneeDeclaree;
    private  int dernierAnneePayee;
    private int dernierTrimestrePayee;

    @ManyToOne
    private Redevable redevable;
    @ManyToOne
    private CategorieLocal categorieLocal;
    @ManyToOne
    private Rue rue;




    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCategorieLocalName() {
        return categorieLocalName;
    }

    public void setCategorieLocalName(String categorieLocalName) {
        this.categorieLocalName = categorieLocalName;
    }

    public String getRueCode() {
        return rueCode;
    }

    public void setRueCode(String rueCode) {
        this.rueCode = rueCode;
    }

    public int getDernierAnneeDeclaree() {
        return dernierAnneeDeclaree;
    }

    public void setDernierAnneeDeclaree(int dernierAnneeDeclaree) {
        this.dernierAnneeDeclaree = dernierAnneeDeclaree;
    }

    public int getDernierAnneePayee() {
        return dernierAnneePayee;
    }

    public void setDernierAnneePayee(int dernierAnneePayee) {
        this.dernierAnneePayee = dernierAnneePayee;
    }

    public int getDernierTrimestrePayee() {
        return dernierTrimestrePayee;
    }

    public void setDernierTrimestrePayee(int dernierTrimestrePayee) {
        this.dernierTrimestrePayee = dernierTrimestrePayee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
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

    public Rue getRue() {
        return rue;
    }

    public void setRue(Rue rue) {
        this.rue = rue;
    }


}
