package com.sda.biuropodrozyjava.web.controllers;

import com.sda.biuropodrozyjava.domain.order.OrderService;
import com.sda.biuropodrozyjava.domain.travel.TravelService;
import com.sda.biuropodrozyjava.domain.user.User;
import com.sda.biuropodrozyjava.domain.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/myorders")
public class MyOrdersController {
    private final OrderService orderService;
    private final UserService userService;
    private final TravelService travelService;

    public MyOrdersController(OrderService orderService, UserService userService, TravelService travelService) {
        this.orderService = orderService;
        this.userService = userService;
        this.travelService = travelService;
    }

    @GetMapping
    public String findOrdersByUser(Model model) {
        User user = userService.getLoggedUser();
        model.addAttribute("orders", orderService.findByUser(user.getId()));
        return "myorders";
    }

}
