package com.example.pamiw.service;

import com.example.pamiw.domain.Competitor;
import com.example.pamiw.repository.CompetitorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

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
    void saveCompetitorTest() {
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
    void saveNullCompetitorTest() {
        Competitor competitor = null;
        int index = competitorService.save(competitor);

        Mockito.verify(mock, Mockito.times(0)).save(ArgumentMatchers.isNull());
        Assertions.assertEquals(-1, index);
    }

    @Test
    void isUpdateCorrectly_ArgumentIsNotNull_Update() {
        Competitor competitor = Competitor.builder().id(1).build();
        Mockito.when(mock.save(ArgumentMatchers.notNull())).thenReturn(competitor);
        for (int i = 1; i <= 10; i++) {
            competitorService.update(competitor);
        }
        Mockito.verify(mock, Mockito.times(10)).save(competitor);
    }

    @Test
    void isUpdateCorrectly_ArgumentIsNull_DoNothing() {
        Competitor competitor = null;
        for (int i = 1; i <= 10; i++) {
            competitorService.update(competitor);
        }
        Mockito.verify(mock, Mockito.times(0)).save(competitor);

    }

    @Test
    void deleteByIdTest() {
        Mockito.doNothing().when(mock).deleteById(1);
        competitorService.delete(1);
        Mockito.verify(mock, Mockito.times(1)).deleteById(1);
    }
    @Test
    void deleteNullByIdTest() {
        Mockito.doNothing().when(mock).deleteById(0);
        competitorService.delete(0);
        Mockito.verify(mock, Mockito.times(0)).deleteById(0);
    }

    @Test
    void deleteCompetitorTest() {
        Competitor competitor = new Competitor();
        Mockito.doNothing().when(mock).delete(competitor);
        competitorService.delete(competitor);
        Mockito.verify(mock, Mockito.times(1)).delete(competitor);
    }
    @Test
    void deleteNullCompetitorTest() {
        Competitor competitor = null;
        Mockito.doNothing().when(mock).delete(competitor);
        competitorService.delete(competitor);
        Mockito.verify(mock, Mockito.times(0)).delete(competitor);
    }

    @Test
    void get() {
    }

    @Test
    void isGetPageOfCompetitorCorrectly_ArgumentsArePositive_Return() {

        List<Competitor> expected = new ArrayList<>();
        int pageNumber = 1;
        int pageSize = 5;
        for (int i = 1; i <= 5; i++) {
            expected.add(Competitor.builder().id(i).build());
        }
        Pageable pageRequest = PageRequest.of(pageNumber, pageSize);
        PageImpl<Competitor> page = new PageImpl<>(expected, pageRequest, 5);
        Mockito.when(mock.findAll(PageRequest.of(pageNumber, pageSize))).thenReturn(page);
        List<Competitor> actual = competitorService.get(pageSize, pageNumber);
        assertEquals(actual, expected);
    }

    @Test
    void isGetPageOfCompetitorCorrectly_ArgemunetsAreNegative_Return() {
        List<Competitor> expected = new ArrayList<>();
        int pageNumber = -1;
        int pageSize = -5;
        List<Competitor> actual = competitorService.get(pageSize, pageNumber);
        assertEquals(actual, expected);
    }

    @Test
    void testGet1() {
    }

    @Test
    void findByUsernameOrName() {
        //
    }
}