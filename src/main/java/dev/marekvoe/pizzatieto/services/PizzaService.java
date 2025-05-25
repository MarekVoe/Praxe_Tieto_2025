package dev.marekvoe.pizzatieto.services;

import dev.marekvoe.pizzatieto.models.Pizza;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PizzaService {

    private final List<Pizza> pizzas = new ArrayList<>();

    public List<Pizza> getAllPizzas() {
        return new ArrayList<>(pizzas);
    }

    public Pizza addPizza(Pizza pizza) {
        pizzas.add(pizza);
        return pizza;
    }

    public void deletePizza(String id) {
        Optional<Pizza> pizzaToDelete = pizzas.stream()
                .filter(pizza -> String.valueOf(pizza.getId()).equals(id))
                .findFirst();

        if (pizzaToDelete.isPresent()) {
            pizzas.remove(pizzaToDelete.get());
        } else {
            throw new IllegalArgumentException("Pizza s ID " + id + " neexistuje.");
        }
    }

    public boolean pizzaExists(int id) {
        return pizzas.stream().anyMatch(pizza -> pizza.getId() == id);
    }
}