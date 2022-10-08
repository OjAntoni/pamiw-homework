package com.example.pamiw.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class Competitor {
    private int id;
    private String name;
    private String surname;
    private String country;
    private LocalDate dateOfBirth;
    private int height;
    private double weight;

}
