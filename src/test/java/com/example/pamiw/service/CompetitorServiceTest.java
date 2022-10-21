package com.example.pamiw.service;

import com.example.pamiw.repository.CompetitorRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;

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
    void save() {
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