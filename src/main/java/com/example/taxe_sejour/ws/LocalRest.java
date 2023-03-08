package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.taxe_sejour.service.LocalService;

import java.util.List;

@RestController
@RequestMapping("api/v1/local")
public class LocalRest {

    @Autowired
    LocalService localService;

    @GetMapping("/ref/{ref}")
    public Local findByRef(@PathVariable String ref) {
        return localService.findByRef(ref);
    }

    @GetMapping("/rue/code/{code}")
    public List<Local> findByRueCode(@PathVariable String code) {
        return localService.findByRueCode(code);
    }

    @GetMapping("/categorielocal/code/{code}")
    public List<Local> findByCategorieLocalCode(@PathVariable String code) {
        return localService.findByCategorieLocalCode(code);
    }

    @GetMapping("/rue/quartier/code/{code}")
    public List<Local> findByRueQuartierCode(@PathVariable String code) {
        return localService.findByRueQuartierCode(code);
    }

    @GetMapping("/rue/quartier/secteur/code/{code}")
    public List<Local> findByRueQuartierSecteurCode(@PathVariable String code) {
        return localService.findByRueQuartierSecteurCode(code);
    }

    @GetMapping("/dernierTrimPaye/{dernierTrimPaye}")
    public List<Local> findByDerTripayee(@PathVariable int dernierTrimPaye) {
        return localService.findByDerTripayee(dernierTrimPaye);
    }

    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return localService.deleteByRef(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody Local local) {
        return localService.save(local);
    }
}