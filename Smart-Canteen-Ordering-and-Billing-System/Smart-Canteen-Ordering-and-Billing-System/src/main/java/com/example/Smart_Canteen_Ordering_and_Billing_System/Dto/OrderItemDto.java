package com.example.Smart_Canteen_Ordering_and_Billing_System.Dto;

import java.math.BigDecimal;

public class OrderItemDto {
    private Long menuItemId;
    private Integer quantity;
    private BigDecimal price;
    
    public Long getMenuItemId() { return menuItemId; }
    public void setMenuItemId(Long menuItemId) { this.menuItemId = menuItemId; }
    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }
    public BigDecimal getPrice() { return price; }
    public void setPrice(BigDecimal price) { this.price = price; }
}