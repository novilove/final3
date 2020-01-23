package com.example.demo.service;


import com.example.demo.Dto.DtoSpeaker;
import com.example.demo.model.Login;

import com.example.demo.model.Speaker;
import org.springframework.stereotype.Service;

@Service
public interface SpeakerServices {
    Speaker createSpeak(DtoSpeaker speak) throws Exception;
    Boolean deleteSpeak(Long idSpeak) throws Exception;

}
/*
Giovanna Tapia
giovannatss27@gmail.com
 */