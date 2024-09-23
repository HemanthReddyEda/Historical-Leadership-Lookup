package com.example.Historical_Leadership_Lookup.service;

import com.example.Historical_Leadership_Lookup.model.Historicalmodel;
import com.example.Historical_Leadership_Lookup.repository.HistoricalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class Historicalservice {
    @Autowired
    private HistoricalRepo historicalRepo;

    public void save(Historicalmodel hm) {
        historicalRepo.save(hm);
    }

    public Historicalmodel get(String description) {
        return historicalRepo.findByDescription(description);
    }

    public Iterable<Historicalmodel> getall() {
        return historicalRepo.findAll();
    }
    public Iterable<Historicalmodel> getPrimeminister() {
        return (Iterable<Historicalmodel>) historicalRepo.findByDescription("Prime Minister");
    }

    public Iterable<Historicalmodel> getPresident() {
        return (Iterable<Historicalmodel>) historicalRepo.findByDescription("President");
    }


    public List<String> getPrimeministerByYear(int year) {
        LocalDate sDate = LocalDate.ofYearDay(year, 1);
        LocalDate eDate = LocalDate.ofYearDay(year, 365);
        List<Historicalmodel> leader=historicalRepo.findByYearRange(sDate, eDate);


        return leader.stream().filter(h->h.getDescription().equals("Prime Minister")).map(Historicalmodel::getName).collect(Collectors.toList());
    }

    public List<String> getPresidentByYear(int year) {
        LocalDate sDate = LocalDate.ofYearDay(year, 1);
        LocalDate eDate = LocalDate.ofYearDay(year, 365);
        List<Historicalmodel> leader=historicalRepo.findByYearRange(sDate, eDate);
        return leader.stream().filter(h->h.getDescription().equals("President")).map(Historicalmodel::getName).collect(Collectors.toList());
    }
}
