package com.example.Spring_Boot_Beginner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ansi.AnsiColor;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.ansi.AnsiStyle;

@SpringBootApplication
public class SpringBootBeginnerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootBeginnerApplication.class, args);

		System.out.println(AnsiOutput.toString(AnsiStyle.BOLD, AnsiColor.GREEN, "Spring Boot Backend API Running Successfully!"));
	}

}