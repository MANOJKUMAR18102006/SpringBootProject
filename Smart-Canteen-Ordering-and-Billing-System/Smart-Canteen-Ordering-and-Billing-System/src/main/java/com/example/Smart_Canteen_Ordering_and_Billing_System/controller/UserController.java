package com.example.Smart_Canteen_Ordering_and_Billing_System.controller;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.User;
import com.example.Smart_Canteen_Ordering_and_Billing_System.Dto.LoginDto;
import com.example.Smart_Canteen_Ordering_and_Billing_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user){
        userService.saveUser(user);
        return "User Registered Successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginDto loginDto){
        User user = userService.findByUsername(loginDto.getUsername());

        if(user == null){
            return "User Not Found!";
        }

        if(user.getPassword().equals(loginDto.getPassword())){
            return "Login Successful";
        } else {
            return "Invalid Password";
        }
    }
}
