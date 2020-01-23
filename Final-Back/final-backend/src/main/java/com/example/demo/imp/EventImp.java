package com.example.demo.imp;

import com.example.demo.Dto.DtoEvent;
import com.example.demo.exception.EventExistException;
import com.example.demo.exception.NoEncontradoException;
import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;
import com.example.demo.service.EventService;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EventImp implements EventService {
    @Autowired
    private EventRepository everepo;


    @Override
    public Event createEvent(DtoEvent events) throws Exception {

        Event eve = null;

        try{
            Event ValidateName = everepo.findByName(events.getNameEventDto());

            if(ValidateName == null ) {
                eve = new Event();
                eve.setName(events.getNameEventDto());
                eve.setDescription(events.getDescriptionEventDto());
                eve.setDate(events.getDateEventDto());

                everepo.save(eve);
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
    public Boolean deleteEvent(Long id) throws Exception {
        Boolean delete = false;
        try{
            Optional<Event> buscarEvent = everepo.findById(id);
            if(buscarEvent != null){
                everepo.delete(buscarEvent.get());
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


/*
Giovanna Tapia
giovannatss27@gmail.com
 */
    

}
