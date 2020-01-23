package com.example.demo.imp;

import com.example.demo.Dto.DtoTalks;
import com.example.demo.exception.NoEncontradoException;
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
            Speaker validateSpeaker = spkRepo.findByName(talks.getNameSpeakerDto().getNameSpkDto());
            Category validateCategory = catRepo.findByName(talks.getCategoryDto().getNameCatDto());
            SalonRoom validateSalon = salonRepo.findByName(talks.getNameSalonRoomDto().getNameSalonDto());
            Event validateEvent = eveRepo.findByName(talks.getNameEventsDto().getNameEventDto());
            if(validateName==null && validateSpeaker==null && validateCategory==null && validateSalon==null && validateEvent==null){
                eve = new Event();
                eve.setName(talks.getNameEventsDto().getNameEventDto());

                pk = new Speaker();
                pk.setName(talks.getNameSpeakerDto().getNameSpkDto());

                cat = new Category();
                cat.setName(talks.getCategoryDto().getNameCatDto());

                sr = new SalonRoom();
                sr.setName(talks.getNameSalonRoomDto().getNameSalonDto());

                tk = new Talk();
                tk.setName(talks.getNameTalkDto());
                tk.setDescription(talks.getDescriptionTalkDto());
                tk.setDuration(talks.getDurationTalkDto());
                tk.setEvent(eve);
                tk.setSpeakers(pk);
                tk.setCategories(cat);
                tk.setSalon(sr);

                tk = talkRepo.save(tk);

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

                tk = talkRepo.save(tk);
            }

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return null;
    }

    @Override

    public Boolean deleteTalk(String name) throws Exception {

        Boolean delete = false;
        try{
            Talk searchTalk = talkRepo.findByName(name);
            if(searchTalk != null){
                talkRepo.delete(searchTalk);
                return delete = true;
            }
            if(searchTalk == null){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch (NoEncontradoException ex){
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());

        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return delete;
    }
}
