package com.sda.biuropodrozyjava.web.controllers;

import com.sda.biuropodrozyjava.domain.role.RoleService;
import com.sda.biuropodrozyjava.domain.user.User;
import com.sda.biuropodrozyjava.domain.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class UserController {
    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "newuser";
    }

    @PostMapping
    public String addUser(Model model, @ModelAttribute User user) {
        userService.saveUser(user);
        return "index";
    }

}
