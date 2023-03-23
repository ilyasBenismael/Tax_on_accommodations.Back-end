package com.example.taxe_sejour.ws;


import com.example.taxe_sejour.bean.Trimestre;
import com.example.taxe_sejour.service.TrimestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/trimestre")
public class TrimestreRest {

    @Autowired
    TrimestreService trimestreService;

    @GetMapping("/nombreTrim/{nombreTrim}")
    public Trimestre findByNombreTrim(@PathVariable int nombreTrim) {
        return trimestreService.findByNombreTrim(nombreTrim);
    }

    @GetMapping("/nombreTrim/{nombreTrim}/annee/{annee}")
    public Trimestre findByNombreTrimAndAnnee(@PathVariable int nombreTrim, @PathVariable int annee) {
        return trimestreService.findByNombreTrimAndAnnee(nombreTrim, annee);
    }

    @GetMapping("/ref/{ref}")
    public Trimestre findByRef(@PathVariable String ref) {
        return trimestreService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return trimestreService.deleteByRef(ref);
    }


    @PostMapping("/")
    public int save(@RequestBody Trimestre trimestre) {
        return trimestreService.save(trimestre);
    }
}

