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
    public Quartier findByCode(@PathVariable String codeQ) {
        return quartierService.findByCode(codeQ);
    }

    @Transactional
    @DeleteMapping ("/codeQ/{codeQ}")
    public int deleteByCode(@PathVariable String codeQ) {
        return quartierService.deleteByCode(codeQ);
    }

    @GetMapping("/")
    public List<Quartier> findAll() {
        return quartierService.findAll();
    }

    @GetMapping("/secteur/codeS/{codeS}")
    public List<Quartier> findBySecteurCode(@PathVariable String codeS) {
        return quartierService.findBySecteurCode(codeS);
    }
}
