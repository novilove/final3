package com.example.demo.Dto;

import javax.persistence.Column;

public class DtoLogin {
    private Long idDto;
    private String nameDto;
    private Integer ageDto;
    private String emailDto;
    private String passwordDto;
    private String lastNameDto;
    private String genreDto;

    public String getLastNameDto() {
        return lastNameDto;
    }

    public void setLastNameDto(String lastNameDto) {
        this.lastNameDto = lastNameDto;
    }

    public String getGenreDto() {
        return genreDto;
    }

    public void setGenreDto(String genreDto) {
        this.genreDto = genreDto;
    }

    public Long getIdDto() {
        return this.idDto;
    }

    public void setIdDto(Long idDto) {
        this.idDto = idDto;
    }

    public String getNameDto() {
        return nameDto;
    }

    public void setNameDto(String nameDto) {
        this.nameDto = nameDto;
    }

    public Integer getAgeDto() {
        return ageDto;
    }

    public void setAgeDto(Integer ageDto) {
        this.ageDto = ageDto;
    }

    public String getEmailDto() {
        return this.emailDto;
    }

    public void setEmailDto(String emailDto) {
        this.emailDto = emailDto;
    }

    public String getPasswordDto() {
        return passwordDto;
    }

    public void setPasswordDto(String passwordDto) {
        this.passwordDto = passwordDto;
    }
}
