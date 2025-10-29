package com.example.Smart_Canteen_Ordering_and_Billing_System.service;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.User;
import com.example.Smart_Canteen_Ordering_and_Billing_System.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    public void saveUser(User user){
        userRepo.save(user);
    }

    public User findByUsername(String username){
        return userRepo.findByUsername(username);
    }
}
