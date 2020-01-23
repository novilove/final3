package com.example.demo.controller;


import com.example.demo.Dto.DtoName;
import com.example.demo.imp.CategoryImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v2/category")
public class CategoryController {
    @Autowired
    private CategoryImp imp;

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity<Object> createCategory(@RequestBody DtoName name) {
        ResponseEntity<Object> rs = null;

        try {
            rs = new ResponseEntity<Object>(imp.createCategory(name), HttpStatus.OK);

        }catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public ResponseEntity<Object> deleteCategory(@RequestBody DtoName name) {
        ResponseEntity<Object> rs = null;

        try {
            rs = new ResponseEntity<Object>(imp.deleteCategory(name), HttpStatus.OK);

        }catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<Object> listCategory() {
        ResponseEntity<Object> rs = null;

        try {
            rs = new ResponseEntity<Object>(imp.listCategory(), HttpStatus.OK);

        }catch (Exception ex) {
            ex.printStackTrace();
            rs = new ResponseEntity<Object>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return rs;
    }

}
/*
Giovanna Tapia
giovannatss27@gmail.com
 */
