package com.example.fishingapi.service;

import com.example.fishingapi.entity.Catch;
import com.example.fishingapi.exception.ResourceNotFoundException;
import com.example.fishingapi.repository.CatchRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatchService {

    CatchRepository catchRepository;

    public CatchService(CatchRepository catchRepository) {
        this.catchRepository = catchRepository;
    }

    public List<Catch> getAllCatches() {
        return catchRepository.findAll();
    }

    public Catch catchFish(Catch fish) {
        return catchRepository.save(fish);
    }

    public Catch getCatchById(Integer id) {
        return catchRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Catch not found with id: " + id));
    }
}
