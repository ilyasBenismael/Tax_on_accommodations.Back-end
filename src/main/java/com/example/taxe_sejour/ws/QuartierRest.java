package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.Quartier;
import com.example.taxe_sejour.service.QuartierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/api/v1/quartier")
public class QuartierRest {
    @Autowired private QuartierService quartierService;
    @PostMapping("/")
    public int save(Quartier quartier) {
        return quartierService.save(quartier);
    }

    @GetMapping("/codeQ/{codeQ}")
    public Quartier findByCodeQ(String codeQ) {
        return quartierService.findByCodeQ(codeQ);
    }
    @DeleteMapping ("/codeQ/{codeQ}")
    public int deleteByCodeQ(String codeQ) {
        return quartierService.deleteByCodeQ(codeQ);
    }

    @GetMapping("/")
    public List<Quartier> findAll() {
        return quartierService.findAll();
    }
    @GetMapping("/secteur/codeS/{codeS}")
    public List<Quartier> findBySecteurCodeS(String codeS) {
        return quartierService.findBySecteurCodeS(codeS);
    }
}
