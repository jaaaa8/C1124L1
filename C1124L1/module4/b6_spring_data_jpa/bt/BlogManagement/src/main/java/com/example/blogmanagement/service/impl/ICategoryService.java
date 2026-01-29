package com.example.blogmanagement.service.impl;

import com.example.blogmanagement.entity.Category;

import java.util.List;

public interface ICategoryService {
    boolean addNewCategory(Category category);
    List<Category> findAll();
    boolean deleteCategory(int id);
    boolean updateCategory(int id, String name);
    Category findCategoryById(int id);
}
