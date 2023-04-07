package com.example.taxe_sejour.dao;

//import com.example.taxe_sejour.bean.CategorieLocal;
import com.example.taxe_sejour.bean.TaxeAnnuelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxeAnnuelleDao extends JpaRepository<TaxeAnnuelle, Long> {

     TaxeAnnuelle findByRef(String ref);
     int deleteByRef(String ref);
     List<TaxeAnnuelle> findAll();
     TaxeAnnuelle findByRedevableCin(String cin);
     List<TaxeAnnuelle> findByLocalRef(String ref);
    TaxeAnnuelle findByLocalRefAndAnneeAndRedevableCin(String ref,int annee,String cin);


    void deleteByLocalRef(String ref);
}
