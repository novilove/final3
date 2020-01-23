package com.example.demo.service;

import com.example.demo.Dto.DtoLogin;
import com.example.demo.Dto.DtoUserEvent;
import com.example.demo.model.User;
import com.example.demo.model.UserEvent;
import org.springframework.stereotype.Service;

@Service
public interface UserEventService {
    Boolean go(DtoUserEvent nombre) throws Exception;
    Boolean notGo(DtoUserEvent nombre) throws Exception;


}
/*
Giovanna Tapia
giovannatss27@gmail.com
 */