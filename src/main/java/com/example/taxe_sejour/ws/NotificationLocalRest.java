package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.Notification;
import com.example.taxe_sejour.bean.NotificationLocale;
import com.example.taxe_sejour.service.NotificationLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notificationLocal")
public class NotificationLocalRest {


        @Autowired
        NotificationLocalService notificationLocalService;


//    @PostMapping("/")
//    public int save(@RequestBody NotificationLocale notificationLocale) {
//        return notificationLocalService.save(notificationLocale);
//    }

    @GetMapping("/ref/{ref}")
    public NotificationLocale findByRef(@PathVariable String reference) {
        return notificationLocalService.findByRef(reference);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return notificationLocalService.deleteByRef(ref);
    }

    @PostMapping("/")
    public int creerNotificationsLocals(@RequestBody Notification notification) {
        return notificationLocalService.creerNotificationsLocals(notification);
    }


    }


