package com.example.blogmanagement.service.impl;

import com.example.blogmanagement.entity.Blog;

import java.util.List;

public interface IBlogService {
    boolean addNewBlog(Blog blog);
    boolean updateBlog(int id, String title, String content, String author, String description);
    boolean deleteBlog(int id);
    Blog findBlogById(int id);
    List<Blog> findAll();
}
