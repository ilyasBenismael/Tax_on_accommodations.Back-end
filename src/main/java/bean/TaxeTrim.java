package bean;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class TaxeTrim {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String ref;

    private Date datePresentation;

    private int annee;

    private int trim;

    @ManyToOne
    private Local local;

    @ManyToOne
    private TauxTrim tauxTrim;

    @ManyToOne
    private Redevable redevable;

    @ManyToOne
    private CategorieLocal categorieLocal;
    private int nombreNuite;
    private int nombreMoisRetard;
    private double montantBase;
    private double montantRetard;
    private double montantMajoration;
    private double montantTotal;

    private float moisRetard;


    public Date getDatePresentation() {
        return datePresentation;
    }

    public void setDatePresentation(Date datePresentation) {
        this.datePresentation = datePresentation;
    }

    public float getMoisRetard() {
        return moisRetard;
    }

    public void setMoisRetard(float moisRetard) {
        this.moisRetard = moisRetard;
    }

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

    public Local getLocal() {
        return local;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public TauxTrim getTauxTrim() {
        return tauxTrim;
    }

    public void setTauxTrim(TauxTrim tauxTrim) {
        this.tauxTrim = tauxTrim;
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


    public void setTrim(int trim) {
        this.trim = trim;
    }

    public int getTrim() {
        return trim;
    }




    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public int getNombreNuite() {
        return nombreNuite;
    }

    public void setNombreNuite(int nombreNuite) {
        this.nombreNuite = nombreNuite;
    }

    public int getNombreMoisRetard() {
        return nombreMoisRetard;
    }

    public void setNombreMoisRetard(int nombreMoisRetard) {
        this.nombreMoisRetard = nombreMoisRetard;
    }

    public double getMontantBase() {
        return montantBase;
    }

    public void setMontantBase(double montantBase) {
        this.montantBase = montantBase;
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

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }
}
