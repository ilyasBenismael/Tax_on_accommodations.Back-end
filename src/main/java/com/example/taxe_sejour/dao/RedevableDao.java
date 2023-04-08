package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Redevable;
import com.example.taxe_sejour.bean.TaxeAnnuelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RedevableDao extends JpaRepository<Redevable, Long> {

    Redevable findByCin(String cin);

    int deleteByCin(String cin);

    public List<Redevable> findAll();

}