package com.example.demo.service;

import com.example.demo.Dto.DtoLogin;
import com.example.demo.model.Login;
import org.springframework.stereotype.Service;

@Service
public interface LoginService {

    Login createUser(DtoLogin logins) throws Exception;
    Boolean deleteUser(Long id, String pass) throws Exception;
}
/*
Giovanna Tapia
giovannatss27@gmail.com
 */