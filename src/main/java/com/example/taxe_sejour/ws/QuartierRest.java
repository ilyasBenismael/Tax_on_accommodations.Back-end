package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.Quartier;
import com.example.taxe_sejour.service.QuartierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/api/v1/quartier")
public class QuartierRest {
    @Autowired private QuartierService quartierService;
    @PostMapping("/")
    public int save(@RequestBody Quartier quartier) {
        return quartierService.save(quartier);
    }

    @GetMapping("/codeQ/{codeQ}")
    public Quartier findByCodeQ(@PathVariable String codeQ) {
        return quartierService.findByCodeQ(codeQ);
    }

    @Transactional
    @DeleteMapping ("/codeQ/{codeQ}")
    public int deleteByCodeQ(@PathVariable String codeQ) {
        return quartierService.deleteByCodeQ(codeQ);
    }

    @GetMapping("/")
    public List<Quartier> findAll() {
        return quartierService.findAll();
    }

    @GetMapping("/secteur/codeS/{codeS}")
    public List<Quartier> findBySecteurCodeS(@PathVariable String codeS) {
        return quartierService.findBySecteurCodeS(codeS);
    }
}
