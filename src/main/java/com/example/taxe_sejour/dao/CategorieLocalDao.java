package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.CategorieLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieLocalDao extends JpaRepository<CategorieLocal,Long> {

    CategorieLocal findByCode(String code);
    int deleteByCode(String code);


}
