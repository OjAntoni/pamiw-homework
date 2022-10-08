package com.example.pamiw.repository;

import com.example.pamiw.domain.Competitor;
import com.example.pamiw.web.dto.CompetitorFilter;

import java.util.List;

public interface CompetitorRepository {
    int save(Competitor competitor);
    void delete(int id);
    List<Competitor> getAll();
    List<Competitor> getAll(int perPage, int page);
    List<Competitor> getAll(int perPage, int page, CompetitorFilter filter);

    Competitor get(int id);
}
