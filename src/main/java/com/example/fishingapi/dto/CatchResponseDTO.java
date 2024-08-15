package com.example.fishingapi.dto;

import lombok.Setter;
import lombok.Value;

@Value
@Setter
public class CatchResponseDTO {
    Integer id;
    String fish;
    Integer weight;
    Integer length;
    String location;
}
