package com.example.demo.imp;


import com.example.demo.Dto.DtoSpeaker;
import com.example.demo.exception.MailExisteException;
import com.example.demo.exception.UsuarioExistenteException;
import com.example.demo.model.Country;
import com.example.demo.model.Login;
import com.example.demo.model.Speaker;
import com.example.demo.model.User;
import com.example.demo.repository.CountryRepository;
import com.example.demo.repository.SpeakerRepository;
import com.example.demo.util.Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SpeakerImp {
    @Autowired
    private SpeakerRepository speakRepo;

    @Autowired
    private CountryRepository couRepo;

    public Speaker createSpeaker (DtoSpeaker dtoSpeaker) throws Exception{

        Speaker spe =  null;
        Country coun = null;
        return spe;
      /*  try{
            Speaker validarSpeaker = SpeakerRepository.findById(dtoSpeaker.getSpeakerDto());
            Country validarPais = couRepo.findById(dtoSpeaker.getCountryDto());

            if(validarSpeaker == null && validarPais == null){

                spe= new Speaker();
                spe.setName(dtoSpeaker.getSpeakerDto());
                spe.setPassword(dtoLogin.getPasswordDto());


                if(validarPais == null){

                    spe = new Speaker();
                    spe.setName(dtoSpeaker.getSpeakerDto());
                    spe.setDescription(dtoSpeaker.getSpeakerDto());
                    spe.setCharge(dtoSpeaker.getChargeDto());

                    coun = new Country();
                    coun.setName(dtoSpeaker.getCountryDto());


                    spe.setCountry(coun);
                    spe.setName(spe);


                    log.setUsers(use);

                    log=loginRepo.save(log);
                    use=userRepo.save(use);
                    cou=countRepo.save(cou);
                    return log;



                }

                if(validarPais != null){
                    cou = validarPais;

                    use = new User();
                    use.setName(dtoLogin.getNameDto());
                    use.setLastName(dtoLogin.getLastNameDto());
                    use.setAge(dtoLogin.getAgeDto());
                    use.setGenre(dtoLogin.getGenreDto());
                    use.setType("comun");
                    use.setCountry(cou);
                    use.setLogins(log);


                    log.setUsers(use);
                    log=loginRepo.save(log);
                    use=userRepo.save(use);
                    return log;


                }

            }


            if (validarMail != null && validarRut == null) {
                throw new MailExisteException(Constant.ERROR_MAIL_EXISTE);
            }
            if (validarMail != null && validarRut != null){
                throw new UsuarioExistenteException(Constant.ERROR_USUARIO_CREADO);
            }

        }catch (MailExisteException ex) {
            ex.printStackTrace();
            throw new MailExisteException(ex.getMessage());
        }catch (UsuarioExistenteException ex) {
            ex.printStackTrace();
            throw new UsuarioExistenteException(ex.getMessage());
        }catch (Exception ex){
            ex.printStackTrace();
            throw new Exception(Constant.ERROR_SISTEMA);
        }


        return log;
    }

}
