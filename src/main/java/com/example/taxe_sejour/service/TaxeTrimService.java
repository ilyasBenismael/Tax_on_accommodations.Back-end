package com.example.taxe_sejour.service;


import com.example.taxe_sejour.bean.*;
import com.example.taxe_sejour.dao.TaxeTrimDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
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
            return 1;
        }
    }








//we get inforecu from the front-end et on cree le taxe trimestrielle du local et on le sauvegrade
    public int payer(InfoRecuTrim infoRecuTrim) {

        TaxeTrim taxeTrim = new TaxeTrim();

//get infos and test
        Redevable redevable = redevableService.findByCin(infoRecuTrim.getCin());
        Local local = localService.findByRef(infoRecuTrim.getReferenceLocal());
        Trimestre trimestre = trimestreService.findByNombreTrim(infoRecuTrim.getTrim());
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

        if(findByNombreTrimAndAnneeAndLocalRef(infoRecuTrim.getTrim(),
                infoRecuTrim.getAnnee(), infoRecuTrim.getReferenceLocal())!=null){
            return -6;
        }




//convertir datepresentation et le retard en mois
        int nombreMois = 0;
        try {
            String datepres = infoRecuTrim.getDatepres();
            infoRecuTrim.setDatePresentation(new SimpleDateFormat("dd/MM/yyyy").parse(datepres));

            long milisRetard = infoRecuTrim.getDatePresentation().getTime() - trimestre.getDateMax().getTime();
            nombreMois = (int) TimeUnit.MILLISECONDS.toDays(milisRetard) / 30;

        } catch (Exception e) {
            return -6;
        }


//get taux
        TauxTrim tauxTrim = tauxTrimService.findByDateAppMinLessThanAndDateAppMaxGreaterThanAndCategorieLocalCode
                (infoRecuTrim.getDatePresentation(), infoRecuTrim.getDatePresentation(), categorieLocal.getCode());
        if (tauxTrim == null) {
            return -7;
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
                montantTotal = montantBase + montantMajoration + montantRetard;
            }
        }



//mise a jour du local
            local.setCategorieLocal(categorieLocal);
            local.setDernierTrimestrePayee(infoRecuTrim.getTrim());
            localService.deleteByRef(local.getRef());
            localService.save(local);



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

        return save(taxeTrim);


    }


}
