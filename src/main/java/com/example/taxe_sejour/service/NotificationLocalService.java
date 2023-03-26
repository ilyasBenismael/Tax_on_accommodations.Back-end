package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.*;
import com.example.taxe_sejour.dao.NotificationLocaleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificationLocalService {
    @Autowired
    private NotificationLocaleDao notificationLocaleDao;

    @Autowired
    private LocalService localService;

    @Autowired
    private TaxeTrimService taxeTrimService;

    public int save(NotificationLocale notificationLocale) {
        if (findByRef(notificationLocale.getRef()) != null) {
            return -1;
        } else {
            notificationLocaleDao.save(notificationLocale);
            return 1;
        }
    }


    public NotificationLocale findByRef(String reference) {
        return notificationLocaleDao.findByRef(reference);
    }


    @Transactional
    public int deleteByRef(String ref) {
        return notificationLocaleDao.deleteByRef(ref);
    }


    public int creerNotificationsLocals(Notification notification) {

        List<Local> locals = localService.findByDernierAnneePayeeAndDernierTrimestrePayee(notification.getAnnee(), notification.getTrimestre());

        if(locals==null){
            return -1;
        }

        int r=1;
        for (Local local : locals) {
            Redevable redevable = local.getRedevable();
            NotificationLocale notificationLocale = null;

            if(redevable==null){
            return -2;
            }



            String methodeEstime = "";

            List<Local> neighbours = localService.findByRueCodeAndCategorieLocalCode(
                    local.getRue().getCode(), local.getCategorieLocal().getCode());
            methodeEstime = "Par rue";

            if (neighbours == null) {
                neighbours = localService.findByRueQuartierCodeAndCategorieLocalCode(
                        local.getRue().getQuartier().getCode(), local.getCategorieLocal().getCode());
                methodeEstime = "Par quartier";

                if (neighbours == null) {
                    neighbours = localService.findByRueQuartierSecteurCodeAndCategorieLocalCode(
                            local.getRue().getQuartier().getSecteur().getCode(), local.getCategorieLocal().getCode());
                    methodeEstime = "Par secteur";

                    if (neighbours == null) {
                        return -3;
                    }
                }
            }

            int n=0;
            double total=0;
            for (Local localNeighbour : neighbours) {
                TaxeTrim taxeTrim = taxeTrimService.findByNombreTrimAndAnneeAndLocalRef
                        (notification.getTrimestre(), notification.getAnnee(), localNeighbour.getRef());
                if(taxeTrim!=null){
                    n++;
                    total+=taxeTrim.getMontantBase();
                } }

            if(n==0){
                return -4; }

            double montantEstime = total/n;

            notificationLocale.setMethodEstime(methodeEstime);
            notificationLocale.setMtBaseEstime(montantEstime);
            notificationLocale.setNotification(notification);
            notificationLocale.setRef(""+notification.getNumero()+(r++));
            notificationLocale.setLocale(local);
            notificationLocale.setRedevable(redevable);
            save(notificationLocale);
        }
        return 1;

    }


}
