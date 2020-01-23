package com.example.demo.Dto;

public class DtoSpeaker {

    private String nameSpkDto;
    private String descSpkDto;
    private String positionSpkDto;
    private DtoCountry countrySpkDto;

    public String getNameSpkDto() {
        return nameSpkDto;
    }

    public void setNameSpkDto(String nameSpkDto) {
        this.nameSpkDto = nameSpkDto;
    }

    public String getDescSpkDto() {
        return descSpkDto;
    }

    public void setDescSpkDto(String descSpkDto) {
        this.descSpkDto = descSpkDto;
    }

    public String getPositionSpkDto() {
        return positionSpkDto;
    }

    public void setPositionSpkDto(String positionSpkDto) {
        this.positionSpkDto = positionSpkDto;
    }

    public DtoCountry getCountrySpkDto() {
        return countrySpkDto;
    }

    public void setCountrySpkDto(DtoCountry countrySpkDto) {
        this.countrySpkDto = countrySpkDto;
    }

}
