package dao;

import bean.Rue;
import bean.TaxeTrim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TaxeTrimDao extends JpaRepository<TaxeTrim, Long> {
     TaxeTrim findByRef(String ref);
     int DeleteByRef(String ref);

    List<TaxeTrim> findByRedevableCin(String cin);
    List<TaxeTrim> findByTauxTrimRef(String ref);
    List<TaxeTrim> findByLocalRef(String ref);

     // List<Rue> findByQuartierCodeq(String codeq);





}