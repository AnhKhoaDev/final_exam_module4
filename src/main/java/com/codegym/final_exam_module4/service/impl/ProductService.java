package com.codegym.final_exam_module4.service.impl;

import com.codegym.final_exam_module4.model.Product;
import com.codegym.final_exam_module4.repository.IProductRepository;
import com.codegym.final_exam_module4.service.IProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final IProductRepository productRepository;


    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
