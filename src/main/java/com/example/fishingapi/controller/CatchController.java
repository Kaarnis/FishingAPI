package com.example.fishingapi.controller;


import com.example.fishingapi.CatchService;
import com.example.fishingapi.dto.Catch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CatchController {

    CatchService catchService;

    public CatchController(CatchService catchService) {
        this.catchService = catchService;
    }

    @GetMapping("/catch")
    public List<Catch> getAllCatches() {
        return catchService.getAllCatches();
    }

    @PostMapping("/catch")
    public Catch catchFish() {
        return new Catch("Bass", "3 lbs", "Lake Erie");
    }
}
