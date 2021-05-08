package com.selvam.hibernateexample;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.selvam.hibernateexample.model.OpenUser;
import com.selvam.hibernateexample.service.SoccerService;

@SpringBootApplication
public class SpringBootHibernateApplication implements CommandLineRunner{

	 @Autowired
	 SoccerService soccerService;
	 
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
	}
	
	
	@Override
    public void run(String... arg0) throws Exception {
        List<OpenUser> players = soccerService.getAllUsers();
        for(OpenUser player : players)
        {
            System.out.println("Introducing Barca player => " + player.getName());
        }
    }
}
