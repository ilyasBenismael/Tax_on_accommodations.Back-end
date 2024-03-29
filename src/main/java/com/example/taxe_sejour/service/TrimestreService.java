package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.Trimestre;
import com.example.taxe_sejour.dao.TrimestreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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


    public Trimestre findByRef(String ref) {
        return trimestreDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return trimestreDao.deleteByRef(ref);
    }

    public List<Trimestre> findAll() {
        return trimestreDao.findAll();
    }

    public int save(Trimestre trimestre) {
        if (findByRef(trimestre.getRef()) != null) {
            return -1;
        } else {
            trimestreDao.save(trimestre);
            return 1; } }
}
