package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.Rue;
import com.example.taxe_sejour.service.RueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController@RequestMapping("/api/v1/rue")
public class RueRest {
    @Autowired private RueService rueService;

    @PostMapping("/")
    public int save(@RequestBody Rue rue) {
        return rueService.save(rue);
    }

    @GetMapping("/codeR/{codeR}")
    public Rue findByCode(@PathVariable String codeR) {
        return rueService.findByCode(codeR);
    }

    @DeleteMapping ("/codeR/{codeR}")
    public int deleteByCode(@PathVariable String codeR) {
        return rueService.deleteByCode(codeR);
    }

    @GetMapping("/")
    public List<Rue> findAll() {
        return rueService.findAll();
    }

    @GetMapping("/quartier/CodeQ/{CoodeQ}")
    public List<Rue> findByQuartierCode(@PathVariable String codeQ) {
        return rueService.findByQuartierCode(codeQ);
    }
}
