package ro.fasttrackit.curs1.ex2;

import java.util.Objects;

import static java.util.Objects.*;

public final class Product {
    private final int id;
    private final String name;
    private final int price;
    private int count;

    public Product(int id, String name, int price, int count) {
        this.id = id;
        this.name = validName(name);
        this.price = Math.max(price, 0);
        this.count = count;
    }

    private String validName(String name) {
        if (isNull(name) || name.isBlank()) {
            throw new IllegalArgumentException("Product name cannot be null or empty!");
        } else {
            return name;
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getCount() {
        return count;
    }

    public void increaseCount(int inventoryCount) {
        this.count += inventoryCount;
    }

    public void decreaseCount(int amount) {
        this.count -= amount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return id == product.id && price == product.price && count == product.count && Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return hash(id, name, price, count);
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

}
