package com.example.demo.imp;


import com.example.demo.Dto.DtoDeleteLogin;
import com.example.demo.Dto.DtoLogin;
import com.example.demo.Dto.DtoSession;
import com.example.demo.exception.*;
import com.example.demo.model.Country;
import com.example.demo.model.Login;
import com.example.demo.model.User;
import com.example.demo.model.UserEvent;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.UserRepository;

import com.example.demo.service.LoginService;
import com.example.demo.util.Constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeMap;


@Service
public class LoginImp implements LoginService {

    @Autowired
    private LoginRepository loginRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CountryRepository countRepo;

    @Override
    public Login createUser(DtoLogin dtoLogin) throws Exception {

        Login log = null;
        User use = null;
        Country cou = null;

        try{
            Login validarMail = loginRepo.findByEmail(dtoLogin.getEmailDto());
            User validarRut = userRepo.findByRut(dtoLogin.getRutDto());
            Country validarPais = countRepo.findByName(dtoLogin.getCountryDto());

            if(validarRut == null && validarMail == null && validarPais == null) {
                if((dtoLogin.getAgeDto() )< 13 || (dtoLogin.getAgeDto()) > 120){
                    throw new EdadNoPermitidaException(Constant.ERROR_EDAD);
                }
                log = new Login();
                log.setEmail(dtoLogin.getEmailDto());
                log.setPassword(dtoLogin.getPasswordDto());
                loginRepo.save(log);

                cou = new Country();
                cou.setName(dtoLogin.getCountryDto());
               countRepo.save(cou);

                use = new User();
                use.setRut(dtoLogin.getRutDto());
                use.setName(dtoLogin.getNameDto());
                use.setLastName(dtoLogin.getLastNameDto());
                use.setAge(dtoLogin.getAgeDto());
                use.setGenre(dtoLogin.getGenreDto());
                use.setType(dtoLogin.getTypeDto());
                use.setCountry(cou);
                use.setLogin(log);


                userRepo.save(use);

                log.setUser(use);
                return log;

            }

            if(validarRut == null && validarMail == null && validarPais != null){
                log = new Login();
                log.setEmail(dtoLogin.getEmailDto());
                log.setPassword(dtoLogin.getPasswordDto());
                loginRepo.save(log);

                cou = validarPais;

                use = new User();
                use.setRut(dtoLogin.getRutDto());
                use.setName(dtoLogin.getNameDto());
                use.setLastName(dtoLogin.getLastNameDto());
                use.setAge(dtoLogin.getAgeDto());
                use.setGenre(dtoLogin.getGenreDto());
                use.setType(dtoLogin.getTypeDto());
                use.setCountry(cou);
                use.setLogin(log);

                userRepo.save(use);

                log.setUser(use);
                return log;
            }
        if (validarMail != null && validarRut == null) {
            throw new MailExisteException(Constant.ERROR_MAIL_EXISTE);
        }
        else {
            throw new UsuarioExistenteException(Constant.ERROR_USUARIO_CREADO);
        }
        }catch (EdadNoPermitidaException ex) {
            ex.printStackTrace();
            throw new EdadNoPermitidaException(ex.getMessage());
        }catch (MailExisteException ex) {
            ex.printStackTrace();
            throw new MailExisteException(ex.getMessage());
        }catch (UsuarioExistenteException ex) {
            ex.printStackTrace();
            throw new UsuarioExistenteException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }


    }

    @Override
    public Boolean deleteUser(DtoDeleteLogin delete) throws Exception {
        Boolean elimi = false;
        try {

            User buscarUser = userRepo.findByid(delete.getIdDelete());
            Login buscarMail =  loginRepo.findByEmail(buscarUser.getLogin().getEmail());


            if (buscarMail != null && buscarMail.getPassword() == delete.getPassDelete()) {

                loginRepo.delete(buscarMail);
                userRepo.delete(buscarUser);
                return elimi = true;
            }
            if (buscarMail != null && buscarMail.getPassword() != delete.getPassDelete()) {
                throw new IncorrectException(Constant.ERROR_INCORRECTO);
            }
            if(buscarMail== null){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch (IncorrectException ex) {
            ex.printStackTrace();
            throw new IncorrectException(ex.getMessage());
        }catch (NoEncontradoException ex) {
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return elimi;
    }

    @Override
    public Boolean session(DtoSession dto) throws Exception {
        Boolean valido = false;
        try{
            Login validarmail = loginRepo.findByEmail(dto.getEmailD());
            if((validarmail.getPassword()) == (dto.getPassD())){
                return valido = true;
            }
            if((validarmail.getPassword()) != (dto.getPassD())){
                throw new IncorrectException(Constant.ERROR_INCORRECTO);
            }

        }catch (IncorrectException ex) {
            ex.printStackTrace();
            throw new IncorrectException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return null;
    }
/*
Giovanna Tapia
giovannatss27@gmail.com
 */
}
