package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.Annuelle;
import com.example.taxe_sejour.bean.TaxeAnnuelle;
import com.example.taxe_sejour.service.AnnuelleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/v1/annuelle")
public class AnnuelleRest {

    @Autowired
    private AnnuelleService annuelleService;

    @GetMapping("ref/{ref}")
    public Annuelle findByRef(String ref){return annuelleService.findByRef(ref);}

    @GetMapping("/")
    public List<Annuelle> findAll(){return annuelleService.findAll();};

    @GetMapping("dateMax/{dateMax}")

    public Annuelle findByDateMax(Date dateMax){return annuelleService.findByDateMax(dateMax);}
    @GetMapping("dateMin/{dateMin}")
    public Annuelle findByDateMin(Date dateMin){return annuelleService.findByDateMin(dateMin);}

    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(String ref){return annuelleService.deleteByRef(ref);}

}
