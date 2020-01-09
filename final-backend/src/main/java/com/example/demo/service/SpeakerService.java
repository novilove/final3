package com.example.demo.service;

import com.example.demo.Dto.DtoSpeaker;
import com.example.demo.model.Speaker;
import org.springframework.stereotype.Service;

@Service
public interface SpeakerService {
    Speaker saveSpeaker (DtoSpeaker Speakers) throws Exception;

}
