package com.example.demo.service;

import com.example.demo.Dto.DtoLogin;
import com.example.demo.Dto.DtoTalks;
import com.example.demo.model.Login;
import org.springframework.stereotype.Service;

@Service
public interface TalksServices {

    Login crearteTalk(DtoTalks talks) throws Exception;
    Boolean deleteTalk(String name) throws Exception;
}
/*
Giovanna Tapia
giovannatss27@gmail.com
 */