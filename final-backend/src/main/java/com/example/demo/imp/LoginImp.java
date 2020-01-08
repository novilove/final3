package com.example.demo.imp;


import com.example.demo.Dto.DtoLogin;
import com.example.demo.exception.MailExisteException;
import com.example.demo.exception.UsuarioExistenteException;
import com.example.demo.model.Country;
import com.example.demo.model.Login;
import com.example.demo.model.User;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.UserRepository;

import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class LoginImp  {

    @Autowired
    private LoginRepository loginRepo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private CountryRepository countRepo;


    public Login crearUsuario(DtoLogin dtoLogin) throws Exception {

        Login log = null;
        User use = null;
        Country cou = null;

        try{
            Login validarMail = loginRepo.findByEmail(dtoLogin.getEmailDto());
            User validarRut = userRepo.findByRut(dtoLogin.getRutDto());
            Country validarPais = countRepo.findByName(dtoLogin.getCountryDto());

            if(validarRut == null && validarMail == null){

                log= new Login();
                log.setEmail(dtoLogin.getEmailDto());
                log.setPassword(dtoLogin.getPasswordDto());


                if(validarPais == null){

                    use = new User();
                    use.setName(dtoLogin.getNameDto());
                    use.setLastName(dtoLogin.getLastNameDto());
                    use.setRut(dtoLogin.getRutDto());
                    use.setAge(dtoLogin.getAgeDto());
                    use.setGenre(dtoLogin.getGenreDto());
                    use.setType(dtoLogin.getTypeDto());

                    cou = new Country();
                    cou.setName(dtoLogin.getCountryDto());


                    use.setCountry(cou);
                    use.setLogins(log);


                    log.setUsers(use);

                    log=loginRepo.save(log);
                    use=userRepo.save(use);
                    cou=countRepo.save(cou);
                    return log;



                }

                if(validarPais != null){
                    cou = validarPais;

                    use = new User();
                    use.setName(dtoLogin.getNameDto());
                    use.setLastName(dtoLogin.getLastNameDto());
                    use.setAge(dtoLogin.getAgeDto());
                    use.setGenre(dtoLogin.getGenreDto());
                    use.setType("comun");
                    use.setCountry(cou);
                    use.setLogins(log);


                    log.setUsers(use);
                    log=loginRepo.save(log);
                    use=userRepo.save(use);
                    return log;


                }

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
}
