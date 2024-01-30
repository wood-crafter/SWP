package com.example.swp.repository;

import com.example.swp.entity.ProductStocktaking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductStocktakingRepository extends JpaRepository<ProductStocktaking, Float> {
}
