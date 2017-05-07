package ru.stqa.pft.mantis.model;

/**
 * Created by Denis on 07.05.2017.
 */
public class Issue {
   private int id;
   private String summamry;
 private String description;
 private Project project;

    public int getId() {
        return id;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public String getSummamry() {
        return summamry;
    }

    public Issue withSummamry(String summamry) {
        this.summamry = summamry;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public Issue withProject(Project project) {
        this.project = project;
        return this;
    }
}
