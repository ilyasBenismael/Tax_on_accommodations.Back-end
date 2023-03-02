package dao;

import bean.CategorieLocal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategorieDao extends JpaRepository<CategorieLocal,Long> {

    CategorieLocal findByCode(String code);
    int deleteByCode(String code);


}
