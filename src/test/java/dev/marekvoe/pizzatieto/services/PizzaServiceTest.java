package dev.marekvoe.pizzatieto.services;

import dev.marekvoe.pizzatieto.models.Pizza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PizzaServiceTest {

    private PizzaService pizzaService;

    @BeforeEach
    void setUp() {
        pizzaService = new PizzaService();
    }

    @Test
    void testAddPizza() {
        Pizza pizza = new Pizza(1, "Margherita");
        pizzaService.addPizza(pizza);

        List<Pizza> pizzas = pizzaService.getAllPizzas();
        assertEquals(1, pizzas.size());
        assertEquals("Margherita", pizzas.get(0).getName());
    }

    @Test
    void testGetAllPizzas() {
        pizzaService.addPizza(new Pizza(1, "Margherita"));
        pizzaService.addPizza(new Pizza(2, "Pepperoni"));

        List<Pizza> pizzas = pizzaService.getAllPizzas();
        assertEquals(2, pizzas.size());
    }

    @Test
    void testDeletePizza() {
        Pizza pizza = new Pizza(1, "Margherita");
        pizzaService.addPizza(pizza);

        pizzaService.deletePizza("1");

        List<Pizza> pizzas = pizzaService.getAllPizzas();
        assertTrue(pizzas.isEmpty());
    }

    @Test
    void testDeletePizzaNotFound() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> pizzaService.deletePizza("99"));
        assertEquals("Pizza s ID 99 neexistuje.", exception.getMessage());
    }

    @Test
    void testPizzaExists() {
        pizzaService.addPizza(new Pizza(1, "Margherita"));

        assertTrue(pizzaService.pizzaExists(1));
        assertFalse(pizzaService.pizzaExists(2));
    }
}