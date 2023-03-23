package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.Secteur;
import com.example.taxe_sejour.service.SecteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/api/v1/secteur")
public class SecteurRest {
    @Autowired
    private SecteurService secteurService;
    @GetMapping("/")
    public int save(@RequestBody Secteur secteur) {
        return secteurService.save(secteur);
    }
    @GetMapping("/codeS/{codeS}")
    public Secteur findByCodeS(@PathVariable String codeS) {
        return secteurService.findByCodeS(codeS);
    }
    @Transactional
    @DeleteMapping("/codeS/{codeS}")
    public int deleteByCodeS(@PathVariable String codeS) {
        return secteurService.deleteByCodeS(codeS);
    }
    @GetMapping("/")
    public List<Secteur> findAll() {
        return secteurService.findAll();
    }

}
