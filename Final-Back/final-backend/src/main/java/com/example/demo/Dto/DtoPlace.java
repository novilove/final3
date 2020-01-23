package com.example.demo.Dto;

public class DtoPlace {
    private String namePlaceDto;
    private String adressPlaceDto;
    private String cityPlaceDto;
    private DtoCountry countryPlaceDto;

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

    public DtoCountry getCountryPlaceDto() {
        return countryPlaceDto;
    }

    public void setCountryPlaceDto(DtoCountry countryPlaceDto) {
        this.countryPlaceDto = countryPlaceDto;
    }
}
