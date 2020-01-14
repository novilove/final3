package com.example.demo.repository;

import com.example.demo.model.UserEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEventRepository extends JpaRepository<UserEvent, Long> {
    UserEvent findByid(Long id);

}
