package dev.marekvoe.pizzatieto.controllers;

import dev.marekvoe.pizzatieto.models.Pizza;
import dev.marekvoe.pizzatieto.services.PizzaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @GetMapping("/getAllPizzas")
    public List<Pizza> getAllPizzas() {
        return pizzaService.getAllPizzas();
    }

    @PostMapping("/addPizza")
    public Pizza addPizza(@RequestBody Pizza pizza) {
        return pizzaService.addPizza(pizza);
    }

    @DeleteMapping("/deletePizza/{id}")
    public void deletePizza(@PathVariable String id) {
        pizzaService.deletePizza(id);
    }
}
