package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Rue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RueDao extends JpaRepository<Rue,Long> {
    Rue findByCode(String codeR);
    int deleteByCode(String codeR);

    List<Rue> findByQuartierCode(String codeQ);

}



