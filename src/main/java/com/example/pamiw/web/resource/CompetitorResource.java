package com.example.pamiw.web.resource;

import com.example.pamiw.domain.Competitor;
import com.example.pamiw.service.CompetitorService;
import com.example.pamiw.web.dto.CompetitorReqDto;
import com.example.pamiw.web.mapper.CompetitorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/competitor")
public class CompetitorResource {
    @Autowired
    private CompetitorMapper competitorMapper;
    @Autowired
    private CompetitorService competitorService;

    @PostMapping
    ResponseEntity<?> create(@RequestBody @Valid CompetitorReqDto dto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(e -> errors.add(e.getField()+" : "+e.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            int save = competitorService.save(competitorMapper.mapCompetitorReqDtoToCompetitor(dto));
            return ResponseEntity.ok().header("Location", save+"").build();
        }
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteCompetitor(@PathVariable int id){
        competitorService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(@RequestBody @Valid CompetitorReqDto dto, BindingResult bindingResult, @PathVariable int id){
        if (bindingResult.hasErrors()) {
            List<String> errors = new ArrayList<>();
            bindingResult.getFieldErrors().forEach(e -> errors.add(e.getField()+" : "+e.getDefaultMessage()));
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
        } else {
            Competitor competitor = competitorService.get(id);
            if(competitor==null){
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
            Competitor toUpdate = competitorMapper.mapCompetitorReqDtoToCompetitor(dto);
            toUpdate.setId(id);
            competitorService.save(toUpdate);
            return ResponseEntity.ok().build();
        }
    }
}
