package com.example.taxe_sejour.ws;


import com.example.taxe_sejour.bean.CategorieLocal;
import com.example.taxe_sejour.bean.Redevable;
import com.example.taxe_sejour.service.CategorieLocalService;
import com.example.taxe_sejour.service.RedevableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/api/v1/redevable")
public class RedevableRest {
@Autowired
    private RedevableService redevableService;

    @GetMapping("/cin/{cin}")
    public Redevable findByCin(String cin) {
        return redevableService.findByCin(cin);
    }

    @DeleteMapping("/cin/{cin}")
    @Transactional
    public int deleteByCin(String cin) {
        return redevableService.deleteByCin(cin);
    }

    @PostMapping("/")
    public int save(Redevable redevable) {
        return redevableService.save(redevable);
    }


}
