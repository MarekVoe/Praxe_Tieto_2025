package dev.marekvoe.pizzatieto.models;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "pizzas")
public class Pizza {

    @Id
    private final int id;
    private String name;

    public Pizza(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getID() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Pizza: \n ID: " + this.id + "\n Name: " + this.name + "\n";
    }
}
