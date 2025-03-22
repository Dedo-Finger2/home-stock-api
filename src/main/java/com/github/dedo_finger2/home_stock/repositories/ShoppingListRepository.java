package com.github.dedo_finger2.home_stock.repositories;

import com.github.dedo_finger2.home_stock.entities.ShoppingListEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoppingListRepository extends JpaRepository<ShoppingListEntity, Long> {
}
