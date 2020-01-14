package com.example.demo.controller;


import com.example.demo.Dto.DtoUserEvent;
import com.example.demo.exception.EdadNoPermitidaException;
import com.example.demo.exception.MailExisteException;
import com.example.demo.exception.UsuarioExistenteException;

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
    private UserEventImp imp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> go(@RequestBody DtoUserEvent dtoLogin) {
        ResponseEntity<Object> rs = null;

        try {
            rs = new ResponseEntity<Object>(imp.go(dtoLogin), HttpStatus.OK);

        }catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

}
