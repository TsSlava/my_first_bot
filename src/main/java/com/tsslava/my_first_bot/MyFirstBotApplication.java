package com.tsslava.my_first_bot;

import com.tsslava.my_first_bot.service.Tracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class MyFirstBotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(MyFirstBotApplication.class, args);

	}

}
