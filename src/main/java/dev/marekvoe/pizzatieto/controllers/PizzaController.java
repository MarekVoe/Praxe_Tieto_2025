package dev.marekvoe.pizzatieto.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PizzaController {

    @RequestMapping("/hello")
    public String sendHello() {
        return "Hello, World !";
    }
}
