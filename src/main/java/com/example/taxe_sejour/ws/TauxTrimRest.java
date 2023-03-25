package com.example.taxe_sejour.ws;


import com.example.taxe_sejour.bean.TauxTrim;
import com.example.taxe_sejour.service.TauxTrimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController @RequestMapping("/api/vi/tauxTrim")
public class TauxTrimRest {
    @Autowired
    private TauxTrimService tauxTrimService;



    @PostMapping("/")
    public int Save(@RequestBody TauxTrim tauxTrim) {
        return tauxTrimService.Save(tauxTrim);
    }
    @GetMapping("/ref/{ref}")
    public TauxTrim findByRef(@PathVariable String ref) {
        return tauxTrimService.findByRef(ref);
    }

    @DeleteMapping("/ref/{ref}")
    @Transactional
    public int deleteByRef(@PathVariable String ref) {
        return tauxTrimService.deleteByRef(ref);
    }

    @GetMapping("/datepresenation/{datepresenation}/datepresenation2/{datepresenation2}/categorieLocal/code/{code}")
    public TauxTrim findByDateAppMinLessThanAndDateAppMaxGreaterThanAndCategorieLocalCode(@PathVariable Date datepresenation, @PathVariable Date datepresenation2, @PathVariable String code) {
        return tauxTrimService.findByDateAppMinLessThanAndDateAppMaxGreaterThanAndCategorieLocalCode(datepresenation, datepresenation2, code);
    }

    @GetMapping("/")
    public List<TauxTrim> findAll() {
        return tauxTrimService.findAll();
    }
}
