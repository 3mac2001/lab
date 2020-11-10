package ru.mtuci.labaapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mtuci.labaapi.dao.IndividualRepository;
import ru.mtuci.labaapi.model.Individual;

import java.util.List;

@Service
public class IndividualServiceImpl implements IndividualService {

    private final IndividualRepository IndividualRepository;

    @Autowired
    public IndividualServiceImpl(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;

    }
    @Override
    public Individual get(Long id) {
        return individualRepository.findById(id).orElse(null);
    }

    @Override
    public List<Individual> getAll() {
        return individualRepository.findAll();
    }

    @Override
    public Individual save(Individual individual) {
        return individualRepository.save(individual);
    }

    @Override
    public void delete(Long id) {
        individualRepository.delete(id);
    }
}
