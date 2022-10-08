package com.example.pamiw.service;

import com.example.pamiw.domain.Competitor;
import com.example.pamiw.repository.CompetitorRepository;
import com.example.pamiw.web.dto.CompetitorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetitorService {
    @Autowired
    private CompetitorRepository competitorRepository;

    public int save(Competitor competitor){
        if(competitor==null) return -1;
        return competitorRepository.save(competitor);
    }

    public void update(Competitor competitor){
        if(competitor ==null) return;
        competitorRepository.save(competitor);
    }

    public void delete(int id){
        competitorRepository.delete(id);
    }

    public void delete(Competitor competitor){
        if(competitor==null) return;
        competitorRepository.delete(competitor.getId());
    }

    public Competitor get(int id){
        return competitorRepository.get(id);
    }

    public List<Competitor> get(int perPage, int page){
        return competitorRepository.getAll(perPage, page);
    }

    public List<Competitor> get(int perPage, int page, CompetitorFilter filter){
        return competitorRepository.getAll(perPage, page, filter);
    }
}
