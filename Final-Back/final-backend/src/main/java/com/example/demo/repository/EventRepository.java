package com.example.demo.repository;

import com.example.demo.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event,Long> {

    Event findByid(Long id);

    Event findByName(String nameDto);
}
/*
Giovanna Tapia
giovannatss27@gmail.com
 */