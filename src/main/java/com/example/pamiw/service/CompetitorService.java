package com.example.pamiw.service;

import com.example.pamiw.domain.Competitor;
import com.example.pamiw.repository.CompetitorRepository;
import com.example.pamiw.web.dto.CompetitorFilter;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CompetitorService {
    CompetitorRepository repository;

    public int save(Competitor competitor){
        if(competitor==null) return -1;
        return repository.save(competitor).getId();
    }

    public void update(Competitor competitor){
        if(competitor == null) return;
        repository.save(competitor);
    }

    public void delete(int id){
        repository.deleteById(id);
    }

    public void delete(Competitor competitor){
        if(competitor==null) return;
        repository.delete(competitor);
    }

    public Competitor get(int id){
        return repository.getById(id);
    }

    public List<Competitor> get(int perPage, int page){
        return repository.findAll(PageRequest.of(page, perPage)).getContent();
    }

    public List<Competitor> get(int perPage, int page, CompetitorFilter filter){
        return List.of();
    }

    public List<Competitor> findByUsernameOrName(String text){
        return repository.findAllByNameContainingOrSurnameContaining(text, text);
    }
}
