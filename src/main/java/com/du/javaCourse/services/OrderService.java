package com.du.javaCourse.services;

import com.du.javaCourse.entities.Order;
import com.du.javaCourse.repositories.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> orderOpt = orderRepository.findById(id);
        return orderOpt.get();
    }

}
