package com.example.pamiw.web.resource;

import com.example.pamiw.service.CompetitorService;
import com.example.pamiw.web.dto.CompetitorFilter;
import com.example.pamiw.web.mapper.CompetitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/competitors")
public class AllCompetitorsResource {
    @Autowired
    private CompetitorMapper competitorMapper;
    @Autowired
    private CompetitorService competitorService;

    @GetMapping
    ResponseEntity<?> getAll(@RequestParam int perPage,
                             @RequestParam int page,
                             @RequestBody(required = false) CompetitorFilter filter){
        if(filter!=null){
            return new ResponseEntity<>(competitorService.get(perPage, page, filter), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(competitorService.get(perPage, page), HttpStatus.OK);
        }
    }
}
