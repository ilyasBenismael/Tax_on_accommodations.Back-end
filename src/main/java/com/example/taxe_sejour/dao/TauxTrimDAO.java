package com.example.taxe_sejour.dao;


import com.example.taxe_sejour.bean.TauxTrim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TauxTrimDAO extends JpaRepository<TauxTrim,Long> {

TauxTrim findByRef(String ref);

int deleteByRef(String ref);


}
