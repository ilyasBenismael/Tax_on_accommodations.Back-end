package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Rue;
import com.example.taxe_sejour.bean.Trimestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrimestreDao extends JpaRepository<Trimestre,Long> {
    Trimestre findByNombreTrim(int nombreTrim);
    Trimestre findByRef(String ref);
    Trimestre findByNombreTrimAndAnnee(int nombreTrim, int annee);
int deleteByRef(String ref);
}



