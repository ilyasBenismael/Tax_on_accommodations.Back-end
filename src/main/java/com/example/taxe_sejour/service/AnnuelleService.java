package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.Annuelle;
import com.example.taxe_sejour.bean.Trimestre;
import com.example.taxe_sejour.dao.AnnuelleDao;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AnnuelleService {

    @Autowired
    private AnnuelleDao annuelleDao;

    public Annuelle findByRef(String ref){return annuelleDao.findByRef(ref);}

    public List<Annuelle> findAll(){return annuelleDao.findAll();}

    public Annuelle findByDateMax(Date dateMax){return annuelleDao.findByDateMax(dateMax);}

    public Annuelle findByDateMin(Date dateMin){return annuelleDao.findByDateMin(dateMin);}

    public Annuelle findByAnnee(int annee){return annuelleDao.findByAnnee(annee);}
    @Transactional
    public int deleteByRef(String ref){return annuelleDao.deleteByRef(ref);}

    public int save(Annuelle annuelle) {
        if (findByRef(annuelle.getRef()) != null) {
            return -1;
        } else {
            annuelleDao.save(annuelle);
            return 1; } }

}
