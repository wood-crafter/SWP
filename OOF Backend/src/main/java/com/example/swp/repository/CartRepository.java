package com.example.swp.repository;

import com.example.swp.entity.Cart;
import com.example.swp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Float> {
    @Query("select c from Cart c where c.user.id = :userId and c.productStocktaking.id = :productSizeId")
    Cart findByUserIdAndProductStocktakingId(@Param("userId") Float userId, @Param("productSizeId") Float productSizeId);

    List<Cart> findByUser(User user);
    void deleteByUserAndProductStocktaking_id(User user, Float productSizeId);
;}
