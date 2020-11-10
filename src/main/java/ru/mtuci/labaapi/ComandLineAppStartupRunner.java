package ru.mtuci.labaapi;
//Обращение к базе данных через объеекты Java

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.mtuci.labaapi.dao.IndividualRepository;

@Component
public class ComandLineAppStartupRunner {

    private final IndividualRepository individualRepository;

    @Autowired
    public ComandLineAppStartupRunner(IndividualRepository individualRepository) {
        this.individualRepository = individualRepository;
    }


    public void run(String...args) throws Exception {
        //System.out.println(individualRepository.findAll());
    }
}
