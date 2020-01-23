package com.example.demo.controller;

import com.example.demo.Dto.DtoSpeaker;

import com.example.demo.exception.NoEncontradoException;
import com.example.demo.imp.SpeakerImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2/speak")
public class SpeakerController {
    @Autowired
    private SpeakerImp imp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> createSpeak(@RequestBody DtoSpeaker speak) {
        ResponseEntity<Object> rs = null;

        try {

            rs = new ResponseEntity<Object>(imp.createSpeak(speak), HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteSpeak(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(imp.deleteSpeak(id),HttpStatus.OK);
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
/*
Giovanna Tapia
giovannatss27@gmail.com
 */