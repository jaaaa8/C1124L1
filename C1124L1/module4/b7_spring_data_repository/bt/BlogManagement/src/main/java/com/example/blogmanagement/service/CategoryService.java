package com.example.blogmanagement.service;

import com.example.blogmanagement.entity.Category;
import com.example.blogmanagement.repository.ICategoryRepository;
import com.example.blogmanagement.service.impl.ICategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService implements ICategoryService {

    private final ICategoryRepository categoryRepository;

    public CategoryService(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }


    @Override
    public boolean addNewCategory(Category category) {
        if(category == null){
            return false;
        }
        categoryRepository.save(category);
        return true;
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public boolean deleteCategory(int id) {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category == null){
            System.err.println("NOT FOUND CATEGORY ID: " + id);
            return false;
        }
        categoryRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateCategory(int id, String name) {
        Category category = categoryRepository.findById(id).orElse(null);
        if(category != null){
            category.setName(name);
            categoryRepository.save(category);
            return true;
        }
        System.err.println("NOT FOUND CATEGORY ID: " + id);
        return false;
    }

    @Override
    public Category findCategoryById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }
}
