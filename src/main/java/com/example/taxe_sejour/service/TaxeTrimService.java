package com.example.taxe_sejour.service;


import com.example.taxe_sejour.bean.*;
import com.example.taxe_sejour.dao.TaxeTrimDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaxeTrimService {


    @Autowired
    TaxeTrimDao taxeTrimDao;

    public TaxeTrim findByRef(String ref) {
        return taxeTrimDao.findByRef(ref);
    }

    public int DeleteByRef(String ref) {
        return taxeTrimDao.DeleteByRef(ref);
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


 public int payer(Redevable redevable, Local local, int annee, CategorieLocal categorieLocal, TauxTrim tauxTrim, int nbrNuit, int retard){
 TaxeTrim taxeTrim = new TaxeTrim();
 taxeTrim.setAnnee(annee);
 taxeTrim.setCategorieLocal(categorieLocal);
 taxeTrim.setRedevable(redevable);

 //...
     save(taxeTrim);
return 1;


    }


}
