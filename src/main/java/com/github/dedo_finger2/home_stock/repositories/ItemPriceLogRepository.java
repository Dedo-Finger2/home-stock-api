package com.github.dedo_finger2.home_stock.repositories;

import com.github.dedo_finger2.home_stock.entities.ItemPriceLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPriceLogRepository extends JpaRepository<ItemPriceLogEntity, Long> {
}
