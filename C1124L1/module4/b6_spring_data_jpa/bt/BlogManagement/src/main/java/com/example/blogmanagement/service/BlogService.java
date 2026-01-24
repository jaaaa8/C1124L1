package com.example.blogmanagement.service;

import com.example.blogmanagement.entity.Blog;
import com.example.blogmanagement.repository.IBlogRepository;
import com.example.blogmanagement.service.impl.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    private final IBlogRepository iBlogRepository;

    public BlogService(IBlogRepository iBlogRepository) {
        this.iBlogRepository = iBlogRepository;
    }

    @Override
    public boolean addNewBlog(Blog blog) {
        if(blog == null){
            return false;
        }
        iBlogRepository.save(blog);
        return true;
    }

    @Override
    public boolean updateBlog(int id, String title, String content, String author, String description) {
        Blog blog = iBlogRepository.findById(id).orElse(null);
        if(blog == null){
            System.err.println("NOT FOUND BLOG ID: " + id);
            return false;
        }
        blog.setTitle(title);
        blog.setContent(content);
        blog.setAuthor(author);
        blog.setDescription(description);
        iBlogRepository.save(blog);
        return true;
    }

    @Override
    public boolean deleteBlog(int id) {
        Blog blog = iBlogRepository.findById(id).orElse(null);
        if(blog != null){
            iBlogRepository.deleteById(id);
            return true;
        }
        System.err.println("NOT FOUND BLOG ID: " + id);
        return false;
    }

    @Override
    public Blog findBlogById(int id) {
        return iBlogRepository.findById(id).orElse(null);
    }

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }
}
