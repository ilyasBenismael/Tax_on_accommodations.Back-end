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
       if (findByCode(rue.getCode()) != null) {
          return -1;
       }else {
           rueDao.save(rue);
           return 1;
       }
   }


    public Rue findByCode(String codeR) {
        return rueDao.findByCode(codeR);
    }

    @Transactional
    public int deleteByCode(String codeR) {
        return rueDao.deleteByCode(codeR);
    }

    public List<Rue> findAll() {
        return rueDao.findAll();
    }

    public List<Rue> findByQuartierCode(String codeQ) {
        return rueDao.findByQuartierCode(codeQ);
    }
}
