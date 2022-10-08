package com.example.pamiw.repository;

import com.example.pamiw.domain.Competitor;
import com.example.pamiw.web.dto.CompetitorFilter;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class InMemoryCompetitorRepository implements CompetitorRepository{

    private final List<Competitor> all= new ArrayList<>(100);

    @Override
    public int save(Competitor competitor) {
        if(competitor.getId()==0){
            competitor.setId(new Random().nextInt());
            all.add(competitor);
        } else {
            all.remove(competitor);
            all.add(competitor);
        }
        return competitor.getId();
    }

    @Override
    public void delete(int id) {
        if(id==0) return;
        all.removeIf(o->o.getId()==id);
    }

    @Override
    public List<Competitor> getAll() {
        return new ArrayList<>(all);
    }

    @Override
    public List<Competitor> getAll(int perPage, int page) {
        if(perPage<=0 || page < 0) return new ArrayList<>();
        int startIndex = perPage*page;

        List<Competitor> toReturn = new ArrayList<>(perPage);

        for(int i = startIndex; i < all.size() && i-startIndex < perPage; i++){
            toReturn.add(all.get(i));
        }

        return toReturn;
    }

    @Override
    @SneakyThrows
    public List<Competitor> getAll(int perPage, int page, CompetitorFilter filter) {
        Stream<Competitor> stream = all.stream();
        if(filter.getName()!=null){
            stream =stream.filter(c -> c.getName().contains(filter.getName()));
        }
        if(filter.getSurname()!=null){
            stream =stream.filter(c -> c.getSurname().contains(filter.getSurname()));
        }
        if(filter.getCountry()!=null){
            stream =stream.filter(c -> c.getCountry().contains(filter.getCountry()));
        }
        if(filter.getDateFrom()!=null){
            stream =stream.filter(c -> c.getDateOfBirth().isAfter(filter.getDateFrom()));
        }
        if(filter.getDateTo()!=null){
            stream =stream.filter(c -> c.getDateOfBirth().isBefore(filter.getDateTo()));
        }
        stream = stream.filter(c -> c.getHeight() >= filter.getHeightFrom());
        if(filter.getHeightTo() > 0){
            stream = stream.filter(c -> c.getHeight() <= filter.getHeightTo());
        }
        stream = stream.filter(c -> c.getWeight() >= filter.getWeightFrom());
        if(filter.getWeightTo() > 0){
            stream = stream.filter(c -> c.getWeight() <= filter.getWeightTo());
        }
        return stream.collect(Collectors.toList());
    }

    @Override
    public Competitor get(int id) {
        List<Competitor> collect = all.stream().filter(c -> c.getId() == id).collect(Collectors.toList());
        return collect.size()==0 ? null : collect.get(0);
    }
}
