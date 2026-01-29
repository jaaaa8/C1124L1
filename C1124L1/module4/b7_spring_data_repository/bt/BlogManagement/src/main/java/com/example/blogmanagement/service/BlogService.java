package com.example.blogmanagement.service;

import com.example.blogmanagement.entity.Blog;
import com.example.blogmanagement.entity.Category;
import com.example.blogmanagement.repository.IBlogRepository;
import com.example.blogmanagement.service.impl.IBlogService;
import com.example.blogmanagement.service.impl.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{

    @Autowired
    private final IBlogRepository iBlogRepository;

    @Autowired
    private ICategoryService categoryService;

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
    public boolean updateBlog(int id, String title, int categoryId,
                              String content, String author, String description) {

        Blog blog = iBlogRepository.findById(id).orElse(null);
        if (blog == null) {
            System.err.println("NOT FOUND BLOG ID: " + id);
            return false;
        }

        // phải làm thế này vì nếu lấy category từ client gửi lên thì nó không nằm trong data
        // => hibernate không cho phép => lỗi => mặc định id category là 0 => đổi thế nào cũng vẫn là id = 0
        Category managedCategory = categoryService.findCategoryById(categoryId);
        if (managedCategory == null) {
            System.err.println("NOT FOUND CATEGORY ID: " + categoryId);
            return false;
        }
        blog.setTitle(title);
        blog.setContent(content);
        blog.setAuthor(author);
        blog.setDescription(description);
        blog.setCategory(managedCategory);

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
