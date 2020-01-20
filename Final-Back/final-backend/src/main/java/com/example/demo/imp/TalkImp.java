package com.example.demo.imp;

import com.example.demo.Dto.DtoTalks;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TalksServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TalkImp implements TalksServices {

    @Autowired
    private TalkRepository talkRepo;
    @Autowired
    private SpeakerRepository spkRepo;
    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private SalonRoomRepository salonRepo;
    @Autowired
    private EventRepository eveRepo;




    @Override
    public Login crearteTalk(DtoTalks talks) throws Exception {
<<<<<<< HEAD
        Talk tk = null;
        Speaker pk = null;
        Category cat = null;
        SalonRoom sr = null;
        Event eve = null;

        try{
            Talk validateName = talkRepo.findByName(talks.getNameTalkDto());
            Speaker validateSpeaker = spkRepo.findByName(talks.getNameSpeakerDto());
            Category validateCategory = catRepo.findByName(talks.getNameCategoryDto());
            SalonRoom validateSalon = salonRepo.findByName(talks.getNameSalonRoomDto());
            Event validateEvent = eveRepo.findByName(talks.getNameEventsDto());
            if(validateName==null && validateSpeaker==null && validateCategory==null && validateSalon==null && validateEvent==null){
                tk = new Talk();
                
            }

        }catch (Exception e){

        }
=======

        Place pla = null;
        SalonRoom sr = null;
        Category cat = null;

>>>>>>> 9c01049e35648c9f2087b865c60cd3c62615f175
        return null;
    }

    @Override
    public Boolean deleteTalk(Long id) throws Exception {
        return null;
    }
}
