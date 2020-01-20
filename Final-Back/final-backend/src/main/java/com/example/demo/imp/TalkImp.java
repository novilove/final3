package com.example.demo.imp;

import com.example.demo.Dto.DtoTalks;
import com.example.demo.model.Category;
import com.example.demo.model.Login;
import com.example.demo.model.Place;
import com.example.demo.model.SalonRoom;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.repository.SalonRoomRepository;
import com.example.demo.service.TalksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalkImp implements TalksServices {
    @Autowired
    private PlaceRepository placeRepo;
    @Autowired
    private SalonRoomRepository salonRepo;
    @Autowired
    private CategoryRepository catRepo;


    @Override
    public Login crearteTalk(DtoTalks talks) throws Exception {
        Place pla = null;
        SalonRoom sr = null;
        Category cat = null;
        return null;
    }

    @Override
    public Boolean deleteTalk(Long id) throws Exception {
        return null;
    }
}
