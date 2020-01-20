package com.example.demo.repository;

import com.example.demo.model.Talk;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TalkRepository extends JpaRepository<Talk,Long> {
    Talk findByid(Long id);
    Talk findByName(String name);
}
