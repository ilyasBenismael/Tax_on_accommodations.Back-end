package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.InfoRecuTrim;
import com.example.taxe_sejour.service.InfoRecuTrimService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/infoRecuTrim")
public class InfoRecuTrimRest {

    @Autowired
    InfoRecuTrimService infoRecuTrimService;

    @GetMapping("/ref/{ref}")
    public InfoRecuTrim findByRef(@PathVariable String ref) {
        return infoRecuTrimService.findByRef(ref);
    }

    @Transactional
    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(@PathVariable String ref) {
        return infoRecuTrimService.deleteByRef(ref);
    }

    @PostMapping("/")
    public int save(@RequestBody InfoRecuTrim infoRecuTrim) {
        return infoRecuTrimService.save(infoRecuTrim);
    }
}
