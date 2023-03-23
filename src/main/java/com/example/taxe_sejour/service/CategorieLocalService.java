package com.example.taxe_sejour.service;


import com.example.taxe_sejour.dao.CategorieLocalDao;
import com.example.taxe_sejour.bean.CategorieLocal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategorieLocalService {

    @Autowired
    private CategorieLocalDao categorieLocalDAO;


    public CategorieLocal findByName(String name) {
        return categorieLocalDAO.findByName(name);
    }

    public int Save(CategorieLocal categorieLocal){
        if (findByCode(categorieLocal.getCode()) !=null){
            return -1;
        }else {
            categorieLocalDAO.save(categorieLocal);
            return 1;
        }
    }


    public CategorieLocal findByCode(String code) {
        return categorieLocalDAO.findByCode(code);
    }

    @Transactional
    public int deleteByCode(String code) {
        return categorieLocalDAO.deleteByCode(code);
    }

    public List<CategorieLocal> findAll() {
        return categorieLocalDAO.findAll();
    }
}
