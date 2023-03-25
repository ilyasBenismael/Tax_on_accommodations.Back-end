package com.example.taxe_sejour.service;


import com.example.taxe_sejour.bean.*;
import com.example.taxe_sejour.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Service
public class TaxeTrimService {


    @Autowired
    TaxeTrimDao taxeTrimDao;

    @Autowired
    RedevableService redevableService;

    @Autowired
    LocalService localService;

    @Autowired
    TrimestreService trimestreService;
    @Autowired
    TauxTrimService tauxTrimService;

    @Autowired
    CategorieLocalService categorieLocalService;


    public TaxeTrim findByNombreTrimAndAnneeAndLocalRef(int trim, int annee, String ref) {
        return taxeTrimDao.findByNombreTrimAndAnneeAndLocalRef(trim, annee, ref);
    }

    public TaxeTrim findByRef(String ref) {
        return taxeTrimDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return taxeTrimDao.deleteByRef(ref);
    }

    public List<TaxeTrim> findAll() {
        return taxeTrimDao.findAll();
    }

    public List<TaxeTrim> findByRedevableCin(String cin) {
        return taxeTrimDao.findByRedevableCin(cin);
    }

    public List<TaxeTrim> findByTauxTrimRef(String ref) {
        return taxeTrimDao.findByTauxTrimRef(ref);
    }

    public List<TaxeTrim> findByLocalRef(String ref) {
        return taxeTrimDao.findByLocalRef(ref);
    }


    public int save(TaxeTrim taxeTrim) {
        if (findByRef(taxeTrim.getRef()) != null) {
            return -1;
        } else {
            taxeTrimDao.save(taxeTrim);
            return 1; } }










//we get inforecu from the front-end et on cree le taxe trimestrielle du local et on le sauvegrade

 public int payer(InfoRecuTrim infoRecuTrim){

TaxeTrim taxeTrim = null;

Redevable redevable = redevableService.findByCin(infoRecuTrim.getCin());
Local local =localService.findByRef(infoRecuTrim.getReferenceLocal());
Trimestre trimestre = trimestreService.findByNombreTrim(infoRecuTrim.getTrim());
CategorieLocal categorieLocal = categorieLocalService.findByName(infoRecuTrim.getCategorieLocalName());

if (redevable==null){
    return -1;
}
if (local==null){
         return -2;
     }

     if (trimestre==null){
         return -3;
     }

     if (categorieLocal==null){
         return -4;
     }

//recevoir le taux a partir de categorie et l'annee
TauxTrim tauxTrim=tauxTrimService.findByDateAppMinLessThanAndDateAppMaxGreaterThanAndCategorieLocalCode
        (infoRecuTrim.getAnnee(), infoRecuTrim.getAnnee(), categorieLocal.getCode());

     if (tauxTrim==null){
         return -5;
     }

long milisRetard = infoRecuTrim.getDatePresentation().getTime() - trimestre.getDateMax().getTime();
//convertir ms en mois
int nombreMois = (int) TimeUnit.MILLISECONDS.toDays(milisRetard)/30;

double montantBase = infoRecuTrim.getNombreNuite() * tauxTrim.getMontantNuit();
double montantTotal=montantBase;
double montantRetard=0;
double montantMajoration=0;

if(nombreMois>0){
    {  montantMajoration = (nombreMois - 1)*tauxTrim.getMontantMajoration()*montantBase;
        montantRetard = tauxTrim.getMontantRetard()*montantBase;
        montantTotal = montantBase + montantMajoration + montantRetard; }
}



taxeTrim.setTrim(trimestre);
taxeTrim.setAnnee(infoRecuTrim.getAnnee());
taxeTrim.setCategorieLocal(categorieLocal);
taxeTrim.setDatePresentation(infoRecuTrim.getDatePresentation());
taxeTrim.setLocal(local);
taxeTrim.setMontantBase(montantBase);
taxeTrim.setMontantMajoration(montantMajoration);
taxeTrim.setMontantRetard(montantRetard);
taxeTrim.setMontantTotal(montantTotal);
taxeTrim.setNombreMoisRetard(nombreMois);
taxeTrim.setNombreNuite(infoRecuTrim.getNombreNuite());

return save(taxeTrim);




    }


}
