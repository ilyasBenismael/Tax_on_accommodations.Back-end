package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.InfoRecuTrim;
import com.example.taxe_sejour.bean.Local;
import com.example.taxe_sejour.dao.InfoRecuTrimDao;
import com.example.taxe_sejour.dao.LocalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoRecuTrimService {

    @Autowired
   private InfoRecuTrimDao infoRecuTrimDao;

    public InfoRecuTrim findByRef(String ref) {
        return infoRecuTrimDao.findByRef(ref);
    }

    public int deleteByRef(String ref) {
        return infoRecuTrimDao.deleteByRef(ref);
    }



    public int save(InfoRecuTrim infoRecuTrim) {
        if(findByRef(infoRecuTrim.getRef())!=null){
            return -1;
        }else{
            infoRecuTrimDao.save(infoRecuTrim);
            return 1;
        }

    }

}
