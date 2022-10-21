package com.example.pamiw.service;

import com.example.pamiw.domain.Competitor;
import com.example.pamiw.repository.CompetitorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;

import java.util.concurrent.atomic.AtomicInteger;

class CompetitorServiceTest {

    private CompetitorRepository mock;
    private CompetitorService competitorService;

    @BeforeEach
    void setUp() {
        mock = Mockito.mock(CompetitorRepository.class);
        competitorService = new CompetitorService(mock);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void save() {
        AtomicInteger index = new AtomicInteger();
        Mockito.when(mock.save(ArgumentMatchers.notNull())).
                then(invocation ->
                    Competitor.builder().id(index.incrementAndGet()).build()
                    );

        Competitor competitor = new Competitor();
        int id = 0;
        for(int i = 0; i < 10; i++){
            int returnedIndex = competitorService.save(competitor);
            Assertions.assertEquals(++id, returnedIndex);
        }

        Mockito.verify(mock, Mockito.times(10)).save(ArgumentMatchers.notNull());
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    @Test
    void testDelete() {
    }

    @Test
    void get() {
    }

    @Test
    void testGet() {
    }

    @Test
    void testGet1() {
    }

    @Test
    void findByUsernameOrName() {
    }
}