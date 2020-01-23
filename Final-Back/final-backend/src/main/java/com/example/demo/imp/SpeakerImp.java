package com.example.demo.imp;

import com.example.demo.Dto.DtoSpeaker;
import com.example.demo.exception.IncorrectException;
import com.example.demo.exception.NoEncontradoException;
import com.example.demo.exception.UsuarioExistenteException;
import com.example.demo.model.Country;
import com.example.demo.model.Login;
import com.example.demo.model.Speaker;
import com.example.demo.model.User;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.SpeakerRepository;
import com.example.demo.service.SpeakerServices;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SpeakerImp implements SpeakerServices {

    @Autowired
    private SpeakerRepository skrepo;

    @Autowired
    private CountryRepository courepo;



    @Override
    public Speaker createSpeak(DtoSpeaker speak) throws Exception {
        Speaker spk = null;
        Country cou =  null;
        try {
            Speaker validarSpeak = skrepo.findByName(speak.getNameSpeakerDto());
            Country validarCountry = courepo.findByName(speak.getNamecountryDto());

            if (validarCountry == null && validarSpeak == null) {
                cou = new Country();
                cou.setName(speak.getNamecountryDto());
                cou = courepo.save(cou);

                spk = new Speaker();
                spk.setName(speak.getNameSpeakerDto());
                spk.setDescription(speak.getDescriptionSpeakerDto());
                spk.setPosition(speak.getPositionSpeakerDto());
                spk.setCountry(cou);
                spk = skrepo.save(spk);
                return spk;

            }
            if (validarSpeak == null && validarCountry != null) {
                cou = validarCountry;

                spk = new Speaker();
                spk.setName(speak.getNameSpeakerDto());
                spk.setDescription(speak.getDescriptionSpeakerDto());
                spk.setPosition(speak.getPositionSpeakerDto());
                spk.setCountry(cou);
                spk = skrepo.save(spk);

                return spk;

            } else {
                throw new UsuarioExistenteException(Constant.ERROR_USUARIO_CREADO);
            }
        }catch (UsuarioExistenteException ex) {
            ex.printStackTrace();
            throw new UsuarioExistenteException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }

    }

    @Override
    public Boolean deleteSpeak(Long idSpeak) throws Exception {
        Boolean elimi = false;
        try {

            Optional<Speaker> buscarSpeak = skrepo.findById(idSpeak);


            if (buscarSpeak != null) {

                skrepo.delete(buscarSpeak.get());

                return elimi = true;
            }
            if(buscarSpeak== null){
                throw new NoEncontradoException(Constant.ERROR_NO_ENCONTRADO);
            }
        }catch (NoEncontradoException ex) {
            ex.printStackTrace();
            throw new NoEncontradoException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }
        return elimi;
    }
    /*
Giovanna Tapia
giovannatss27@gmail.com
 */
}
