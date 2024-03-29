package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.Redevable;
import com.example.taxe_sejour.dao.RedevableDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RedevableService {
    @Autowired
    private RedevableDao redevableDao;


    public List<Redevable> findAll() {
        return redevableDao.findAll();
    }

    public Redevable findByCin(String cin) {
        return redevableDao.findByCin(cin);
    }
    @Transactional
    public int deleteByCin(String cin) {
        return redevableDao.deleteByCin(cin);
    }


    public int save(Redevable redevable) {
        if (findByCin(redevable.getCin()) != null) {
            return -1;
        } else {
            redevableDao.save(redevable);
            return 1;
        }
    }


}
