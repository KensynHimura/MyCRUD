package web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class GuestControllers {

    @GetMapping(value = "/test")
    public String printWelcome(ModelMap model) {
        List<String> messages = new ArrayList<>();
        messages.add("Hello from Kensyn!");
        messages.add("It's just Test Connection");
        model.addAttribute("messages", messages);
        return "test";
    }

    @GetMapping("/")
    public String greetings(ModelMap model) {
        model.addAttribute("greeting", ", glad to see you!");
        return "greeting";
    }

}
