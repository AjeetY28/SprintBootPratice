package com.jpatutorial.jpaTuts.repositories;

import com.jpatutorial.jpaTuts.entities.ProductEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {

     List<ProductEntity> findByTitle(String title, Pageable pageable);

    List<ProductEntity> findByCreatedAtAfterOrderByTitle(LocalDate after);

    List<ProductEntity> findByQuantityGreaterThanAndPriceLessThan(int quantity, BigDecimal price);

    List<ProductEntity> findByTitleContainingIgnoreCase(String title, Pageable pageable);

    @Query("select e from ProductEntity e where e.title = ?1 and e.price = ?2")
    Optional<ProductEntity> findByTitleAndPrice(String title,BigDecimal price);



}
