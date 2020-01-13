package com.example.demo.imp;

import com.example.demo.Dto.DtoEvent;

import com.example.demo.exception.EventExistException;
import com.example.demo.exception.NoEncontradoException;
import com.example.demo.model.Category;
import com.example.demo.model.Event;
import com.example.demo.model.Place;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.PlaceRepository;
import com.example.demo.service.EventService;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventImp implements EventService {
    @Autowired
    private EventRepository everepo;
    @Autowired
    private PlaceRepository plarepo;
    @Autowired
    private CategoryRepository catrepo;

    @Override
    public Event createEvent(DtoEvent events) throws Exception {
        Event eve = null;
        Place pla = null;
        Category cat = null;

        try{
            Event ValidateName = everepo.findByName(events.getNameDto());
            Place ValidateCity = plarepo.findByCity(events.getNamePlaceDto());
            Category ValidateCat = catrepo.findByCat(events.getNameCategotyDto());
            if(ValidateName == null && ValidateCity == null && ValidateCat == null) {
                eve = new Event();
                eve.setName(events.getNameDto());
                eve.setDuration(events.getDurationDto());
                eve.setDescription(events.getDescriptionDto());
                eve.setTime(events.getTimeDto());
                eve.setDate(events.getDateDto());
                eve.setCapacity(events.getCapacityDto());
                eve = everepo.save(eve);

                pla = new Place();
                pla.setName(events.getNamePlaceDto());
                pla.setCity(events.getCityDto());
                pla.setAdress(events.getAdressDto());
                pla = plarepo.save(pla);

                cat = new Category();
                cat.setName(events.getNameDto());
                cat = catrepo.save(cat);
            }
            if(ValidateName == null && ValidateCity == null && ValidateCat != null) {
                eve = new Event();
                eve.setName(events.getNameDto());
                eve.setDuration(events.getDurationDto());
                eve.setDescription(events.getDescriptionDto());
                eve.setTime(events.getTimeDto());
                eve.setDate(events.getDateDto());
                eve.setCapacity(events.getCapacityDto());
                eve = everepo.save(eve);

                pla = new Place();
                pla.setName(events.getNamePlaceDto());
                pla.setCity(events.getCityDto());
                pla.setAdress(events.getAdressDto());
                pla = plarepo.save(pla);

                cat = ValidateCat;
                return eve;

            }
            if (ValidateName != null) {
                throw new EventExistException(Constant.ERROR_EVENTO);
            }

        }catch (EventExistException ex) {
            ex.printStackTrace();
            throw new EventExistException(ex.getMessage());
        }catch(Exception e){
            e.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);

        }
        return eve;
    }



    @Override
    public Boolean deleteEvent(String name) throws Exception {
        Boolean delete = false;
        try{
            Event buscarEvent = everepo.findByName(name);
            if(buscarEvent != null){
                everepo.delete(buscarEvent);
                return delete = true;
            }
            if(buscarEvent == null){
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
