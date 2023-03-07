package com.example.taxe_sejour.dao;


import com.example.taxe_sejour.bean.Quartier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartierDao extends JpaRepository<Quartier,Long> {
    Quartier findByCodeQ(String codeQ);
    int deleteByCodeQ(String codeQ);

    List<Quartier> findBySecteurCodeS(String codeS);

}
