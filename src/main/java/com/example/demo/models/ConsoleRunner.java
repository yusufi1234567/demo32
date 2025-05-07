package com.example.demo.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ConsoleRunner implements CommandLineRunner {

    @Autowired
    HockeyPlayerRepository hockeyPlayerRepository;

    @Override
    public void run(String... args) throws Exception {
        if(hockeyPlayerRepository.count() == 0) {
            HockeyPlayer hockeyPlayer = new HockeyPlayer();
            hockeyPlayer.setAge(33);
            hockeyPlayer.setName("Alex");
            hockeyPlayerRepository.save(hockeyPlayer);

            hockeyPlayer = new HockeyPlayer();
            hockeyPlayer.setAge(22);
            hockeyPlayer.setName("Bob");
            hockeyPlayerRepository.save(hockeyPlayer);
        }
        // kolla om count(*) = 0
        // insert into HockeyPlayer

    }

}