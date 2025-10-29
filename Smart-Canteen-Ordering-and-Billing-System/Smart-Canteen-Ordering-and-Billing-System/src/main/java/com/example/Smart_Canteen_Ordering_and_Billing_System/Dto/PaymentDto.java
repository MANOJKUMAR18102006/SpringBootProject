package com.example.Smart_Canteen_Ordering_and_Billing_System.Dto;

import java.math.BigDecimal;

public class PaymentDto {
    private Long orderId;
    private BigDecimal amount;
    private String paymentMethod;
    
    public Long getOrderId() { return orderId; }
    public void setOrderId(Long orderId) { this.orderId = orderId; }
    public BigDecimal getAmount() { return amount; }
    public void setAmount(BigDecimal amount) { this.amount = amount; }
    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }
}