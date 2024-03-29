package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationDao extends JpaRepository<Notification,Long>{

 Notification findByAnneeAndTrimestre(int annee, int trimestre);

Notification findByNumero(int numero);
 int deleteByAnneeAndTrimestre(int annee, int trimestre);


}
