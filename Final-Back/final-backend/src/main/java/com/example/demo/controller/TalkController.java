package com.example.demo.controller;



import com.example.demo.Dto.DtoTalks;
import com.example.demo.exception.NoEncontradoException;
import com.example.demo.imp.TalkImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2/talk")
public class TalkController {

    @Autowired
    private TalkImp imp;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Object> crearteTalk(@RequestBody DtoTalks talks) {
        ResponseEntity<Object> rs = null;

        try {

            rs = new ResponseEntity<Object>(imp.crearteTalk(talks), HttpStatus.OK);

        } catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/{id}",method = RequestMethod.DELETE)
    public ResponseEntity<Object> deleteTalk(@PathVariable Long id){
        ResponseEntity<Object> rs = null;
        try {
            rs = new ResponseEntity<Object>(imp.deleteTalk(id),HttpStatus.OK);
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