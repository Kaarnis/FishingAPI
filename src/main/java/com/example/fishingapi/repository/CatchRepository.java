package com.example.fishingapi.repository;

import com.example.fishingapi.dto.Catch;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CatchRepository {

    private final List<Catch> catches = new ArrayList<>();

    public CatchRepository() {
        catches.add(new Catch("Bass", "3 lbs", "Lake Erie"));
        catches.add(new Catch("Trout", "2 lbs", "Lake Michigan"));
        catches.add(new Catch("Salmon", "5 lbs", "Pacific Ocean"));
    }

    public List<Catch> getAllCatches() {
        return new ArrayList<>(catches);
    }
}
