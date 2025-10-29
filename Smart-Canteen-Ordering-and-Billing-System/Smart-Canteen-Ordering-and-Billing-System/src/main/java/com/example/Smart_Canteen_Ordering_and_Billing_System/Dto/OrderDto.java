package com.example.Smart_Canteen_Ordering_and_Billing_System.Dto;

import java.math.BigDecimal;
import java.util.List;

public class OrderDto {
    private Long userId;
    private List<OrderItemDto> items;
    private BigDecimal totalAmount;
    
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public List<OrderItemDto> getItems() { return items; }
    public void setItems(List<OrderItemDto> items) { this.items = items; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
}