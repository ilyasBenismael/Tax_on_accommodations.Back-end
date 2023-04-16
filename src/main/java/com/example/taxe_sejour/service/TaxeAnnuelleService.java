package com.example.taxe_sejour.service;


import com.example.taxe_sejour.bean.*;
import com.example.taxe_sejour.dao.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class TaxeAnnuelleService {

    @Autowired
    TaxeAnnuelleDao taxeAnnuelleDao;

    @Autowired
    InfoAnnuelleService infoAnnuelleService;


    @Autowired
    AnnuelleService annuelleService;

    @Autowired
    RedevableDao redevableService;

    @Autowired
    LocalDao localService;

    @Autowired
    TauxAnnuelleService tauxAnnuelleService;

    @Autowired
    TaxeTrimService taxeTrimService;

    @Autowired
    TaxeTrimDao taxeTrimDao;

    @Autowired
    CategorieLocalDao categorieLocalService;

    //----------
    public TaxeAnnuelle findByRedevableCin(String cin) {
        return taxeAnnuelleDao.findByRedevableCin(cin);
    }

    public List<TaxeAnnuelle> findByLocalRef(String ref) {
        return taxeAnnuelleDao.findByLocalRef(ref);
    }

    public TaxeAnnuelle findByLocalRefAndAnneeAndRedevableCin(String ref,int annee,String cin){
        return taxeAnnuelleDao.findByLocalRefAndAnneeAndRedevableCin(ref,annee,cin);
    }
    //----------
    //Basics
    public TaxeAnnuelle findByRef(String ref) {
        return taxeAnnuelleDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return taxeAnnuelleDao.deleteByRef(ref);
    }

    public List<TaxeAnnuelle> findAll() {
        return taxeAnnuelleDao.findAll();
    }

    public int save(TaxeAnnuelle taxeAnnuelle) {
        if (findByRef(taxeAnnuelle.getRef()) != null) {
            return -1;
        } else {
            taxeAnnuelleDao.save(taxeAnnuelle);
            return 1; } }
    //Basics




    //Payement Methode

    public float payement(InfoAnnuelle infoAnnuelle) {

        TaxeAnnuelle taxeAnnuelle = new TaxeAnnuelle();

        Annuelle annuelle = annuelleService.findByAnnee(infoAnnuelle.getAnnee());

        //----------------
        Local local = localService.findByRef(infoAnnuelle.getReferenceLocal());
        if (local == null) {
            return -1;
        }
        //---------------
        Redevable redevable = redevableService.findByCin(infoAnnuelle.getCin());
        if (redevable == null) {
            return -2;
        }
        //----------------
        CategorieLocal categorieLocal = categorieLocalService.findByName(infoAnnuelle.getCategorieLocalName());
        if (categorieLocal == null) {
            return -3;
        }
        //-----------------
        if(taxeAnnuelle.getRedevable() == redevable && taxeAnnuelle.getAnnee() == infoAnnuelle.getAnnee() && taxeAnnuelle.getLocal() == local/*findByLocalRefAndAnneeAndRedevableCin(infoAnnuelle.getRef(), infoAnnuelle.getAnnee(),infoAnnuelle.getCin()) != null*/){
            return -7;
        }
        //-----------------

        TaxeTrim trim1 = taxeTrimService.findByNombreTrimAndAnneeAndLocalRef(1, infoAnnuelle.getAnnee(), infoAnnuelle.getReferenceLocal());
        TaxeTrim trim2 = taxeTrimService.findByNombreTrimAndAnneeAndLocalRef(2, infoAnnuelle.getAnnee(), infoAnnuelle.getReferenceLocal());
        TaxeTrim trim3 = taxeTrimService.findByNombreTrimAndAnneeAndLocalRef(3, infoAnnuelle.getAnnee(), infoAnnuelle.getReferenceLocal());
        TaxeTrim trim4 = taxeTrimService.findByNombreTrimAndAnneeAndLocalRef(4, infoAnnuelle.getAnnee(), infoAnnuelle.getReferenceLocal());

        //-----------------
        //Those Variables Are used For Test only
/*
         String trim1 = "a";
         String trim2 = "a";
         String trim3 = "a";
         String trim4 = "a";
*/
        //------------------

        float total;
        int montantBase = 0;
        taxeAnnuelle.setMontantBase(0);
        taxeAnnuelle.setMajoration(0);
        float majoration;
        //------------------
        Date datePresentation;
        try {
            datePresentation = new SimpleDateFormat("dd/MM/yyy").parse(infoAnnuelle.getDatePresentation());
        } catch (Exception e) {
            return -5;
        }
        //------------------
        if ((datePresentation.getTime() - annuelle.getDateMax().getTime())>0   && trim1 != null && trim2 != null && trim3 != null && trim4 != null ) {
            majoration = 0.5F;
            total = (float) infoAnnuelle.getChiffreAffaire() * majoration + montantBase ;
        } else if ((datePresentation.getTime() - annuelle.getDateMax().getTime()) < 0 && (datePresentation.getTime() - annuelle.getDateMin().getTime()) > 0 && trim1 != null && trim2 != null && trim3 != null && trim4 != null) {
            majoration = taxeAnnuelle.getMajoration();
            total = montantBase + infoAnnuelle.getChiffreAffaire();
        } else {
            return -6;
        }
        //------------------
        taxeAnnuelle.setRef(infoAnnuelle.getRef());
        taxeAnnuelle.setRedevable(redevable);
        taxeAnnuelle.setLocal(local);
        taxeAnnuelle.setCategorieLocal(categorieLocal);
        taxeAnnuelle.setAnnee(infoAnnuelle.getAnnee());
        taxeAnnuelle.setTotal(total);
        taxeAnnuelle.setMajoration(majoration);

        //save(taxeAnnuelle);

        return save(taxeAnnuelle);
    }

}
