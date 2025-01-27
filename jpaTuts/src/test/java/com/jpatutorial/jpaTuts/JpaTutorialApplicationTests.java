package com.jpatutorial.jpaTuts;

import com.jpatutorial.jpaTuts.entities.ProductEntity;
import com.jpatutorial.jpaTuts.repositories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JpaTutorialApplicationTests {

	@Autowired
	ProductRepository productRepository;

//	@Test
//	void contextLoads() {
//	}

	@Test
	void testRepository()
	{
		ProductEntity productEntity = ProductEntity.builder()
				.sku("nestle23")
				.title("Nestle Chocolate")
				.price(BigDecimal.valueOf(23.45))
				.quantity(4)
				.build();
		ProductEntity savedProductEntity =productRepository.save(productEntity);
		System.out.println(savedProductEntity);
	}

	@Test
	void getRepository(){
//		List<ProductEntity> entities = productRepository.findByCreatedAtAfter(
//				LocalDate.of(2025,1,1));
//		List<ProductEntity> entities=productRepository.findByQuantityGreaterThanAndPriceLessThan(3,BigDecimal.valueOf(25.45));
		List<ProductEntity> entities=productRepository.findByTitleLike("%Choco%");
		System.out.println(entities);
	}

}
