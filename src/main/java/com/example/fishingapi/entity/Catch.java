package com.example.fishingapi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.math.BigDecimal;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Catch {

    @Id
    private Integer id;
    private String fish;
    private String weight;
    private Integer length;
    private String location;

}
