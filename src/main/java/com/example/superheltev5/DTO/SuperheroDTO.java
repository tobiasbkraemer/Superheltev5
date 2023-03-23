package com.example.superheltev5.DTO;

import java.util.List;

public class SuperheroDTO {

    List<String> powerList;
    private String heroName;
    private String realName;
    private int creationYear;
    private String city;

    public SuperheroDTO(String heroName, String realName, int creationYear, String city, List<String> powerList) {
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.city = city;
        this.powerList=powerList;
    }

    public SuperheroDTO () {
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public int getCreationYear() {
        return creationYear;
    }

    public void setHeroName(String heroName) {
        this.heroName = heroName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setCreationYear(int creationYear) {
        this.creationYear = creationYear;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    public List<String> getPowerList() {
        return powerList;
    }

    public void setPowerList(List<String> powerList) {
        this.powerList = powerList;
    }
}