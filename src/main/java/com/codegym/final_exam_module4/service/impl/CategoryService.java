package com.codegym.final_exam_module4.service.impl;

import com.codegym.final_exam_module4.model.Category;
import com.codegym.final_exam_module4.repository.ICategoryRepository;
import com.codegym.final_exam_module4.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService implements ICategoryService {
    private final ICategoryRepository categoryRepository;
    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }
}
