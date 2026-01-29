package com.example.blogmanagement.repository;

import com.example.blogmanagement.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {

}
