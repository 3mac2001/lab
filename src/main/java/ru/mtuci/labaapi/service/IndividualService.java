package ru.mtuci.labaapi.service;

import ru.mtuci.labaapi.model.Individual;

import java.util.List;

public interface IndividualService {

    Individual get(Long id);

    List<Individual> getAll();

    Individual save(Individual individual);

    void delete(Long id);



}
