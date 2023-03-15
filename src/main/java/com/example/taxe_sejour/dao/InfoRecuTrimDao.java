package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.InfoRecuTrim;
import com.example.taxe_sejour.bean.Redevable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRecuTrimDao extends JpaRepository<InfoRecuTrim, Long> {

    InfoRecuTrim findByRef(String ref);

    int deleteByRef(String ref);

}