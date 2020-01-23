package com.example.demo.Dto;

public class DtoSalonRoom {
    private String nameSalonDto;
    private Integer capSalonDto;
    private DtoPlace placeSalonDto;

    public String getNameSalonDto() {
        return nameSalonDto;
    }

    public void setNameSalonDto(String nameSalonDto) {
        this.nameSalonDto = nameSalonDto;
    }

    public Integer getCapSalonDto() {
        return capSalonDto;
    }

    public void setCapSalonDto(Integer capSalonDto) {
        this.capSalonDto = capSalonDto;
    }

    public DtoPlace getPlaceSalonDto() {
        return placeSalonDto;
    }

    public void setPlaceSalonDto(DtoPlace placeSalonDto) {
        this.placeSalonDto = placeSalonDto;
    }
}
