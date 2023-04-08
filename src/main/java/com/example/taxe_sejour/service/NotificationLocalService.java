package com.example.taxe_sejour.service;

import com.example.taxe_sejour.bean.*;
import com.example.taxe_sejour.dao.NotificationDao;
import com.example.taxe_sejour.dao.NotificationLocaleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NotificationLocalService {


    @Autowired
    JavaMailSender mailSender;

    @Autowired
    private NotificationLocaleDao notificationLocaleDao;

    @Autowired
    private NotificationDao notificationDao;

    @Autowired
    private NotificationService notificationService;
    @Autowired
    private LocalService localService;
    @Autowired
    private RedevableService redevableService;

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

    public List<NotificationLocale> findAll() {
        return notificationLocaleDao.findAll();
    }

    @Transactional
    public int deleteByRef(String ref) {
        return notificationLocaleDao.deleteByRef(ref);
    }



    public int creerNotificationsLocals(Notification notification) {


        Notification notification1 = notificationService.findByAnneeAndTrimestre(
                notification.getAnnee(), notification.getTrimestre());

        if(notification1==null){
        return -1;
        }

        if(notification1.isEnvoyee()){
            return -2;
        }

        List<Local> locals = localService.findByDernierAnneePayeeAndDernierTrimestrePayee(notification.getAnnee(), notification.getTrimestre());

        if(locals.size()==0){
            return -3;
        }

        int r=1;
        for (Local local : locals) {
            Redevable redevable = local.getRedevable();
            NotificationLocale notificationLocale = new NotificationLocale();

            if(redevable==null){
            return -4;
            }



            String methodeEstime = "";

            List<Local> neighbours = localService.findByRueCodeAndCategorieLocalCode(
                    local.getRue().getCode(), local.getCategorieLocal().getCode());
            methodeEstime = "Par rue";

            if (neighbours.size() < 2) {
                neighbours = localService.findByRueQuartierCodeAndCategorieLocalCode(
                        local.getRue().getQuartier().getCode(), local.getCategorieLocal().getCode());
                methodeEstime = "Par quartier";

                if (neighbours.size() < 2) {
                    neighbours = localService.findByRueQuartierSecteurCodeAndCategorieLocalCode(
                            local.getRue().getQuartier().getSecteur().getCode(), local.getCategorieLocal().getCode());
                    methodeEstime = "Par secteur";

                    if (neighbours.size() < 2) {
                        return -5;
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
                return -6; }

            double montantEstime = total/n;



            notificationLocale.setMethodEstime(methodeEstime);
            notificationLocale.setMtBaseEstime(montantEstime);
            notificationLocale.setNotification(notification1);
            notificationLocale.setRef(""+notification1.getNumero()+(r++));
            notificationLocale.setLocale(local);
            notificationLocale.setRedevable(redevable);
            save(notificationLocale);


            try {
                SimpleMailMessage mailMessage = new SimpleMailMessage();
                mailMessage.setFrom("benismael.ilyas@gmail.com");
                mailMessage.setTo(redevable.getEmail());
                mailMessage.setSubject("Avertissement : taxe non payé");

                mailMessage.setText("Bonjour Mr/Mme "+redevable.getNom()+ "\nNous tenons à vous rappeler que " +
                "vous n'avez pas payé la taxe " + notification1.getTrimestre()+" de l'année "+ notification1.getAnnee()+
                ", de votre local ["+notificationLocale.getLocale().getRef()+ "] avec un montant estimé de : "+ notificationLocale.getMtBaseEstime());

                mailSender.send(mailMessage);
                System.out.println("khdem !!!"); }

            catch (Exception e) {
                System.out.println(e.getMessage());
            }


        }

        notification1.setEnvoyee(true);
        notificationDao.save(notification1);
        return 1;

    }

}
