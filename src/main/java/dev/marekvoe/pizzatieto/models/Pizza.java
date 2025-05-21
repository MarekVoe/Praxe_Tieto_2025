package dev.marekvoe.pizzatieto.models;

import jakarta.persistence.Entity;

@Entity
public class Pizza {

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
}
