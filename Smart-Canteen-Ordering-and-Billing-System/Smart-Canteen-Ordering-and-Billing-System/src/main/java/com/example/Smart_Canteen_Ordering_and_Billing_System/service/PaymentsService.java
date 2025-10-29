package com.example.Smart_Canteen_Ordering_and_Billing_System.service;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.*;
import com.example.Smart_Canteen_Ordering_and_Billing_System.Dto.PaymentDto;
import com.example.Smart_Canteen_Ordering_and_Billing_System.Dto.ReceiptDto;
import com.example.Smart_Canteen_Ordering_and_Billing_System.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;

@Service
public class PaymentsService {
    
    @Autowired
    private PaymentsRepository paymentsRepository;
    
    @Autowired
    private OrdersRepository ordersRepository;
    
    @Autowired
    private OrdersItemRepository ordersItemRepository;
    
    public Payments savePayment(Payments payment) {
        return paymentsRepository.save(payment);
    }
    
    public Payments getPaymentByOrder(Orders order) {
        return paymentsRepository.findByOrder(order);
    }
    
    public ReceiptDto processPaymentAndGenerateReceipt(PaymentDto paymentDto) {
        Orders order = ordersRepository.findById(paymentDto.getOrderId()).orElse(null);
        if (order == null) return null;
        
        Payments payment = new Payments();
        payment.setOrder(order);
        payment.setAmount(paymentDto.getAmount());
        payment.setPaymentMethod(paymentDto.getPaymentMethod());
        payment.setStatus("COMPLETED");
        paymentsRepository.save(payment);
        
        order.setStatus("PAID");
        ordersRepository.save(order);
        
        ReceiptDto receipt = new ReceiptDto();
        receipt.setOrderId(order.getId());
        receipt.setCustomerName(order.getUser().getUsername());
        receipt.setTotalAmount(order.getTotalAmount());
        receipt.setPaymentMethod(payment.getPaymentMethod());
        receipt.setPaymentDate(payment.getPaymentDate());
        receipt.setStatus(payment.getStatus());
        
        List<ReceiptDto.ReceiptItemDto> receiptItems = new ArrayList<>();
        for (OrdersItem item : order.getOrderItems()) {
            ReceiptDto.ReceiptItemDto receiptItem = new ReceiptDto.ReceiptItemDto();
            receiptItem.setItemName(item.getMenuItem().getName());
            receiptItem.setQuantity(item.getQuantity());
            receiptItem.setPrice(item.getPrice());
            receiptItem.setSubtotal(item.getPrice().multiply(java.math.BigDecimal.valueOf(item.getQuantity())));
            receiptItems.add(receiptItem);
        }
        receipt.setItems(receiptItems);
        
        return receipt;
    }
}