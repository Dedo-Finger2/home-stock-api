package com.github.dedo_finger2.home_stock.repositories;

import com.github.dedo_finger2.home_stock.entities.CompletedShoppingListItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompletedShoppingListItemRepository extends JpaRepository<CompletedShoppingListItemEntity, Long> {
}
