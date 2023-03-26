package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Trimestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrimestreDao extends JpaRepository<Trimestre,Long> {
    Trimestre findByNombreTrim(int nombreTrim);
    Trimestre findByRef(String ref);
int deleteByRef(String ref);
}



