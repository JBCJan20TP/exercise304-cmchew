package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    LuxuryRepository repository;

    @Override
    public void run(String... strings) throws Exception{
        Luxury luxury = new Luxury( "2019", "Audi", "RS3");
        repository.save(luxury);

        luxury = new Luxury("2019", "Porsche", "718");
        repository.save(luxury);

        luxury = new Luxury("2019", "Volvo", "XC40");
        repository.save(luxury);
    }
}
