package com.github.dedo_finger2.home_stock.entities;

import jakarta.persistence.*;

import java.security.InvalidParameterException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "inventory_items", uniqueConstraints = {@UniqueConstraint(columnNames = {"inventory_id", "name"})})
public class InventoryItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inventory_id", nullable = false)
    private InventoryEntity inventory;

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @Column(name = "min_quantity", nullable = false)
    private float minQuantity;

    @Column(name = "current_quantity", nullable = false)
    private float currentQuantity;

    private boolean perishable;

    @Column(name = "valid_until")
    private LocalDate validUtil;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public InventoryItemEntity() {
        this.createdAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public InventoryEntity getInventory() {
        return inventory;
    }

    public void setInventory(InventoryEntity inventory) {
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3) throw new InvalidParameterException("name cannot be less than 3 characters");
        this.name = this.formatName(name);
    }

    private String formatName(String name) {
        String lowercase = name.toLowerCase();
        String[] eachWord = lowercase.split(" ");
        String[] upperWord = new String[eachWord.length];
        for (int i = 0; i < eachWord.length; i++) {
            if (!eachWord[i].isEmpty()) {
                upperWord[i] = eachWord[i].substring(0, 1).toUpperCase() + eachWord[i].substring(1).toLowerCase();
            }
        }
        return String.join(" ", upperWord);
    }

    public CategoryEntity getCategory() {
        return category;
    }

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public float getMinQuantity() {
        return minQuantity;
    }

    public void setMinQuantity(float minQuantity) throws IllegalArgumentException {
        if (minQuantity < 1) throw new IllegalArgumentException("minQuantity cannot be less than 1");
        this.minQuantity = minQuantity;
    }

    public float getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(float currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public boolean isPerishable() {
        return perishable;
    }

    public void setPerishable(boolean perishable) {
        this.perishable = perishable;
    }

    public LocalDate getValidUtil() {
        return validUtil;
    }

    public void setValidUtil(LocalDate validUtil) {
        this.validUtil = validUtil;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        InventoryItemEntity that = (InventoryItemEntity) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
