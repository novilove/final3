package com.example.demo.imp;

import com.example.demo.Dto.DtoName;
import com.example.demo.exception.EventExistException;
import com.example.demo.exception.NoEncontradoException;
import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryServices;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryImp implements CategoryServices {
    @Autowired
    private CategoryRepository catrepo;

    @Override
    public Boolean createCategory(DtoName name) throws Exception {
        Category cat = null;
        Boolean create = false;
        try {
            Category validarCat = catrepo.findByName(name.getNameDtoDto());
            if (validarCat == null) {
                cat = new Category();
                cat.setName(name.getNameDtoDto());
                catrepo.save(cat);
                return create = true;
            } else {
                throw new EventExistException(Constant.ERROR_EVENTO);
            }
        }catch (EventExistException ex){
            ex.printStackTrace();
            throw new EventExistException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }

    }

    @Override
    public Boolean deleteCategory(DtoName name) throws Exception {
        Boolean delete = false;
        try {
            Category validarCat = catrepo.findByName(name.getNameDtoDto());
            if(validarCat != null){
                catrepo.delete(validarCat);
                return delete = true;
            }
            else {
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch (NoEncontradoException ex) {
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }

    }

    @Override
    public List<Category> listCategory() throws Exception {
        List<Category> listCat = new ArrayList<Category>();

        try{
            listCat = catrepo.findAll();
            return listCat;

        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }


    }

}
