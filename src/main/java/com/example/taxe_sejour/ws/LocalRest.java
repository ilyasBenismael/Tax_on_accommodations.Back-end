package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.Local;
import com.example.taxe_sejour.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/local")
public class LocalRest {

    @Autowired
    LocalService localService;

    @GetMapping("/")
    public List<Local> findAll() {
        return localService.findAll();
    }

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


    @GetMapping("/redevable/cin/{cin}")
    public List<Local> findByRedevableCin(@PathVariable String cin) {
        return localService.findByRedevableCin(cin);
    }

    @GetMapping("/redevable/cin/{cin}/rue/quartier/secteur/code/{code}")
    public List<Local> findByRedevableCinAndRueQuartierSecteurCode(@PathVariable String cin,@PathVariable String code) {
        return localService.findByRedevableCinAndRueQuartierSecteurCode(cin, code);
    }

    @GetMapping("/redevable/cin/{cin}/rue/quartier/code/{code}")
    public List<Local> findByRedevableCinAndRueQuartierCode(@PathVariable String cin,@PathVariable String code) {
        return localService.findByRedevableCinAndRueQuartierCode(cin, code);
    }

    @GetMapping("/redevable/cin/{cin}/rue/code/{code}")
    public List<Local> findByRedevableCinAndRueCode(@PathVariable String cin,@PathVariable String code) {
        return localService.findByRedevableCinAndRueCode(cin, code);
    }

    @GetMapping("/rue/quartier/secteur/code/{code}")
    public List<Local> findBydRueQuartierSecteurCode(@PathVariable String code) {
        return localService.findBydRueQuartierSecteurCode(code);
    }

    @GetMapping("/rue/quartier/code/{code}")
    public List<Local> findByRueQuartierCode(@PathVariable String code) {
        return localService.findByRueQuartierCode(code);
    }




    @GetMapping("/dernierAnneePayee/{dernierAnneePayee}/dernierTrimestrePayee/{dernierTrimestrePayee}")
    @Query("SELECT l FROM  Local  l WHERE l.dernierAnneePayee*4 + l.dernierTrimestrePayee < :dernierTrimestrePayee + :dernierAnneePayee*4")
    public List<Local> findByDernierAnneePayeeAndDernierTrimestrePayee(@PathVariable int dernierAnneePayee, @PathVariable int dernierTrimestrePayee) {
        return localService.findByDernierAnneePayeeAndDernierTrimestrePayee(dernierAnneePayee, dernierTrimestrePayee);
    }

    @GetMapping("/rue/code/{code}/categorieLocal/localCode/{localCode}")
    public List<Local> findByRueCodeAndCategorieLocalCode(@PathVariable String code, @PathVariable String localCode) {
        return localService.findByRueCodeAndCategorieLocalCode(code, localCode);
    }

    @GetMapping("/rue/quartier/code/{code}/categorieLocal/localCode/{localCode}")
    public List<Local> findByRueQuartierCodeAndCategorieLocalCode(@PathVariable String code, @PathVariable String localCode) {
        return localService.findByRueQuartierCodeAndCategorieLocalCode(code, localCode);
    }

    @GetMapping("/rue/quartier/secteur/code/{code}/categorieLocal/localCode/{localCode}")
    public List<Local> findByRueQuartierSecteurCodeAndCategorieLocalCode(@PathVariable String code, @PathVariable String localCode) {
        return localService.findByRueQuartierSecteurCodeAndCategorieLocalCode(code, localCode);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return localService.deleteByRef(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody Local local) {
        return localService.save(local);
    }


}

