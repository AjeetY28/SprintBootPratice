package com.homeWorkLecture2.Lecture2HomeWork;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Lecture2HomeWorkApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Lecture2HomeWorkApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		System.out.println("creating only project structure");

	}
}
