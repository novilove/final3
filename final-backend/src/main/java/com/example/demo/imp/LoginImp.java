package com.example.demo.imp;

import com.example.demo.Dto.DtoLogin;
import com.example.demo.exception.MailExisteException;
import com.example.demo.exception.UsuarioExistenteException;
import com.example.demo.model.Login;
import com.example.demo.model.User;
import com.example.demo.repository.LoginRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.LoginService;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LoginImp implements LoginService {
    @Autowired
    private LoginRepository loginRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Login guardarLogin(DtoLogin logindto) throws Exception {
        Login logins = null;
        User users = null;
        try {
            Login validarMail = loginRepo.findByCorreo(logindto.getEmailDto());
            User validarId = userRepo.findByAllId(logindto.getIdDto());
            if (validarMail == null && validarId == null) {
                //crear login y estudiante
                logins = new Login();
                logins.setEmail(logindto.getEmailDto());
                logins.setPassword(logindto.getPasswordDto());
                logins = loginRepo.save(logins);

                users = new User();

                users.setName(logindto.getNameDto());
                users.setAge(logindto.getAgeDto());
                users.setLogins(logins);
                users = userRepo.save(users);

                logins.setUsers(users);
                return logins;
            }
            if (validarMail != null && validarId == null) {
                throw new MailExisteException(Constant.ERROR_MAIL_EXISTE);
            } else {
                throw new UsuarioExistenteException(Constant.ERROR_USUARIO_CREADO);
            }
        }catch (MailExisteException ex) {
            ex.printStackTrace();
            throw new MailExisteException(ex.getMessage());
        }catch (UsuarioExistenteException ex){
            ex.printStackTrace();
            throw new UsuarioExistenteException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }

    }


}
