package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.Secteur;
import com.example.taxe_sejour.dao.SecteurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SecteurService {
    @Autowired
    private SecteurDao secteurDao;

    public int save (Secteur secteur) {
        if (findByCode(secteur.getCode()) != null) {
            return -1;
        }else {
            secteurDao.save(secteur);
            return 1;
        }
    }


    public Secteur findByCode(String codeS) {
        return secteurDao.findByCode(codeS);
    }

    @Transactional
    public int deleteByCode(String codeS) {
        return secteurDao.deleteByCode(codeS);
    }

    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }
}
