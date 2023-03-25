package com.example.taxe_sejour.ws;


import com.example.taxe_sejour.bean.*;
import com.example.taxe_sejour.service.TauxTrimService;
import com.example.taxe_sejour.service.TaxeTrimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/taxeTrim")
public class TaxeTrimRest {
    @Autowired
    private TaxeTrimService taxeTrimService;


    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return taxeTrimService.deleteByRef(ref);
    }

    @GetMapping("/nombreTrim/{trim}/annee/{annee}/local/ref/{ref}")
    public TaxeTrim findByNombreTrimAndAnneeAndLocalRef(@PathVariable int trim,@PathVariable int annee,@PathVariable String ref) {
        return taxeTrimService.findByNombreTrimAndAnneeAndLocalRef(trim, annee, ref);
    }

    @GetMapping("/redevable/cin/{cin}")
    public List<TaxeTrim> findByRedevableCin(@PathVariable String cin) {
    return taxeTrimService.findByRedevableCin(cin);}

    @GetMapping("/tauxtrim/ref/{ref}")
    public List<TaxeTrim> findByTauxTrimRef(@PathVariable String ref) {
        return taxeTrimService.findByTauxTrimRef(ref);
    }

    @GetMapping("/local/ref/{ref}")
    public List<TaxeTrim> findByLocalRef(@PathVariable String ref) {
        return taxeTrimService.findByLocalRef(ref);
    }

    @PostMapping ("/")
    public int payer(@RequestBody InfoRecuTrim infoRecuTrim) {
        return taxeTrimService.payer(infoRecuTrim);
    }





}
