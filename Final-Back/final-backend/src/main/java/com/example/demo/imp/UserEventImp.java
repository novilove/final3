package com.example.demo.imp;

import com.example.demo.Dto.DtoUserEvent;
import com.example.demo.model.UserEvent;
import com.example.demo.repository.UserEventRepository;
import com.example.demo.service.UserEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserEventImp implements UserEventService {
    @Autowired
    private UserEventRepository usergo;

    @Override
    public UserEvent go(DtoUserEvent nombre) throws Exception {
        UserEvent voy = null;
        try{


        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public UserEvent notGo(DtoUserEvent nombre) throws Exception {
        return null;
    }
}
