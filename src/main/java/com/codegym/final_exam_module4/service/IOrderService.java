package com.codegym.final_exam_module4.service;

import com.codegym.final_exam_module4.dto.OrderDTO;

import java.util.List;

public interface IOrderService{
    List<OrderDTO> findAll();

    OrderDTO findById(Long id);

    void update(OrderDTO orderDTO, Long id);
}
