package dev.marekvoe.pizzatieto.controllers;

import dev.marekvoe.pizzatieto.PizzaService;
import dev.marekvoe.pizzatieto.models.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaController {

    @Autowired
    private PizzaService pizzaService;

    @GetMapping("/getAllPizzas")
    public List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @DeleteMapping("/deletePizza/{id}")
    public void deletePizza(@PathVariable int id) {
        pizzaService.deletePizza(id);
    }

    @PostMapping("/addPizza")
    public void addPizza(@RequestBody Pizza pizza) {
        pizzaService.addPizza(pizza);
    }
}
