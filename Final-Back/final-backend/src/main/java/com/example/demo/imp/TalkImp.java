package com.example.demo.imp;

import com.example.demo.Dto.DtoTalks;
import com.example.demo.model.Login;
import com.example.demo.service.TalksServices;
import org.springframework.stereotype.Service;

@Service
public class TalkImp implements TalksServices {


    @Override
    public Login crearteTalk(DtoTalks talks) throws Exception {
        return null;
    }

    @Override
    public Boolean deleteTalk(Long id) throws Exception {
        return null;
    }
}
