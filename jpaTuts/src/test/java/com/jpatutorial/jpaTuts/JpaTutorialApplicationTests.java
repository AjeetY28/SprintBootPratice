package com.jpatutorial.jpaTuts;

import com.jpatutorial.jpaTuts.entities.ProductEntity;
import com.jpatutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testRepository()
	{
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle123")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(100123.24))
				.quantity(12)
				.build();
		ProductEntity savedProductEntity =productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

}
