package com.example.demo.controller;

import com.example.demo.Dto.DtoLogin;
import com.example.demo.exception.EdadNoPermitidaException;
import com.example.demo.exception.MailExisteException;
import com.example.demo.exception.NoEncontradoException;
import com.example.demo.exception.UsuarioExistenteException;

import com.example.demo.imp.LoginImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
/*
Giovanna Tapia
 */



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2/login")
public class LoginController {

    @Autowired
    private LoginImp imp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> crearUsuaio(@RequestBody DtoLogin dtoLogin) {
        ResponseEntity<Object> rs = null;

        try {
            rs = new ResponseEntity<Object>(imp.crearUsuario(dtoLogin), HttpStatus.OK);

        }catch (EdadNoPermitidaException ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_ACCEPTABLE);
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
    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> eliminarUsuario(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(imp.eliminarUsuario(id),HttpStatus.OK);
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return  rs;
    }

}