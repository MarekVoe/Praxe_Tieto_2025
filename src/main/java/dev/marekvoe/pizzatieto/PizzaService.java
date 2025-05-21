package dev.marekvoe.pizzatieto;

import dev.marekvoe.pizzatieto.repositories.PizzaRepository;
import dev.marekvoe.pizzatieto.models.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PizzaService {

    @Autowired
    private PizzaRepository pizzaRepository;

    public List<Pizza> getAllPizzas() {
        return pizzaRepository.findAll();
    }

    public void addPizza(Pizza pizza) {
        pizzaRepository.save(pizza);
    }

    public void deletePizza(int id) {
        pizzaRepository.deleteById(id);
    }

}
