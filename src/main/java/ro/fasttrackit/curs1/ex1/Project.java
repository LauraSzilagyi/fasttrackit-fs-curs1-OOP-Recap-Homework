package ro.fasttrackit.curs1.ex1;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Project {
    private final String name;
    private final int price;
    private final List<Category> categories;
    private final String description;

    public Project(String name, int price, List<Category> categories, String description) {
        this.name = validName(name);
        this.price = Math.max(price, 0);
        this.categories = new ArrayList<>(categories);
        this.description = description;
    }

    private String validName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Project name cannot be null or empty!");
        } else {
            return name;
        }
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public List<Category> getCategories() {
        return new ArrayList<>(categories);
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return price == project.price && Objects.equals(name, project.name) && Objects.equals(categories, project.categories) && Objects.equals(description, project.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price, categories, description);
    }

    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", categories=" + categories +
                ", description='" + description + '\'' +
                '}';
    }
}
