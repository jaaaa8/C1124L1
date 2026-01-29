package com.example.registerform.controller;

import com.example.registerform.entity.User;
import com.example.registerform.service.IUserService;
import com.example.registerform.service.UserService;
import com.example.registerform.util.UserValidation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserValidation userValidation;
    @Autowired
    private final IUserService userService;

    public UserController(UserValidation userValidation, UserService userService) {
        this.userValidation = userValidation;
        this.userService = userService;
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidation);
    }

    @GetMapping("")
    public String showListBlog(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute("userList", userList);
        return "/user/list";
    }

    @GetMapping("/add")
    public String showFormAdd(Model model){
        model.addAttribute("user", new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String save(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                       RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()) {
            return "user/add";
        }
        userService.addNewUser(user);
        redirectAttributes.addFlashAttribute("mess","add new success");
        return "redirect:/user";

    }
}
