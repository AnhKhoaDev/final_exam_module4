package com.codegym.final_exam_module4.service.impl;

import com.codegym.final_exam_module4.dto.OrderDTO;
import com.codegym.final_exam_module4.model.Order;
import com.codegym.final_exam_module4.repository.IOrderRepository;
import com.codegym.final_exam_module4.service.IOrderService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService {
    private final IOrderRepository orderRepository;

    @Override
    public List<OrderDTO> findAll() {
        List<Order> orders = orderRepository.findAll();

        return orders.stream().map(order ->
                OrderDTO.builder()
                        .id(order.getId())
                        .nameProduct(order.getProduct().getName())
                        .price(order.getProduct().getPrice())
                        .nameCategory(order.getProduct().getCategory().getName())
                        .orderDate(order.getOrderDate())
                        .quantity(order.getQuantity())
                        .build()).toList();
    }

    @Override
    public OrderDTO findById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);

        return orderOptional.map(order ->
                        OrderDTO.builder()
                                .id(order.getId())
                                .nameProduct(order.getProduct().getName())
                                .price(order.getProduct().getPrice())
                                .nameCategory(order.getProduct().getCategory().getName())
                                .orderDate(order.getOrderDate())
                                .quantity(order.getQuantity())
                                .build())
                .orElse(null);
    }

    @Override
    public void update(OrderDTO orderDTO, Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        if (orderOptional.isPresent()) {
            Order order = orderOptional.get();
            BeanUtils.copyProperties(orderDTO, order);
            orderRepository.save(order);
        }
    }

}
