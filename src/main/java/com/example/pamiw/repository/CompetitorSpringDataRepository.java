package com.example.pamiw.repository;

import com.example.pamiw.domain.Competitor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface CompetitorSpringDataRepository extends JpaRepository<Competitor, Integer> {
    List<Competitor> findAllByCountryAndNameAndSurnameAndDateOfBirthBetweenAndHeightBetweenAndWeightBetween(
            String country, String name, String surname, LocalDate from, LocalDate to, int hFrom, int hTo,
            double wFrom, double wTo, Pageable pageable
    );

    List<Competitor> findAllByNameContainingOrSurnameContaining(String name, String surname);
}
