package com.example.Smart_Canteen_Ordering_and_Billing_System.controller;

import com.example.Smart_Canteen_Ordering_and_Billing_System.entity.User;
import com.example.Smart_Canteen_Ordering_and_Billing_System.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String email, @RequestParam String password){
        try {
            User user = new User();
            user.setUsername(username);
            user.setEmail(email);
            user.setPassword(password);
            user.setRole("CUSTOMER");
            userService.saveUser(user);
            return "redirect:/home";
        } catch (Exception e) {
            return "redirect:/?error=registration";
        }
    }

    @PostMapping("/login")
    public String loginUser(@RequestParam String username, @RequestParam String password){
        try {
            User user = userService.findByUsername(username);

            if(user == null){
                return "redirect:/?error=usernotfound";
            }

            if(user.getPassword().equals(password)){
                return "redirect:/home";
            } else {
                return "redirect:/?error=invalidpassword";
            }
        } catch (Exception e) {
            return "redirect:/?error=login";
        }
    }
}
