package com.github.dedo_finger2.home_stock.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "shopping_list_items", uniqueConstraints = @UniqueConstraint(columnNames = {"shopping_list_id", "inventory_item_id"}))
public class ShoppingListItemEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "shopping_list_id", nullable = false)
    private ShoppingListEntity shoppingList;

    @ManyToOne
    @JoinColumn(name = "inventory_item_id", nullable = false)
    private InventoryItemEntity inventoryItem;

    public ShoppingListItemEntity() {
    }

    public ShoppingListItemEntity(Long id, ShoppingListEntity shoppingList, InventoryItemEntity inventoryItem) {
        this.id = id;
        this.shoppingList = shoppingList;
        this.inventoryItem = inventoryItem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShoppingListEntity getShoppingList() {
        return shoppingList;
    }

    public void setShoppingList(ShoppingListEntity shoppingList) {
        this.shoppingList = shoppingList;
    }

    public InventoryItemEntity getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(InventoryItemEntity inventoryItem) {
        this.inventoryItem = inventoryItem;
    }
}
