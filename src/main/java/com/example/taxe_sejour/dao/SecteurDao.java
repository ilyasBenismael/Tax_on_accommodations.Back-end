package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Secteur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecteurDao extends JpaRepository<Secteur,Long> {
    Secteur findByCodeS(String codeS);
    int deleteByCodeS(String codeS);
}
