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
    private SpeakerRepository spkRepo;
    @Autowired
    private CountryRepository courepo;
    @Autowired
    private PlaceRepository placerepo;
    @Autowired
    private SalonRoomRepository salonRepo;
    @Autowired
    private CategoryRepository catRepo;
    @Autowired
    private EventRepository eveRepo;


    @Autowired
    private TalkRepository talkRepo;


    @Override
    public Login crearteTalk(DtoTalks talks) throws Exception {

        Speaker pk = null;
        Country cou = null;
        Place pla = null;
        SalonRoom sr = null;
        Category cat = null;
        Event eve = null;
        Talk tk = null;

        try{

            Speaker validateSpeaker = spkRepo.findByName(talks.getNameSpeakerDto());
            Category validateCategory = catRepo.findByName(talks.getNameCategoryDto());
            if(validateSpeaker == null){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
            if(validateSpeaker != null) {
                Country validateCountry = courepo.findByName(talks.getNameCountryDto());
                Place valitePlace = placerepo.findByName(talks.getNamePlaceDto());
                SalonRoom validateSalon = salonRepo.findByName(talks.getNameSalonRoomDto());

                Event validateEvent = eveRepo.findByName(talks.getNameEventsDto());
                Talk validateName = talkRepo.findByName(talks.getNameTalkDto());


                if (validateName == null && validateCategory == null && validateSalon == null && validateEvent == null) {
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
                if (validateName == null && validateSpeaker != null && validateCategory != null && validateSalon != null && validateEvent != null) {
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
            }
        }catch (Exception e){
            e.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return null;
    }

    @Override
    public Boolean deleteTalk(Long id) throws Exception {

        Boolean delete = false;
        try{
            Talk searchTalk = talkRepo.findByid(id);
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
