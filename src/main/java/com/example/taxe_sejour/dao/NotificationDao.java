package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationDao extends JpaRepository<Notification,Long>{


}