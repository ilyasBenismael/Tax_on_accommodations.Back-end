package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.TaxeAnnuelle;
import com.example.taxe_sejour.service.TaxeAnnuelleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vi/taxeAnnuelle")
public class TaxeAnnuelleRest {

    @Autowired
    private TaxeAnnuelleService taxeAnnuelleService;


    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return taxeAnnuelleService.deleteByRef(ref);
    }


    @GetMapping("/redevable/cin/{cin}")
    public List<TaxeAnnuelle> findByRedevableCin(@PathVariable String cin) {
        return taxeAnnuelleService.findByRedevableCin(cin);}



}
