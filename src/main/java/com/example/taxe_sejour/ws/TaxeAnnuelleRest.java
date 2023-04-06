package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.InfoAnnuelle;
import com.example.taxe_sejour.bean.TaxeAnnuelle;
import com.example.taxe_sejour.service.TaxeAnnuelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.List;

@RestController
@RequestMapping("/api/v1/taxeAnnuelle")
public class TaxeAnnuelleRest {

    @Autowired
    private TaxeAnnuelleService taxeAnnuelleService;
    @GetMapping("/")
    public List<TaxeAnnuelle> findAll() {
        return taxeAnnuelleService.findAll();
    }
    @GetMapping("ref/{ref}")
    public TaxeAnnuelle findByRef(@PathVariable String ref) {
        return taxeAnnuelleService.findByRef(ref);
    }
    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return taxeAnnuelleService.deleteByRef(ref);
    }
    @GetMapping("/local/{ref}/annee/{annee}/cin/{cin}")
    public TaxeAnnuelle findByLocalRefAndAnneeAndRedevableCin(@PathVariable String ref,@PathVariable int annee,@PathVariable String cin){
        return taxeAnnuelleService.findByLocalRefAndAnneeAndRedevableCin(ref,annee,cin);
    }

    @GetMapping("/redevable/cin/{cin}")
    public TaxeAnnuelle findByRedevableCin(@PathVariable String cin) {
        return taxeAnnuelleService.findByRedevableCin(cin);}

    @PostMapping("/")
    public float payement(@RequestBody InfoAnnuelle infoAnnuelle){
        return taxeAnnuelleService.payement(infoAnnuelle);
    }

    @GetMapping("local/ref/{ref}")
    public List<TaxeAnnuelle> findByLocalRef(@PathVariable String ref) {
        return taxeAnnuelleService.findByLocalRef(ref);
    }



}