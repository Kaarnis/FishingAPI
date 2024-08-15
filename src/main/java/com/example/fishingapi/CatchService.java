package com.example.fishingapi;

import com.example.fishingapi.entity.Catch;
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
}
