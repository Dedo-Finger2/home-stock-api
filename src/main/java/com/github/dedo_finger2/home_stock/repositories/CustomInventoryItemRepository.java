package com.github.dedo_finger2.home_stock.repositories;

import com.github.dedo_finger2.home_stock.entities.InventoryItemEntity;

import java.util.List;

public interface CustomInventoryItemRepository {
    List<InventoryItemEntity> findAllNeedingToBuyItems();
    List<InventoryItemEntity> findAllOutOfDateItems();
}
