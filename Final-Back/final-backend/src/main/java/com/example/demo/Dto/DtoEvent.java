package com.example.demo.Dto;

public class DtoEvent {

    //event
    private String nameEventDto;
    private Integer durationEventDto;
    private String descriptionEventDto;
    private String dateEventDto;

    public String getNameEventDto() {
        return nameEventDto;
    }

    public void setNameEventDto(String nameEventDto) {
        this.nameEventDto = nameEventDto;
    }

    public Integer getDurationEventDto() {
        return durationEventDto;
    }

    public void setDurationEventDto(Integer durationEventDto) {
        this.durationEventDto = durationEventDto;
    }

    public String getDescriptionEventDto() {
        return descriptionEventDto;
    }

    public void setDescriptionEventDto(String descriptionEventDto) {
        this.descriptionEventDto = descriptionEventDto;
    }

    public String getDateEventDto() {
        return dateEventDto;
    }

    public void setDateEventDto(String dateEventDto) {
        this.dateEventDto = dateEventDto;
    }
}
