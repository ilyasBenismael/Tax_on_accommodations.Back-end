package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.InfoAnnuelle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoAnnuelleDao extends JpaRepository<InfoAnnuelle, Long> {

    InfoAnnuelle findByRef(String ref);

    int deleteByRef(String ref);
}
