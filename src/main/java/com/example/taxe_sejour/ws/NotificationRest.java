package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.Notification;
import com.example.taxe_sejour.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/notification")
public class NotificationRest {

    @Autowired
    NotificationService notificationService;


    @PostMapping("/")
    public int save(@RequestBody Notification notification) {
        return notificationService.save(notification);
    }



    @GetMapping("/annee/{annee}/trimestre/{trimestre}")
    public Notification findByAnneeAndTrimestre(@PathVariable int annee,@PathVariable int trimestre) {
        return notificationService.findByAnneeAndTrimestre(annee, trimestre);
    }

    @Transactional
    @DeleteMapping("/annee/{annee}/trimestre/{trimestre}")
    public int deleteByAnneeAndTrimestre(@PathVariable int annee, @PathVariable int trimestre) {
        return notificationService.deleteByAnneeAndTrimestre(annee, trimestre);
    }
}


