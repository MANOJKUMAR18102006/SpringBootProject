package com.example.Smart_Canteen_Ordering_and_Billing_System.controller;

import com.example.Smart_Canteen_Ordering_and_Billing_System.Dto.PaymentDto;
import com.example.Smart_Canteen_Ordering_and_Billing_System.Dto.ReceiptDto;
import com.example.Smart_Canteen_Ordering_and_Billing_System.service.PaymentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
public class PaymentsController {
    
    @Autowired
    private PaymentsService paymentsService;
    
    @PostMapping
    public ReceiptDto processPayment(@RequestBody PaymentDto paymentDto) {
        return paymentsService.processPaymentAndGenerateReceipt(paymentDto);
    }
}