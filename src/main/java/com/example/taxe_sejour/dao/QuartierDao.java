package com.example.taxe_sejour.dao;


import com.example.taxe_sejour.bean.Quartier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuartierDao extends JpaRepository<Quartier,Long> {
    Quartier findByCode(String code);
    int deleteByCode(String code);

    List<Quartier> findBySecteurCode(String code);

}
