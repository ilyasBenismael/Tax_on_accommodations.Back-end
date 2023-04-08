package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.TauxAnnuelle;
import com.example.taxe_sejour.bean.TauxTrim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxAnnuelleDao extends JpaRepository<TauxAnnuelle,Long> {

    TauxAnnuelle findByRef(String ref);




}
