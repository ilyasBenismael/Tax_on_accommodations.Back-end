package com.example.taxe_sejour.ws;

import com.example.taxe_sejour.bean.InfoRecuTrim;
import com.example.taxe_sejour.bean.Local;
import com.example.taxe_sejour.service.InfoRecuTrimService;
import com.example.taxe_sejour.service.LocalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/infoRecuTrim")
public class InfoRecuTrimRest {

    @Autowired
    InfoRecuTrimService infoRecuTrimService;

    @GetMapping("/ref/{ref}")
    public InfoRecuTrim findByRef(String ref) {
        return infoRecuTrimService.findByRef(ref);
    }


    @DeleteMapping("/ref/{ref}")
    public int deleteByRef(String ref) {
        return infoRecuTrimService.deleteByRef(ref);
    }
}
