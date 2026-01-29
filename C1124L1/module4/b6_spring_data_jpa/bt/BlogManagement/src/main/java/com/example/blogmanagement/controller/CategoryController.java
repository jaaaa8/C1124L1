package com.example.blogmanagement.controller;


import com.example.blogmanagement.entity.Category;
import com.example.blogmanagement.service.impl.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String showListCategories(Model model) {
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "/categories/list";
    }

    @GetMapping("/add")
    public String showFormAddCategory(Model model){
        List<Category> categoryList = categoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "categories/add";
    }

    @PostMapping("/add")
    public String saveNewCategory(@ModelAttribute Category category,
                                  RedirectAttributes redirectAttributes){
        categoryService.addNewCategory(category);
        redirectAttributes.addFlashAttribute("mess","add new success");
        return "redirect:/categories";

    }

    @GetMapping("/{id}/edit")
    public ModelAndView showFormEditCategory(@PathVariable(name = "id") int editId) {
        ModelAndView modelAndView = new ModelAndView("categories/edit");
        Category category = categoryService.findCategoryById(editId);
        modelAndView.addObject("category", category);
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateBlog(@ModelAttribute Category category,
                             RedirectAttributes redirectAttributes){
        categoryService.updateCategory(Math.toIntExact(category.getId()), category.getName());
        redirectAttributes.addFlashAttribute("mess","update success");
        return "redirect:/categories";
    }

    @GetMapping("/{id}/delete")
    public String deleteBlog(@PathVariable(name = "id") int deleteId,
                             RedirectAttributes redirectAttributes) {
        categoryService.deleteCategory(deleteId);
        redirectAttributes.addFlashAttribute("mess", "delete success");
        return "redirect:/categories";
    }
}
