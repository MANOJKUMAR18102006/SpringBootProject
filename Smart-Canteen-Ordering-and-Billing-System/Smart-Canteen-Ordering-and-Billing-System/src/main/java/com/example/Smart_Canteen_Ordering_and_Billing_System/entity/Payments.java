package com.example.Smart_Canteen_Ordering_and_Billing_System.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
public class Payments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    @JoinColumn(name = "order_id")
    private Orders order;
    
    private BigDecimal amount;
    private String paymentMethod;
    private String status = "PENDING";
    private LocalDateTime paymentDate = LocalDateTime.now();
}
