package com.sda.biuropodrozyjava.domain.order;

import com.sda.biuropodrozyjava.domain.travel.Travel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findByUser(Long id) {
        return orderRepository.findByUserId(id);
    }

    public void save(Order order) {
        orderRepository.save(order);
    }

    public Double calculateTotalPrice(Order order, Travel travel) {
        return order.getNumberOfAdults() * travel.getPriceAdult() + order.getNumberOfChildren() * travel.getPriceChild();
    }

}
