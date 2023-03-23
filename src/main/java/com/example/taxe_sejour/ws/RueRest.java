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
    public Rue findByCodeR(@PathVariable String codeR) {
        return rueService.findByCodeR(codeR);
    }

    @DeleteMapping ("/codeR/{codeR}")
    public int deleteByCodeR(@PathVariable String codeR) {
        return rueService.deleteByCodeR(codeR);
    }

    @GetMapping("/")
    public List<Rue> findAll() {
        return rueService.findAll();
    }

    @GetMapping("/quartier/CodeQ/{CoodeQ}")
    public List<Rue> findByQuartierCodeQ(@PathVariable String codeQ) {
        return rueService.findByQuartierCodeQ(codeQ);
    }
}
