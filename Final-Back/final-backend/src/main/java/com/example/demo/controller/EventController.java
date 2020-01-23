package com.example.demo.controller;


import com.example.demo.Dto.DtoEvent;
import com.example.demo.Dto.DtoUserEvent;
import com.example.demo.exception.EdadNoPermitidaException;
import com.example.demo.exception.MailExisteException;
import com.example.demo.exception.NoEncontradoException;
import com.example.demo.exception.UsuarioExistenteException;

import com.example.demo.imp.EventImp;
import com.example.demo.imp.UserEventImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2/event")
public class EventController {
    @Autowired
    private EventImp impl;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> go(@RequestBody DtoEvent dto) {
        ResponseEntity<Object> rs = null;

        try {
            rs = new ResponseEntity<Object>(impl.createEvent(dto), HttpStatus.OK);

        }catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteEvent(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(impl.deleteEvent(id),HttpStatus.OK);
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.NOT_FOUND) ;
        }catch (Exception ex){
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR) ;
        }
        return  rs;
    }
/*
Giovanna Tapia
giovannatss27@gmail.com
 */
}
