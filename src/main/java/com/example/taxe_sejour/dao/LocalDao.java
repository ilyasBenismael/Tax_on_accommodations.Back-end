package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  LocalDao extends JpaRepository<Local,Long> {
     Local findByRef(String reference);
     List<Local> findByRedevableCin(String cin);
     List<Local> findByRedevableCinAndRueQuartierSecteurCode(String cin, String code);
     List<Local> findByRedevableCinAndRueQuartierCode(String cin, String code);
     List<Local> findByRedevableCinAndRueCode(String cin, String code);
    List<Local> findByRueQuartierSecteurCode(String code);
    List<Local> findByRueQuartierCode(String code);
    List<Local> findByRueCode(String code);

     List<Local> findByRueCodeAndCategorieLocalCode(String code, String localCode);
     List<Local> findByCategorieLocalCode(String code);





    @Query("SELECT l FROM  Local  l WHERE l.dernierAnneePayee*4 + l.dernierTrimestrePayee < :dernierTrimestrePayee + :dernierAnneePayee*4")
    public List<Local> findByDernierAnneePayeeAndDernierTrimestrePayee(@Param("dernierAnneePayee") int dernierAnneePayee,@Param("dernierTrimestrePayee")  int dernierTrimestrePayee);

    public List<Local> findByRueQuartierCodeAndCategorieLocalCode(String code, String localCode);
    public List<Local> findByRueQuartierSecteurCodeAndCategorieLocalCode(String code, String localCode);

    int deleteByRef(String ref);

}