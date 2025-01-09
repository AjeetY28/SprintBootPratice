package com.AliceBakery.CakeBakeryShop;

<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
@SpringBootApplication
public class CakeBakeryShopApplication implements CommandLineRunner {

	@Autowired
	CakeBaker cakeBaker;
=======
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CakeBakeryShopApplication {
>>>>>>> e935f5b742f5b3a2e2dce354498362a7c05acdfc

	public static void main(String[] args) {
		SpringApplication.run(CakeBakeryShopApplication.class, args);
	}

<<<<<<< HEAD
	@Override
	public void run(String... args) throws Exception {
		System.out.println(cakeBaker.bakeCalled());
	}
=======
>>>>>>> e935f5b742f5b3a2e2dce354498362a7c05acdfc
}
