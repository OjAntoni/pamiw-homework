package com.example.pamiw.repository;

import com.example.pamiw.domain.Competitor;
import com.example.pamiw.web.dto.CompetitorFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBCompetitorRepository implements CompetitorRepository{
    @Autowired
    private CompetitorSpringDataRepository competitorRepository;
    @Override
    public int save(Competitor competitor) {
        Competitor save = competitorRepository.save(competitor);
        return save.getId();
    }

    @Override
    public void delete(int id) {
        competitorRepository.deleteById(id);
    }

    @Override
    public List<Competitor> getAll() {
        return competitorRepository.findAll();
    }

    @Override
    public List<Competitor> getAll(int perPage, int page) {
        return competitorRepository.findAll(PageRequest.of(page, perPage)).getContent();
    }

    @Override
    public List<Competitor> getAll(int perPage, int page, CompetitorFilter filter) {
        return competitorRepository.findAllByCountryAndNameAndSurnameAndDateOfBirthBetweenAndHeightBetweenAndWeightBetween(
                filter.getCountry(), filter.getName(), filter.getSurname(), filter.getDateFrom(), filter.getDateTo(),
                filter.getHeightFrom(), filter.getHeightTo(), filter.getWeightFrom(), filter.getWeightTo(),
                PageRequest.of(page, perPage)
        );
    }

    public List<Competitor> findByNameOrUsername(String text){
        return competitorRepository.findAllByNameContainingOrSurnameContaining(text, text);
    }

    @Override
    public Competitor get(int id) {
        return competitorRepository.findById(id).orElse(null);
    }
}
