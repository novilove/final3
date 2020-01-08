package com.example.demo.service;

import com.example.demo.Dto.DtoLogin;
import com.example.demo.model.Login;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface LoginService {

    Login crearUsuario(DtoLogin logins) throws Exception;




}
