package com.example.Smart_Canteen_Ordering_and_Billing_System.repository;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
