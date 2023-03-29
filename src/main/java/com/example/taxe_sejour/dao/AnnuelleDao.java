package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Annuelle;
import com.example.taxe_sejour.bean.TaxeAnnuelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AnnuelleDao extends JpaRepository<Annuelle,Long> {

    Annuelle findByRef(String ref);

    Annuelle findByDateMax(Date dateMax);

    Annuelle findByDateMin(Date dateMin);

    Annuelle findByAnnee(int annee);

    public List<Annuelle> findAll();

    int deleteByRef(String ref);

}
