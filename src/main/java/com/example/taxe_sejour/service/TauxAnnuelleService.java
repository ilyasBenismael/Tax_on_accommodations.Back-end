package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.TauxAnnuelle;
import com.example.taxe_sejour.dao.TauxAnnuelleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TauxAnnuelleService {


    @Autowired
    TauxAnnuelleDao tauxAnnuelleDao;

    public TauxAnnuelle findByRef(String ref){return tauxAnnuelleDao.findByRef(ref);}





}
