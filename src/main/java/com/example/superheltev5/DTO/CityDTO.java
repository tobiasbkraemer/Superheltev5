package com.example.superheltev5.DTO;

public class CityDTO {
    private String realName;
    private String city;

    public CityDTO(String realName, String city) {
        this.realName = realName;
        this.city = city;
    }

    public String getRealName() {
        return realName;
    }

    public String getCity() {
        return city;
    }
}