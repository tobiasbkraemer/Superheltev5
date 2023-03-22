package com.example.superheltev5.DTO;

public class HeroPowerDTO {
    private String heroName;
    private String realName;
    private String superPower;

    public HeroPowerDTO(String heroName, String realName, String superPower) {
        this.heroName = heroName;
        this.realName = realName;
        this.superPower = superPower;
    }

    public String getHeroName() {
        return heroName;
    }

    public String getRealName() {
        return realName;
    }

    public String getSuperPower() {
        return superPower;
    }
}
