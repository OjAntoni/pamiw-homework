package com.example.pamiw.web.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CompetitorFilter {
    private String name;
    private String surname;
    private String country;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private int heightFrom;
    private int heightTo;
    private int weightFrom;
    private int weightTo;
}
