package com.example.demo.service;

import com.example.demo.Dto.DtoName;
import com.example.demo.model.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryServices {
    Boolean createCategory(DtoName name) throws Exception;
    Boolean deleteCategory(DtoName name) throws Exception;
    List<Category> listCategory() throws Exception;
}
/*
Giovanna Tapia
giovannatss27@gmail.com
 */