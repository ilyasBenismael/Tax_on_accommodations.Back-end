package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.Local;
import com.example.taxe_sejour.bean.TaxeTrim;
import com.example.taxe_sejour.bean.Trimestre;
import com.example.taxe_sejour.dao.LocalDao;
import com.example.taxe_sejour.dao.TrimestreDao;
import org.springframework.beans.factory.annotation.Autowired;
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



    public Trimestre findByRef(String ref) {
        return trimestreDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return trimestreDao.deleteByRef(ref);
    }

    public int save(Trimestre trimestre) {
        if (findByRef(trimestre.getRef()) != null) {
            return -1;
        } else {
            trimestreDao.save(trimestre);
            return 1; } }
}
