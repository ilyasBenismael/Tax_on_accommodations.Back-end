package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.Secteur;
import com.example.taxe_sejour.dao.SecteurDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecteurService {
    @Autowired
    private SecteurDao secteurDao;

    public int save (Secteur secteur) {
        if (findByCodeS(secteur.getCode()) != null) {
            return -1;
        }else {
            secteurDao.save(secteur);
            return 1;
        }
    }


    public Secteur findByCodeS(String codeS) {
        return secteurDao.findByCodeS(codeS);
    }

    public int deleteByCodeS(String codeS) {
        return secteurDao.deleteByCodeS(codeS);
    }

    public List<Secteur> findAll() {
        return secteurDao.findAll();
    }
}
