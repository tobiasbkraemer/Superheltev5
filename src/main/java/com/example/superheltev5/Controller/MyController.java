package com.example.superheltev5.Controller;

import com.example.superheltev5.DTO.CityDTO;
import com.example.superheltev5.DTO.CountPowerDTO;
import com.example.superheltev5.DTO.HeroPowerDTO;
import com.example.superheltev5.DTO.SuperheroDTO;
import com.example.superheltev5.Modul.Superhero;
import com.example.superheltev5.Repository.Repository;
import com.example.superheltev5.Service.MyService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
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

    Repository repository;
    public MyController(ApplicationContext context, @Value("${superhero.repository.impl}") String impl){
        repository = (Repository) context.getBean(impl);
    }

    /*
    @GetMapping(path = "/superheroes")
    public String getSuperheroes(Model model) {
        List<Superhero> superheroesList = myService.getSuperheroes();
        model.addAttribute("Heroes",superheroesList);
        return "index";
    }

     */

    @GetMapping(path = "/superheroes")
    public String getSuperheroes(Model model) {
        model.addAttribute("Heroes",repository.getSuperheroes());
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

    @GetMapping(path = "superhero/add")
    public String showCreateHero(Model model){
        SuperheroDTO superhero = new SuperheroDTO();
        model.addAttribute("superhero", superhero);
        model.addAttribute("cities", repository.getCities());
        model.addAttribute("powers", repository.getPowers());
        return "createSuperhero";
    }

    @PostMapping(path = "superhero/add")
    public String addHero(@ModelAttribute("superhero") SuperheroDTO superheroDTO){
        repository.addSuperHero(superheroDTO);
        return "redirect:/kea/superhero";
    }

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
