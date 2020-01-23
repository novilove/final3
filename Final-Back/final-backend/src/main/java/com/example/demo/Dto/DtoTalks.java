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
    private DtoSalonRoom nameSalonRoomDto;

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
}
