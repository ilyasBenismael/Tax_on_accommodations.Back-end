package com.example.taxe_sejour.ws;


import com.example.taxe_sejour.bean.InfoAnnuelle;
import com.example.taxe_sejour.service.InfoAnnuelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/InfoAnnuelle")
public class InfoAnnuelleRest {

    @Autowired
    InfoAnnuelleService infoAnnuelleService;

    @GetMapping("/ref/{ref}")
    public InfoAnnuelle findByRef(@PathVariable String ref) {
        return infoAnnuelleService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return infoAnnuelleService.deleteByRef(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody InfoAnnuelle infoRecuTrim) {
        return infoAnnuelleService.save(infoRecuTrim);
    }



}
