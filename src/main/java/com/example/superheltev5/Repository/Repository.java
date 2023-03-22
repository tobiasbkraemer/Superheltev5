package com.example.superheltev5.Repository;

import com.example.superheltev5.DTO.CityDTO;
import com.example.superheltev5.DTO.CountPowerDTO;
import com.example.superheltev5.DTO.HeroPowerDTO;
import com.example.superheltev5.Modul.Superhero;

import java.util.List;

public interface Repository {

    public List<Superhero> getSuperheroes();

    public HeroPowerDTO heroPower(String name);

    public CityDTO heroCity(String name);

    public CountPowerDTO heroPowerCount(String name);

}
