package com.example.Historical_Leadership_Lookup.repository;

import com.example.Historical_Leadership_Lookup.model.Historicalmodel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface HistoricalRepo extends JpaRepository<Historicalmodel,Integer>{

    Historicalmodel findByDescription(String description);

    List<Historicalmodel> findByStartDateBetween(LocalDate startDate, LocalDate endDate);

    // Alternatively, using a custom query to find by year if needed
    @Query("SELECT h FROM Historicalmodel h WHERE h.startDate <= :endDate AND h.endDate >= :startDate")
    List<Historicalmodel> findByYearRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    Historicalmodel findNearestPresident(int year);
}
