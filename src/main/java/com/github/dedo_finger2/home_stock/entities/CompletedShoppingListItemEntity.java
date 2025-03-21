package com.github.dedo_finger2.home_stock.entities;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "completed_shopping_list_items")
public class CompletedShoppingListItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "shopping_list_item_id", nullable = false)
    private ShoppingListItemEntity shoppingListItem;

    @Column(name = "quantity_bought", nullable = false)
    private float quantityBought;

    @Column(name = "unit_price_paid")
    private BigDecimal unitPricePaid;

    public CompletedShoppingListItemEntity() {
    }

    public CompletedShoppingListItemEntity(Long id, ShoppingListItemEntity shoppingListItem, float quantityBought, BigDecimal unitPricePaid) {
        this.id = id;
        this.shoppingListItem = shoppingListItem;
        this.quantityBought = quantityBought;
        this.unitPricePaid = unitPricePaid;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingListItemEntity getShoppingListItem() {
        return shoppingListItem;
    }

    public void setShoppingListItem(ShoppingListItemEntity shoppingListItem) {
        this.shoppingListItem = shoppingListItem;
    }

    public float getQuantityBought() {
        return quantityBought;
    }

    public void setQuantityBought(float quantityBought) {
        this.quantityBought = quantityBought;
    }

    public BigDecimal getUnitPricePaid() {
        return unitPricePaid;
    }

    public void setUnitPricePaid(BigDecimal unitPricePaid) {
        this.unitPricePaid = unitPricePaid;
    }
}
