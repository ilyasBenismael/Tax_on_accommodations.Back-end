package com.example.taxe_sejour.service;


import com.example.taxe_sejour.bean.TaxeAnnuelle;
import com.example.taxe_sejour.dao.TaxeAnnuelleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TaxeAnnuelleService {

    @Autowired
    TaxeAnnuelleDao taxeAnnuelleDao;

    @Autowired
    RedevableService redevableService;

    @Autowired
    LocalService localService;

    @Autowired
    TrimestreService trimestreService;

    @Autowired
    TauxTrimService taxeTrimService;

    @Autowired
    CategorieLocalService categorieLocalService;


    @Transactional
    public int deleteByLocalRef(String ref) {
        return taxeAnnuelleDao.deleteByLocalRef(ref);
    }

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



    public List<TaxeAnnuelle> findByRedevableCin(String cin) {
        return taxeAnnuelleDao.findByRedevableCin(cin);
    }

    public List<TaxeAnnuelle> findByLocalRef(String ref) {
        return taxeAnnuelleDao.findByLocalRef(ref);
    }


}
