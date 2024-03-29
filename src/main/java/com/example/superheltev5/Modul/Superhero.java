package com.example.superheltev5.Modul;

public class Superhero {

    private int heroID;
    private String heroName;
    private String realName;
    private int creationYear;
    private int powerID;
    private int cityID;

    public Superhero(int heroID, String heroName, String realName, int creationYear, int cityID) {
        this.heroID = heroID;
        this.heroName = heroName;
        this.realName = realName;
        this.creationYear = creationYear;
        this.cityID = cityID;
    }

    public int getHeroID() {
        return heroID;
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

    public int getSuperpowerID() {
        return powerID;
    }

    public int getCityID() {
        return cityID;
    }

    public void setHeroID(int heroID) {
        this.heroID = heroID;
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

    public void setPowerID(int powerID) {
        this.powerID = powerID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }
}
