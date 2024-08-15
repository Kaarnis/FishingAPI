package com.example.fishingapi.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Value;

@Value
public class CatchRequestDTO {
    @NotNull
    String fish;

    @NotNull
    @Min(value = 1, message = "Weight must be at least 1 gram") Integer weight;  // Weight in grams

    @NotNull
    @Min(value = 1, message = "Length must be at least 1 cm") Integer length;  // Length in centimeters

    @NotNull
    String location;
}
