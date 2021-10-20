package com.sda.biuropodrozyjava.web.controllers;

import com.sda.biuropodrozyjava.domain.order.Order;
import com.sda.biuropodrozyjava.domain.order.OrderService;
import com.sda.biuropodrozyjava.domain.travel.Travel;
import com.sda.biuropodrozyjava.domain.travel.TravelService;
import com.sda.biuropodrozyjava.domain.user.User;
import com.sda.biuropodrozyjava.domain.user.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;
    private final TravelService travelService;
    private final UserService userService;

    public OrderController(OrderService orderService, TravelService travelService, UserService userService) {
        this.orderService = orderService;
        this.travelService = travelService;
        this.userService = userService;
    }

    @GetMapping
    public String create(Model model, @RequestParam Long travelId) {
        Travel travel = travelService.getById(travelId);
        Order order = new Order();
        order.setTravel(travel);

        model.addAttribute("travel", travel);
        model.addAttribute("order", order);

        return "order";
    }

    @PostMapping
    public String create(Model model, Order order) {
        Travel travel = travelService.getById(order.getTravel().getId());
        order.setTravel(travel);
        order.setUser(userService.getLoggedUser());
        order.setTotalPrice(orderService.calculateTotalPrice(order, travel));
        model.addAttribute("order", order);
        return "orderdetails";
    }

    @PostMapping("/summary")
    public String save(Model model, @ModelAttribute Order order) {
        orderService.save(order);
        return "summary";
    }

}
