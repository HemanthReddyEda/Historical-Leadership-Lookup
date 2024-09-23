package com.example.Historical_Leadership_Lookup.controller;


import com.example.Historical_Leadership_Lookup.model.Historicalmodel;
import com.example.Historical_Leadership_Lookup.service.Historicalservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/historicalleader")
public class Historicalcontroller {
    @Autowired
    private Historicalservice historicalservice;

    @PostMapping("/add")
    public String add(@RequestBody Historicalmodel hm){
        historicalservice.save(hm);
        return "added";
    }

    @GetMapping("/get/{description}") //to get primeminister or president
    public Historicalmodel get(String description){
        return historicalservice.get(description);
    }
    @GetMapping("/getall")
    public Iterable<Historicalmodel> getall(){
        return historicalservice.getall();
    }
    @GetMapping("/getAllPrimeministers")
    public Iterable<Historicalmodel> getPrimeminister(){
        return historicalservice.getPrimeminister();
    }

    @GetMapping("/getAllPresidents")
    public Iterable<Historicalmodel> getPresident(){
        return historicalservice.getPresident();
    }

    @GetMapping("/getPriminister/{year}")
    public List<String> getPrimeministerByYear(@PathVariable int year){
        return historicalservice.getPrimeministerByYear(year);
    }
    @GetMapping("/getPresident/{year}")
    public List<String> getPresidentByYear(@PathVariable int year){
        return historicalservice.getPresidentByYear(year);
    }

}
