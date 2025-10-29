package com.example.Smart_Canteen_Ordering_and_Billing_System.Dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class ReceiptDto {
    private Long orderId;
    private String customerName;
    private List<ReceiptItemDto> items;
    private BigDecimal totalAmount;
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private String status;
    
    public static class ReceiptItemDto {
        private String itemName;
        private Integer quantity;
        private BigDecimal price;
        private BigDecimal subtotal;
        
        public String getItemName() { return itemName; }
        public void setItemName(String itemName) { this.itemName = itemName; }
        public Integer getQuantity() { return quantity; }
        public void setQuantity(Integer quantity) { this.quantity = quantity; }
        public BigDecimal getPrice() { return price; }
        public void setPrice(BigDecimal price) { this.price = price; }
        public BigDecimal getSubtotal() { return subtotal; }
        public void setSubtotal(BigDecimal subtotal) { this.subtotal = subtotal; }
    }
    
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public String getCustomerName() { return customerName; }
    public void setCustomerName(String customerName) { this.customerName = customerName; }
    public List<ReceiptItemDto> getItems() { return items; }
    public void setItems(List<ReceiptItemDto> items) { this.items = items; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public void setTotalAmount(BigDecimal totalAmount) { this.totalAmount = totalAmount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
    public LocalDateTime getPaymentDate() { return paymentDate; }
    public void setPaymentDate(LocalDateTime paymentDate) { this.paymentDate = paymentDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
