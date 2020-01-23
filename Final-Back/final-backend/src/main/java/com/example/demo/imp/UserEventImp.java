package com.example.demo.imp;

import com.example.demo.Dto.DtoUserEvent;
import com.example.demo.exception.NoEncontradoException;
import com.example.demo.model.Event;
import com.example.demo.model.User;
import com.example.demo.model.UserEvent;
import com.example.demo.repository.EventRepository;
import com.example.demo.repository.UserEventRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserEventService;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserEventImp implements UserEventService {
    @Autowired
    private UserEventRepository usergo;
    @Autowired
    private UserRepository userepo;
    @Autowired
    private EventRepository everepo;

    @Override
    public Boolean go(DtoUserEvent nombre) throws Exception {
        Boolean create = false;
        try{
            Optional<User> validarUser = userepo.findById(nombre.getIdUserDto());
            User vali= validarUser.get();
            Event validarEvent = everepo.findByName(nombre.getNameEventDto());

            if(validarEvent != null && vali != null){
                UserEvent validarGo = usergo.findByUsersAndEvent(vali.getId(),validarEvent.getId());
                return create = true;
            }
            if(validarEvent == null && vali != null){
                throw  new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);

            }
            if(validarEvent != null && vali == null){
                throw  new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);

            }


        }catch (NoEncontradoException ex) {
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return create;
    }

    @Override
    public Boolean notGo(DtoUserEvent nombre) throws Exception {
        Boolean create = false;
        try{
            Optional<User> validarUser = userepo.findById(nombre.getIdUserDto());
            User vali= validarUser.get();
            Event validarEvent = everepo.findByName(nombre.getNameEventDto());

            if(validarEvent != null && vali != null){
                UserEvent validarGo = usergo.findByUsersAndEvent(vali.getId(),validarEvent.getId());
                usergo.delete(validarGo);
                return create = true;
            }
            if(validarEvent == null && vali != null){
                throw  new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);

            }
            if(validarEvent != null && vali == null){
                throw  new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);

            }


        }catch (NoEncontradoException ex) {
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return create;
    }
    /*
Giovanna Tapia
giovannatss27@gmail.com
 */
}
