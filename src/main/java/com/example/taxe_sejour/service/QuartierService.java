package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.Quartier;
import com.example.taxe_sejour.dao.QuartierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuartierService {
    @Autowired
    private QuartierDao quartierDao;


    public int save (Quartier quartier) {
        if (findByCodeQ(quartier.getCode()) != null) {
            return -1;
        }else{
            quartierDao.save(quartier);
            return 1;
        }
    }


    public Quartier findByCodeQ(String codeQ) {
        return quartierDao.findByCodeQ(codeQ);
    }

    @Transactional
    public int deleteByCodeQ(String codeQ) {
        return quartierDao.deleteByCodeQ(codeQ);
    }

    public List<Quartier> findAll() {
        return quartierDao.findAll();
    }

    public List<Quartier> findBySecteurCodeS(String codeS) {
        return quartierDao.findBySecteurCodeS(codeS);
    }
}
