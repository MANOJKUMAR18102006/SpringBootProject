package com.example.Smart_Canteen_Ordering_and_Billing_System.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Data
public class OrdersItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Orders order;
    
    @ManyToOne
    @JoinColumn(name = "menu_item_id")
    private MenuItem menuItem;
    
    private Integer quantity;
    private BigDecimal price;
}
