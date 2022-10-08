package com.example.pamiw.web.dto;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
public class CompetitorReqDto {
    @NotNull @NotEmpty
    private String name;
    @NotNull @NotEmpty
    private String surname;
    @NotNull @NotEmpty
    private String country;
    @NotNull
    private LocalDate dateOfBirth;
    @Positive
    private int height;
    @Positive
    private double weight;

}
