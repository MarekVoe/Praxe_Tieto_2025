package dev.marekvoe.pizzatieto.models;

public class Pizza {

    private int id;
    private String name;

    public Pizza() {}

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
