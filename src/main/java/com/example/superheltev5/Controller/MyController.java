package com.example.superheltev5.Controller;

import com.example.superheltev5.DTO.CityDTO;
import com.example.superheltev5.DTO.CountPowerDTO;
import com.example.superheltev5.DTO.HeroPowerDTO;
import com.example.superheltev5.Modul.Superhero;
import com.example.superheltev5.Service.MyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(path = "kea")
public class MyController {
    private MyService myService;

    public MyController(MyService myService) {
        this.myService = myService;
    }

    @GetMapping(path = "/superheroes")
    public String getSuperheroes(Model model) {
        List<Superhero> superheroesList = myService.getSuperheroes();
        model.addAttribute("Heroes",superheroesList);
        return "index";
    }

    @GetMapping(path = "/superheroes/superpower/{name}")
    public String heroPowerByName(Model model, @PathVariable String name){
        HeroPowerDTO heroPowerByName = myService.heroPowerDTO(name);
        model.addAttribute("heroPowerByName",heroPowerByName);
        return "Powers";
    }

    /*
    @GetMapping(path = "/superheroes/superpower/{name}")
    public ResponseEntity<HeroPowerDTO> heroPowerByName(@PathVariable String name){
        HeroPowerDTO heroPowerDTO = myService.heroPowerDTO(name);
        return new ResponseEntity<>(heroPowerDTO,HttpStatus.OK);
    }

     */

    @GetMapping(path = "/city/{name}")
    public ResponseEntity<CityDTO> cityByHeroName(@PathVariable String name){
        CityDTO cityDTO = myService.cityDTO(name);
        return new ResponseEntity<>(cityDTO,HttpStatus.OK);
    }
    @GetMapping(path = "/superpower/count/{name}")
    public ResponseEntity<CountPowerDTO> powerCountByName(@PathVariable("name") String name) {
        CountPowerDTO countPowerDTO = myService.countPowerDTO(name);
        return new ResponseEntity<>(countPowerDTO, HttpStatus.OK);
    }
}
