package com.example.demo.imp;


import com.example.demo.Dto.DtoLogin;
import com.example.demo.exception.MailExisteException;
import com.example.demo.exception.NoEncontradoException;
import com.example.demo.exception.UsuarioExistenteException;
import com.example.demo.model.Country;
import com.example.demo.model.Login;
import com.example.demo.model.User;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.UserRepository;

import com.example.demo.service.LoginService;
import com.example.demo.util.Constant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class LoginImp implements LoginService {

    @Autowired
    private LoginRepository loginRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CountryRepository countRepo;

    @Override
    public Login crearUsuario(DtoLogin dtoLogin) throws Exception {

        Login log = null;
        User use = null;
        Country cou = null;

        try{
            Login validarMail = loginRepo.findByEmail(dtoLogin.getEmailDto());
            User validarRut = userRepo.findByRut(dtoLogin.getRutDto());
            Country validarPais = countRepo.findByName(dtoLogin.getCountryDto());

            if(validarRut == null && validarMail == null && validarPais == null) {

                log = new Login();
                log.setEmail(dtoLogin.getEmailDto());
                log.setPassword(dtoLogin.getPasswordDto());
                log = loginRepo.save(log);

                cou = new Country();
                cou.setName(dtoLogin.getCountryDto());
                cou = countRepo.save(cou);

                use = new User();
                use.setAge(dtoLogin.getAgeDto());



                use.setGenre(dtoLogin.getGenreDto());
                use.setLastName(dtoLogin.getLastNameDto());
                use.setName(dtoLogin.getNameDto());

                use.setType(dtoLogin.getTypeDto());
                use.setCountry(cou);
                use.setLogin(log);
                use=userRepo.save(use);

                log.setUser(use);
                return log;

            }

            if(validarRut == null && validarMail == null && validarPais != null){
                log = new Login();
                log.setEmail(dtoLogin.getEmailDto());
                log.setPassword(dtoLogin.getPasswordDto());
                log = loginRepo.save(log);

                cou = validarPais;

                use = new User();
                use.setName(dtoLogin.getNameDto());
                use.setLastName(dtoLogin.getLastNameDto());
                use.setAge(dtoLogin.getAgeDto());
                use.setGenre(dtoLogin.getGenreDto());
                use.setType(dtoLogin.getTypeDto());
                use.setCountry(cou);
                use.setLogin(log);
                use=userRepo.save(use);

                log.setUser(use);
                return log;
            }
            if (validarMail != null && validarRut == null) {
                throw new MailExisteException(Constant.ERROR_MAIL_EXISTE);
        }
            if (validarMail != null && validarRut != null){
                throw new UsuarioExistenteException(Constant.ERROR_USUARIO_CREADO);
            }

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


        return log;
    }

    @Override
    public Boolean eliminarUsuario(Long id) throws Exception {
        Boolean elimi = false;
        try {

            Optional<User> buscarUser = userRepo.findById(id);
            Login buscarMail =  loginRepo.findByEmail(buscarUser.get().getLogin().getEmail());
            if (buscarMail != null) {
                loginRepo.delete(buscarMail);
                userRepo.delete(buscarUser.get());
                return elimi = true;
            }
            if(buscarMail== null){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }

        }catch (NoEncontradoException ex) {
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return elimi;
    }

}
