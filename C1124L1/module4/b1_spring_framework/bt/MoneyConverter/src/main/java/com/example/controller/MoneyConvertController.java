package com.example.controller;

import com.example.entity.Money;
import com.example.service.impl.IConvertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/convert")
public class MoneyConvertController {
    @Autowired
    private IConvertService convertService;

    @PostMapping
    public String convertMoney(@ModelAttribute Money money, Model model) {
        double result;
        if ("VND".equals(money.getType())) {
            result = money.getAmount() / money.getRate();
        } else {
            result = money.getAmount() * money.getRate();
        }
        model.addAttribute("result", result);
        model.addAttribute("money", money);
        return "convert";
    }


    @GetMapping
    public String showConvertForm() {
        return "convert";
    }
}
