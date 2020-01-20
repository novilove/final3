package com.example.demo.repository;

import com.example.demo.model.SalonRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalonRoomRepository extends JpaRepository<SalonRoom, Long> {
    SalonRoom findByid(SalonRoom salones);
    SalonRoom findByName(String name);
}
