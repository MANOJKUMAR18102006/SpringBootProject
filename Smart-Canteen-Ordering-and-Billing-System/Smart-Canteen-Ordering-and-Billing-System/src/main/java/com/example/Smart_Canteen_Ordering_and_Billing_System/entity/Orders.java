package com.example.Smart_Canteen_Ordering_and_Billing_System.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
    private BigDecimal totalAmount;
    private String status = "PENDING";
    private LocalDateTime orderDate = LocalDateTime.now();
    
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<OrdersItem> orderItems;
}
