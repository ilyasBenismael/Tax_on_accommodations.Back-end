package com.example.taxe_sejour.service;


import com.example.taxe_sejour.bean.InfoAnnuelle;
import com.example.taxe_sejour.dao.InfoAnnuelleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InfoAnnuelleService {

    @Autowired
    private InfoAnnuelleDao infoAnnuelleDao;

    public InfoAnnuelle findByRef(String ref) {
        return infoAnnuelleDao.findByRef(ref);
    }

    @Transactional
    public int deleteByRef(String ref) {
        return infoAnnuelleDao.deleteByRef(ref);
    }




    public int save(InfoAnnuelle infoAnnuelle) {
        if(findByRef(infoAnnuelle.getRef())!=null){
            return -1;
        }else{
            infoAnnuelleDao.save(infoAnnuelle);
            return 1;
        }

    }


}
