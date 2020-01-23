package com.example.demo.Dto;

public class DtoTalks {

    //talk
    private String nameTalkDto;
    private String descriptionTalkDto;
    private Integer durationTalkDto;

    //speaker
    private DtoSpeaker nameSpeakerDto;

    //category
    private DtoCategory CategoryDto;

    //salonRoom

    private String nameSalonRoomDto;
    private Integer capacitySalonRoomDto;


    //place
    private String namePlaceDto;
    private String adressPlaceDto;
    private String cityPlaceDto;

    //Country
    private String nameCountryDto;

    //event
    private DtoEvent nameEventsDto;

    public String getNameTalkDto() {
        return nameTalkDto;
    }

    public void setNameTalkDto(String nameTalkDto) {
        this.nameTalkDto = nameTalkDto;
    }

    public String getDescriptionTalkDto() {
        return descriptionTalkDto;
    }

    public void setDescriptionTalkDto(String descriptionTalkDto) {
        this.descriptionTalkDto = descriptionTalkDto;
    }

    public Integer getDurationTalkDto() {
        return durationTalkDto;
    }

    public void setDurationTalkDto(Integer durationTalkDto) {
        this.durationTalkDto = durationTalkDto;
    }

    public DtoSpeaker getNameSpeakerDto() {
        return nameSpeakerDto;
    }

    public void setNameSpeakerDto(DtoSpeaker nameSpeakerDto) {
        this.nameSpeakerDto = nameSpeakerDto;
    }

    public DtoSalonRoom getNameSalonRoomDto() {
        return nameSalonRoomDto;
    }

    public void setNameSalonRoomDto(DtoSalonRoom nameSalonRoomDto) {
        this.nameSalonRoomDto = nameSalonRoomDto;
    }

    public DtoCategory getCategoryDto() {
        return CategoryDto;
    }

    public void setCategoryDto(DtoCategory categoryDto) {
        CategoryDto = categoryDto;
    }

    public DtoEvent getNameEventsDto() {
        return nameEventsDto;
    }

    public void setNameEventsDto(DtoEvent nameEventsDto) {
        this.nameEventsDto = nameEventsDto;
    }

    public Integer getCapacitySalonRoomDto() {
        return capacitySalonRoomDto;
    }

    public void setCapacitySalonRoomDto(Integer capacitySalonRoomDto) {
        this.capacitySalonRoomDto = capacitySalonRoomDto;
    }

    public String getNamePlaceDto() {
        return namePlaceDto;
    }

    public void setNamePlaceDto(String namePlaceDto) {
        this.namePlaceDto = namePlaceDto;
    }

    public String getAdressPlaceDto() {
        return adressPlaceDto;
    }

    public void setAdressPlaceDto(String adressPlaceDto) {
        this.adressPlaceDto = adressPlaceDto;
    }

    public String getCityPlaceDto() {
        return cityPlaceDto;
    }

    public void setCityPlaceDto(String cityPlaceDto) {
        this.cityPlaceDto = cityPlaceDto;
    }

    public String getNameCountryDto() {
        return nameCountryDto;
    }

    public void setNameCountryDto(String nameCountryDto) {
        this.nameCountryDto = nameCountryDto;
    }
}
