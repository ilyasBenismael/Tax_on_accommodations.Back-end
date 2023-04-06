package com.example.taxe_sejour.dao;

import com.example.taxe_sejour.bean.NotificationLocale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationLocaleDao extends JpaRepository<NotificationLocale,Long> {
    NotificationLocale findByRef(String reference);

    int deleteByRef(String ref);

    @Override
    List<NotificationLocale> findAll();
}