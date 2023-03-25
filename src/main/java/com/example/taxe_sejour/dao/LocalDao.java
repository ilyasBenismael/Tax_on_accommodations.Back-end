package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Local;
import com.example.taxe_sejour.bean.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  LocalDao extends JpaRepository<Local,Long> {
    public  Local findByRef(String reference);
    public List<Local> findByRueCode(String code);
    public List<Local> findByRueCodeAndCategorieLocalCode(String code, String localCode);
    public List<Local> findByCategorieLocalCode(String code);

    @Query("SELECT l FROM  Local  l WHERE l.dernierAnneePayee*4 + l.dernierTrimestrePayee < :dernierTrimestrePayee + :dernierAnneePayee*4")
    public List<Local> findByDernierAnneePayeeAndDernierTrimestrePayee(@Param("dernierAnneePayee") int dernierAnneePayee,@Param("dernierTrimestrePayee")  int dernierTrimestrePayee);
    public List<Local> findByRueQuartierCode(String code);
    public List<Local> findByRueQuartierCodeAndCategorieLocalCode(String code, String localCode);
    public List<Local> findByRueQuartierSecteurCodeAndCategorieLocalCode(String code, String localCode);
    public List<Local> findByRueQuartierSecteurCode(String code);

    int deleteByRef(String ref);

}