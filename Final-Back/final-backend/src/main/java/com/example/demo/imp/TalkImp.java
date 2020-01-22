package com.example.demo.imp;

import com.example.demo.Dto.DtoTalks;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.service.TalksServices;
import com.example.demo.util.Constant;
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
                eve = new Event();
                eve.setName(talks.getNameEventsDto());

                pk = new Speaker();
                pk.setName(talks.getNameSpeakerDto());

                cat = new Category();
                cat.setName(talks.getNameCategoryDto());

                sr = new SalonRoom();
                sr.setName(talks.getNameCategoryDto());

                tk = new Talk();
                tk.setName(talks.getNameTalkDto());
                tk.setDescription(talks.getDescriptionTalkDto());
                tk.setDuration(talks.getDurationTalkDto());
                tk.setEvent(eve);
                tk.setSpeakers(pk);
                tk.setCategories(cat);
                tk.setSalon(sr);

            }
            if(validateName==null && validateSpeaker!=null && validateCategory!=null && validateSalon!=null && validateEvent!=null){
                eve = validateEvent;

                pk = validateSpeaker;

                cat = validateCategory;

                sr = validateSalon;

                tk = new Talk();
                tk.setName(talks.getNameTalkDto());
                tk.setDescription(talks.getDescriptionTalkDto());
                tk.setDuration(talks.getDurationTalkDto());
                tk.setEvent(eve);
                tk.setSpeakers(pk);
                tk.setCategories(cat);
                tk.setSalon(sr);
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return null;
    }

    @Override
    public Boolean deleteTalk(Long id) throws Exception {
        return null;
    }
}
