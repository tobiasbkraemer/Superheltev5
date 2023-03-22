package com.example.superheltev5.DTO;

public class CountPowerDTO {
    private String superHeroName;
    private int countPower;

    public CountPowerDTO(String superHeroName, int countPower) {
        this.superHeroName = superHeroName;
        this.countPower = countPower;
    }

    public String getSuperHeroName() {
        return superHeroName;
    }

    public void setSuperHeroName(String superHeroName) {
        this.superHeroName = superHeroName;
    }

    public int getCountPower() {
        return countPower;
    }

    public void setCountPower(int countPower) {
        this.countPower = countPower;
    }

}