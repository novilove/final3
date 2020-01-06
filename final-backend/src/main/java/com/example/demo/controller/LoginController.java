package com.example.demo.controller;

import com.example.demo.Dto.DtoLogin;
import com.example.demo.exception.MailExisteException;
import com.example.demo.exception.UsuarioExistenteException;
import com.example.demo.imp.LoginImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/login")

 */
public class LoginController {
/*
    @Autowired
    private LoginImp loginimple;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> guardarLogin(@RequestBody DtoLogin dtoLogin) {
        ResponseEntity<Object> rs = null;

        try {
            rs = new ResponseEntity<Object>(loginimple.guardarLogin(dtoLogin), HttpStatus.OK);

        } catch (UsuarioExistenteException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        } catch (MailExisteException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);

        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

 */
}