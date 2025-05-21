package dev.marekvoe.pizzatieto.services;

import dev.marekvoe.pizzatieto.repositories.PizzaRepository;
import org.springframework.stereotype.Service;
import dev.marekvoe.pizzatieto.models.Pizza;

import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public Pizza addPizza(Pizza pizza) {
        return pizzaRepository.save(pizza);
    }
}
