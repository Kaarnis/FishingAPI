package com.example.fishingapi.mapper;

import com.example.fishingapi.dto.CatchRequestDTO;
import com.example.fishingapi.dto.CatchResponseDTO;
import com.example.fishingapi.entity.Catch;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EntityMapper {

    // Convert CatchRequestDTO to Catch entity
    public Catch toCatchEntity(CatchRequestDTO catchRequest) {
        Catch catchEntity = new Catch();
        catchEntity.setFish(catchRequest.getFish());
        catchEntity.setWeight(catchRequest.getWeight());
        catchEntity.setLength(catchRequest.getLength());
        catchEntity.setLocation(catchRequest.getLocation());
        return catchEntity;
    }

    // Convert Catch entity to CatchResponseDTO
    public CatchResponseDTO toCatchResponseDTO(Catch catchEntity) {
        return new CatchResponseDTO(
                catchEntity.getId(),
                catchEntity.getFish(),
                catchEntity.getWeight(),
                catchEntity.getLength(),
                catchEntity.getLocation()
        );
    }

    // Convert a list of Catch entities to a list of CatchResponseDTOs
    public List<CatchResponseDTO> toCatchResponseDTOs(List<Catch> catchEntities) {
        return catchEntities.stream()
                .map(this::toCatchResponseDTO)
                .collect(Collectors.toList());
    }
}