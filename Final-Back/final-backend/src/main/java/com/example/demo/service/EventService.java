package com.example.demo.service;

import com.example.demo.Dto.DtoEvent;
import com.example.demo.model.Event;
import org.springframework.stereotype.Service;

@Service
public interface EventService {
    Event createEvent(DtoEvent events) throws Exception;

    Boolean deleteEvent(Long id) throws Exception;

}
/*
Giovanna Tapia
giovannatss27@gmail.com
 */