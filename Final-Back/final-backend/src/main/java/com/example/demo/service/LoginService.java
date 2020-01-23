package com.example.demo.service;

import com.example.demo.Dto.DtoDeleteLogin;
import com.example.demo.Dto.DtoLogin;
import com.example.demo.Dto.DtoSession;
import com.example.demo.model.Login;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    Login createUser(DtoLogin logins) throws Exception;
    Boolean deleteUser(DtoDeleteLogin delete) throws Exception;
    Boolean session(DtoSession dto) throws Exception;
}
/*
Giovanna Tapia
giovannatss27@gmail.com
 */