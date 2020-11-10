package ru.mtuci.labaapi.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.mtuci.labaapi.model.Individual;
import ru.mtuci.labaapi.service.IndividualService;

import java.util.List;
javac main.java --class-path;

@Slf4j
@RestController
@RequestMapping(value = IndividualController.REST_URL, produces = MediaType.APPLICATION_JSON_VALUE)
public class IndividualController {
    public static final String REST_URL = "/api/v1/individual";


    private final IndividualService individualService;

    @Autowired
    public IndividualController(IndividualService individualService) {
        this.individualService = individualService;
    }

    @GetMapping(value = "/{id}")
    public Individual get(@PathVariable("id") Long id) {
        log.info("get" + id);
        return IndividualService.get(id);
    }


    @GetMapping
    public List<Individual> getAll() {
        log.info("getAll");
        return individualService.getAll();
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Individual save(@RequestBody Individual individual){
        log.info("save" + individual);
        return individualService.save(individual);
    }

    @DeleteMapping("/del/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Long id) {
        log.info("delete" + id);
        personService.delete(id);
    }
}
