package dev.marekvoe.pizzatieto.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("pizzas")
public class Pizza {

    private int id;
    private String name;

    public Pizza() {
        // Empty constructor for proper deserialization
    }

    public Pizza(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
