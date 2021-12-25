package web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.model.User;
import web.service.UserService;

import java.util.List;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private UserDao userDao;

    private UserService userService;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @GetMapping(value = "/allusers")
    public String userList(Model model) {
        List<User> userList = userService.listUsers();
        model.addAttribute("userList", userList);
        return "users";
    }

    @PostMapping(value = "/save")
    public String saveOrUpdateUser(@ModelAttribute("user") User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        userService.saveUser(user);
        return "redirect:/admin/allusers";
    }

    @GetMapping(value = "addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "userinfo";
    }

    @GetMapping("userinfo/{id}")
    public String userInfo(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", this.userService.getUserByID(id));
        return "userinfo";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUser(id);
        return "redirect:/admin/allusers";
    }
}
