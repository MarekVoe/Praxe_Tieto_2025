package dev.marekvoe.pizzatieto.models;

public class Pizza {

    private int id;
    private String name;
    private String description;
    private int upvotes;

    public Pizza() {}

    public Pizza(int id, String name, String description, int upvotes) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.upvotes = upvotes;
    }

    public String getDescription() {
        return this.description;
    }

    public int getUpvotes() {
        return this.upvotes;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
