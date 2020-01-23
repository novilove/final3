package com.example.demo.repository;

import com.example.demo.model.Speaker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpeakerRepository extends JpaRepository<Speaker,Long> {
   Speaker findByid(Long id);
   Speaker findByName(String name);
}
/*
Giovanna Tapia
giovannatss27@gmail.com
 */