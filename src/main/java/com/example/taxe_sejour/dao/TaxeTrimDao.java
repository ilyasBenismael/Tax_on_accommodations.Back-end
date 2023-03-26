package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.TaxeTrim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaxeTrimDao extends JpaRepository<TaxeTrim, Long> {
     TaxeTrim findByRef(String ref);
     int deleteByRef(String ref);

    List<TaxeTrim> findByRedevableCin(String cin);
    List<TaxeTrim> findByTauxTrimRef(String ref);
    List<TaxeTrim> findByLocalRef(String ref);
    TaxeTrim findByNombreTrimAndAnneeAndLocalRef(int trim, int annee, String ref);


}