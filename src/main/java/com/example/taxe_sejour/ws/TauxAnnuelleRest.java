package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.TauxAnnuelle;
import com.example.taxe_sejour.dao.TauxAnnuelleDao;
import com.example.taxe_sejour.service.TauxAnnuelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vi/tauxAnnuelle")
public class TauxAnnuelleRest {

    @Autowired
    TauxAnnuelleService tauxAnnuelleService;

    @GetMapping("ref/{ref}")
    public TauxAnnuelle findByRef(String ref){return tauxAnnuelleService.findByRef(ref);}



}
