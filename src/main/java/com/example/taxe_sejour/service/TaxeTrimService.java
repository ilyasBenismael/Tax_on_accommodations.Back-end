package com.example.taxe_sejour.service;


import com.example.taxe_sejour.bean.*;
import com.example.taxe_sejour.dao.LocalDao;
import com.example.taxe_sejour.dao.TaxeTrimDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.concurrent.TimeUnit;

import java.util.Properties;


@Service
public class TaxeTrimService{


    @Autowired
    TaxeTrimDao taxeTrimDao;



    @Autowired
    LocalDao localDao;

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
    public int deleteByLocalRef(String ref) {
        return taxeTrimDao.deleteByLocalRef(ref);
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
            return -10;
        } else {
            taxeTrimDao.save(taxeTrim);
            return 1;
        }
    }








//we get inforecu from the front-end et on cree le taxe trimestrielle du local et on le sauvegrade
    public int payer(InfoRecuTrim infoRecuTrim) {

        TaxeTrim taxeTrim = new TaxeTrim();

//get infos and test
        Redevable redevable = redevableService.findByCin(infoRecuTrim.getCin());
        Local local = localService.findByRef(infoRecuTrim.getReferenceLocal());
        Trimestre trimestre = trimestreService.findByNombreTrimAndAnnee(infoRecuTrim.getTrim(), infoRecuTrim.getAnnee());
        CategorieLocal categorieLocal = categorieLocalService.findByName(infoRecuTrim.getCategorieLocalName());

        if (redevable == null) {
            return -1;
        }

        if (local == null) {
            return -2;
        }

        if (trimestre == null) {
            return -3;
        }

        if (categorieLocal == null) {
            return -4;
        }

        if(!(local.getRedevable().getCin().equals(redevable.getCin()))){
            return -5;
        }

        //si le taxe est deja payee
        if(findByNombreTrimAndAnneeAndLocalRef(infoRecuTrim.getTrim(),
                infoRecuTrim.getAnnee(), infoRecuTrim.getReferenceLocal())!=null){
            return -6;
        }


       // si le taxe precedent est payee
        if(infoRecuTrim.getTrim()==1 && infoRecuTrim.getAnnee()==2015){}else {
            int annee1;
            int trim1;

            if (infoRecuTrim.getTrim() == 1) {
                annee1 = infoRecuTrim.getAnnee() - 1;
                trim1 = 4;
            } else {
                annee1 = infoRecuTrim.getAnnee();
                trim1 = infoRecuTrim.getTrim() - 1;
            }

        if(findByNombreTrimAndAnneeAndLocalRef(trim1, annee1, infoRecuTrim.getReferenceLocal())==null){
            return -7;
        }  }



//convertir datepresentation et le retard en mois
//        try {
//            String datepres = infoRecuTrim.getDatepres();
//            infoRecuTrim.setDatePresentation(new SimpleDateFormat("dd/MM/yyyy").parse(datepres));
//
//
//        } catch (Exception e) {
//            return -8;
//        }


 //convertir les ms en mois
        long milisRetard = infoRecuTrim.getDatePresentation().getTime() - trimestre.getDateMax().getTime();
       int nombreMois = (int) TimeUnit.MILLISECONDS.toDays(milisRetard) / 30;

//get taux
        TauxTrim tauxTrim = tauxTrimService.findByDateAppMinLessThanAndDateAppMaxGreaterThanAndCategorieLocalCode
                (infoRecuTrim.getDatePresentation(), infoRecuTrim.getDatePresentation(), categorieLocal.getCode());
        if (tauxTrim == null) {
            return -9;
        }


//calcul des montants
        double montantBase = infoRecuTrim.getNombreNuite() * tauxTrim.getMontantNuit();
        double montantTotal = montantBase;
        double montantRetard = 0;
        double montantMajoration = 0;

        if (nombreMois > 0) {
            {
                montantMajoration = (nombreMois - 1) * tauxTrim.getMontantMajoration() * montantBase;
                montantRetard = tauxTrim.getMontantRetard() * montantBase;
                montantTotal = montantBase + montantMajoration + montantRetard; }
        }else{
            nombreMois =0;
        }



//mise a jour du local
            local.setCategorieLocal(categorieLocal);
            local.setDernierTrimestrePayee(infoRecuTrim.getTrim());
            local.setDernierAnneePayee(infoRecuTrim.getAnnee());
            localDao.save(local);
//hh


/////////////////////////////////////
        taxeTrim.setRef(infoRecuTrim.getRef());
        taxeTrim.setDatePresentation(infoRecuTrim.getDatePresentation());
        taxeTrim.setAnnee(infoRecuTrim.getAnnee());
        taxeTrim.setNombreTrim(infoRecuTrim.getTrim());
        taxeTrim.setTrim(trimestre);
        taxeTrim.setLocal(local);
        taxeTrim.setTauxTrim(tauxTrim);
        taxeTrim.setRedevable(redevable);
        taxeTrim.setCategorieLocal(categorieLocal);
        taxeTrim.setNombreNuite(infoRecuTrim.getNombreNuite());
        taxeTrim.setNombreMoisRetard(nombreMois);
        taxeTrim.setMontantBase(montantBase);
        taxeTrim.setMontantMajoration(montantMajoration);
        taxeTrim.setMontantRetard(montantRetard);
        taxeTrim.setMontantTotal(montantTotal);

        taxeTrim.setCin(redevable.getCin());
        taxeTrim.setLocalRef(local.getRef());
        taxeTrim.setCategorieName(categorieLocal.getName().toString());
        taxeTrim.setNombreTrim(infoRecuTrim.getTrim());
        taxeTrim.setNombreNuite(infoRecuTrim.getNombreNuite());


        return save(taxeTrim);
    }


}
