package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.Rue;
import com.example.taxe_sejour.dao.RueDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RueService {
@Autowired
private RueDao rueDao;

   public int save (Rue rue) {
       if (findByCodeR(rue.getCode()) != null) {
          return -1;
       }else {
           rueDao.save(rue);
           return 1;
       }
   }


    public Rue findByCodeR(String codeR) {
        return rueDao.findByCodeR(codeR);
    }

    @Transactional
    public int deleteByCodeR(String codeR) {
        return rueDao.deleteByCodeR(codeR);
    }

    public List<Rue> findAll() {
        return rueDao.findAll();
    }

    public List<Rue> findByQuartierCodeQ(String codeQ) {
        return rueDao.findByQuartierCodeQ(codeQ);
    }
}
