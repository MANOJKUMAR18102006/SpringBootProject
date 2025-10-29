package com.example.Smart_Canteen_Ordering_and_Billing_System.repository;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.Payments;
import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {
    Payments findByOrder(Orders order);
}