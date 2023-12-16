package com.example.simplewebapplication;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Arrays;
import java.util.List;

/**
 * SimpleController
 *
 * @Author Tretyakov Alexandr
 */

@Controller
public class SimpleController {

    User user = new User("Ivan", "ivan@somemail.ru");

    @GetMapping("/example")
    public String index(Model model) {
        model.addAttribute("name", "Ivan Ivanov");
        List<String> transports = Arrays.asList("Bike", "Auto", "Truck");
        model.addAttribute("transports", transports);
        //User user = new User("Ivan", "ivan@somemail.ru");
        model.addAttribute("user", user);
        return "example/index";
    }

    @PostMapping("/example/save")
    public String save(@ModelAttribute("user") User user) {
        System.out.println("Saving User " + user);
        this.user = user;
        return "redirect:/example";
    }

    @GetMapping("example/footer")
    public String footer() {
        return "example/fragments/footer :: footer";
    }

    @GetMapping("example/header")
    public String header() {
        return "example/fragments/header :: header";
    }






    @Data
    @AllArgsConstructor
    public class User {
        private String name;
        private String email;
    }
}
