package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Rue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RueDao extends JpaRepository<Rue,Long> {
    Rue findByCodeR(String codeR);
    int deleteByCodeR(String codeR);

    List<Rue> findByQuartierCodeQ(String codeQ);

}



