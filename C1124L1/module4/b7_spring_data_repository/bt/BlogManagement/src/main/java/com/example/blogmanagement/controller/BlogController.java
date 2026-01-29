package com.example.blogmanagement.controller;



import com.example.blogmanagement.entity.Blog;
import com.example.blogmanagement.service.impl.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public String showListBlog(Model model) {
        List<Blog> blogList = blogService.findAll();
        model.addAttribute("blogList", blogList);
        return "/blog/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("blog", new Blog());
        return "blog/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute Blog blog,
                       RedirectAttributes redirectAttributes){
        blogService.addNewBlog(blog);
        redirectAttributes.addFlashAttribute("mess","add new success");
        return "redirect:/blogs";

    }

    @GetMapping("/{id}/detail")
    public ModelAndView detail(@PathVariable(name = "id") int detailId){
        ModelAndView modelAndView = new ModelAndView("blog/detail");
        Blog blog = blogService.findBlogById(detailId);
        modelAndView.addObject("blog",blog);
        return modelAndView;
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEdit(@PathVariable(name = "id") int editId) {
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        Blog blog = blogService.findBlogById(editId);
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String update(@ModelAttribute Blog newBlog,
                         RedirectAttributes redirectAttributes){
        blogService.updateBlog(Math.toIntExact(newBlog.getId()), newBlog.getTitle(), newBlog.getContent(), newBlog.getAuthor(), newBlog.getDescription());
        redirectAttributes.addFlashAttribute("mess","update success");
        return "redirect:/blogs";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable(name = "id") int deleteId,
                         RedirectAttributes redirectAttributes) {
        blogService.deleteBlog(deleteId);
        redirectAttributes.addFlashAttribute("mess", "delete success");
        return "redirect:/blogs";
    }
}
