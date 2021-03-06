package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = "/test")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello from Kensyn!");
        messages.add("It's just Test Connection");
        model.addAttribute("messages", messages);
        return "test";
    }

    @GetMapping(value = "/allUsers")
    public String userList(Model model) {
        List<User> userList = userService.listUsers();
        model.addAttribute("userList", userList);
//        model.addAttribute("user", new User());
//        model.addAttribute("listUsers", this.userService.listUsers());
        return "users";
    }

    @PostMapping(value = "/save")
    public String saveUser(@ModelAttribute("user") User user) {

        userService.saveUser(user);
        return "redirect:/allUsers";
    }

    @GetMapping(value = "addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userinfo";
    }

    @GetMapping(value = "update/{id}")
    public String updateUser(@PathVariable("id") int id, Model model) {
        User user = userService.getUserByID(id);
        model.addAttribute("user", user);
        return "userinfo";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/allUsers";
    }

//    @RequestMapping("edit/{id}")
//    public String editUser(@PathVariable("id") int id, Model model) {
//        model.addAttribute("user", this.userService.getUserByID(id));
//        model.addAttribute("listUsers", this.userService.listUsers());
//        return "users";
//    }

    @RequestMapping("userinfo/{id}")
    public String userInfo(@PathVariable("id") int id, Model model) {
        model.addAttribute("user", this.userService.getUserByID(id));
        return "userinfo";
    }
}