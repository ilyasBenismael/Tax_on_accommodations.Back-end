package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.CategorieLocal;
import com.example.taxe_sejour.bean.TaxeAnnuelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaxeAnnuelleDao extends JpaRepository<TaxeAnnuelle, Long> {

    public TaxeAnnuelle findByRef(String ref);
    public int deleteByRef(String ref);
    public List<TaxeAnnuelle> findAll();
    public TaxeAnnuelle findByRedevableCin(String cin);
    public List<TaxeAnnuelle> findByLocalRef(String ref);








}
