package com.example.demo.controller;


import com.example.demo.Dto.DtoTalks;
import com.example.demo.Dto.DtoUserEvent;
import com.example.demo.exception.NoEncontradoException;
import com.example.demo.imp.UserEventImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2/userevent")
public class UserEventController {
    @Autowired
    private UserEventImp imp;
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> go(@RequestBody DtoUserEvent nombre) {
        ResponseEntity<Object> rs = null;

        try {
            rs = new ResponseEntity<Object>(imp.go(nombre), HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<Object> notGo(@PathVariable DtoUserEvent nombre){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(imp.notGo(nombre),HttpStatus.OK);
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
