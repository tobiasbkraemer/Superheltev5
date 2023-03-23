package com.example.superheltev5.Service;
import com.example.superheltev5.DTO.CityDTO;
import com.example.superheltev5.DTO.CountPowerDTO;
import com.example.superheltev5.DTO.HeroPowerDTO;
import com.example.superheltev5.DTO.SuperheroDTO;
import com.example.superheltev5.Modul.Superhero;
import com.example.superheltev5.Repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MyService {

    MyRepository myRepository;

    @Autowired
    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public List<Superhero> getSuperheroes() {
        return myRepository.getSuperheroes();
    }

    public HeroPowerDTO heroPowerDTO (String name) {
        return myRepository.heroPower(name);
    }

    public CityDTO cityDTO(String name) {
        return myRepository.heroCity(name);
    }

    public CountPowerDTO countPowerDTO(String name) {
        return myRepository.heroPowerCount(name);
    }

    public void addSuperhero(SuperheroDTO superheroDTO) {
        myRepository.addSuperHero(superheroDTO);
    }
}