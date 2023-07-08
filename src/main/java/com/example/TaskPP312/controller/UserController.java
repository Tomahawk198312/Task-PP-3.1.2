package com.example.TaskPP312.controller;

import com.example.TaskPP312.model.User;
import com.example.TaskPP312.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/people")
    public String AllUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "user";
    }

    @RequestMapping("/add")
    public String add(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit")
    public String createOrUpdateUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/people";
    }

    @RequestMapping("/edit/{id}")
    public String editUser(@PathVariable(value = "id") Integer id, Model model) {
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "edit";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.removeUserById(id);
        return "redirect:/people";
    }
}