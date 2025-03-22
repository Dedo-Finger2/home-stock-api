package com.github.dedo_finger2.home_stock.repositories;

import com.github.dedo_finger2.home_stock.entities.InventoryItemEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class CustomInventoryItemRepositoryImpl implements CustomInventoryItemRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<InventoryItemEntity> findAllNeedingToBuyItems() {
        return this.entityManager.createQuery("""
                select i from InventoryItemEntity i where i.minQuantity > i.currentQuantity
                """, InventoryItemEntity.class).getResultList();
    }

    @Override
    public List<InventoryItemEntity> findAllOutOfDateItems() {
        return this.entityManager.createQuery("""
                select i from InventoryItemEntity i where datediff(day, i.validUntil, current_timestamp) > 1
                """, InventoryItemEntity.class).getResultList();
    }
}
