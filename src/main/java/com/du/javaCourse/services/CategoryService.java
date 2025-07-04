package com.du.javaCourse.services;

import com.du.javaCourse.entities.Category;
import com.du.javaCourse.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> categoryOpt = categoryRepository.findById(id);
        return categoryOpt.get();
    }

}
