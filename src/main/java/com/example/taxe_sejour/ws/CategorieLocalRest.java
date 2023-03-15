package com.example.taxe_sejour.ws;


import com.example.taxe_sejour.bean.CategorieLocal;
import com.example.taxe_sejour.service.CategorieLocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController @RequestMapping("/api/vi/categorieLocal")
public class CategorieLocalRest {
@Autowired
    private CategorieLocalService categorieLocalService;

    @GetMapping("/name/{name}")
    public CategorieLocal findByName(String name) {
        return categorieLocalService.findByName(name);
    }

    @PostMapping("/")
    public int Save(@RequestBody CategorieLocal categorieLocal) {
        return categorieLocalService.Save(categorieLocal);
    }

    @GetMapping("/code/{code}")
    public CategorieLocal findByCode(@PathVariable String code) {
        return categorieLocalService.findByCode(code);
    }


    @DeleteMapping("/code/{code}")
    @Transactional
    public int deleteByCode(@PathVariable String code) {
        return categorieLocalService.deleteByCode(code);
    }

    @GetMapping("/")
    public List<CategorieLocal> findAll() {
        return categorieLocalService.findAll();
    }
}
