package com.example.fishingapi.controller;


import com.example.fishingapi.dto.CatchRequestDTO;
import com.example.fishingapi.dto.CatchResponseDTO;
import com.example.fishingapi.entity.Catch;
import com.example.fishingapi.mapper.EntityMapper;
import com.example.fishingapi.service.CatchService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/catches")
@Validated
public class CatchController {

    private final EntityMapper entityMapper;

    private final CatchService catchService;

    public CatchController(EntityMapper entityMapper, CatchService catchService) {
        this.entityMapper = entityMapper;
        this.catchService = catchService;
    }

    @PostMapping
    public ResponseEntity<CatchResponseDTO> catchFish(@Valid @RequestBody CatchRequestDTO catchRequest) {
        // Convert DTO to entity
        Catch catchEntity = entityMapper.toCatchEntity(catchRequest);

        // Save the entity
        Catch savedCatch = catchService.catchFish(catchEntity);

        // Convert saved entity to DTO
        CatchResponseDTO responseDTO = entityMapper.toCatchResponseDTO(savedCatch);

        // Return the response with 201 Created status
        return new ResponseEntity<>(responseDTO, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CatchResponseDTO> getCatch(@PathVariable Integer id) {
        Catch catchEntity = catchService.getCatchById(id);

        // Convert entity to DTO using the mapper
        CatchResponseDTO responseDTO = entityMapper.toCatchResponseDTO(catchEntity);

        return new ResponseEntity<>(responseDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<CatchResponseDTO>> getAllCatches() {
        List<Catch> catches = catchService.getAllCatches();

        // Convert entities to DTOs using the mapper
        List<CatchResponseDTO> responseDTOs = catches.stream()
                .map(entityMapper::toCatchResponseDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>(responseDTOs, HttpStatus.OK);
    }
}
