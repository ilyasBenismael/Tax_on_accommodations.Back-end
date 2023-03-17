package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.Local;
import com.example.taxe_sejour.bean.Trimestre;
import com.example.taxe_sejour.dao.LocalDao;
import com.example.taxe_sejour.dao.TrimestreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrimestreService {
    @Autowired
    private TrimestreDao trimestreDao;

    public Trimestre findByNombreTrim(int nombreTrim) {
        return trimestreDao.findByNombreTrim(nombreTrim);
    }

    public Trimestre findByNombreTrimAndAnnee(int nombreTrim, int annee) {
        return trimestreDao.findByNombreTrimAndAnnee(nombreTrim, annee);
    }
}
