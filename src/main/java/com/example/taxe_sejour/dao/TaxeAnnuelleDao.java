package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.TaxeAnnuelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxeAnnuelleDao extends JpaRepository<TaxeAnnuelle, Long> {

    TaxeAnnuelle findByRef(String ref);

    int deleteByRef(String ref);

    int deleteByLocalRef(String ref);

    List<TaxeAnnuelle> findAll();


    List<TaxeAnnuelle> findByRedevableCin(String cin);//Connetre user qui va payer





    List<TaxeAnnuelle> findByLocalRef(String ref);//local du user qu'on va verifier



}
