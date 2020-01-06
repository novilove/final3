package com.example.demo.Dto;

public class DtoLogin {
    private Long idDto;
    private String nameDto;
    private Integer ageDto;
    private String emailDto;
    private String passwordDto;

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
