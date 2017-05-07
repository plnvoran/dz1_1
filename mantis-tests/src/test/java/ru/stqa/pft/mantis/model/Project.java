package ru.stqa.pft.mantis.model;

/**
 * Created by Denis on 06.05.2017.
 */
public class Project {
   public int id;
   public String name;

    public int getId() {
        return id;
    }

    public Project withId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Project withName(String name) {
        this.name = name;
        return this;
    }
}
