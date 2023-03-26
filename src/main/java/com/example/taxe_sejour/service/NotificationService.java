package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.Notification;
import com.example.taxe_sejour.dao.NotificationDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NotificationService {
    @Autowired
    private NotificationDao notificationDao;



    public int save (Notification notification) {
        if (findByAnneeAndTrimestre(notification.getAnnee(), notification.getTrimestre()) != null) {
            return -1;
        }else{
            notificationDao.save(notification);
            return 1;
        }
    }

    public Notification findByAnneeAndTrimestre(int annee, int trimestre) {
        return notificationDao.findByAnneeAndTrimestre(annee, trimestre);
    }

    @Transactional
    public int deleteByAnneeAndTrimestre(int annee, int trimestre) {
        return notificationDao.deleteByAnneeAndTrimestre(annee, trimestre);
    }




}
