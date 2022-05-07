package ro.fasttrackit.curs1.ex2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static java.util.Objects.hash;
import static java.util.Objects.nonNull;

public final class Shop {

    private final List<Product> products = new ArrayList<>();
    private int totalInventory;

    public Shop(List<Product> products) {
        if (nonNull(products)) {
            addProducts(products);
        }
    }

    private void addProducts(List<Product> products) {
        for (Product product : products) {
            validateAndAddProduct(product);
        }
    }

    public void addProduct(Product product) {
        validateAndAddProduct(product);
    }

    private void validateAndAddProduct(Product product) {
        if (isProductNameAlreadyInShop(product)) {
            throw new IllegalArgumentException("The name " + product.getName() + " already exist!");
        } else {
            this.products.add(product);
            increaseTotalInventory(product.getCount());
        }
    }

    private boolean isProductNameAlreadyInShop(Product product) {
        for (Product shopProduct : this.products) {
            if (shopProduct.getName().equalsIgnoreCase(product.getName())) {
                return true;
            }
        }
        return false;
    }

    public void addProductToInventory(String productName, int inventoryCount) {
        Product product = findProductByName(productName);
        product.increaseCount(inventoryCount);
        increaseTotalInventory(inventoryCount);
    }

    private void increaseTotalInventory(int inventoryCount) {
        this.totalInventory += inventoryCount;
    }

    private Product findProductByName(String productName) {
        return this.products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(productName))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("The product doesn't exist with this name!"));
    }

    public void buyProduct(String productName, int amount) {
        validAmount(amount);
        Product product = findProductByName(productName);
        if (isEnoughStock(amount, product)) {
            product.decreaseCount(amount);
            decreaseTotalInventory(amount);
        } else {
            throw new IllegalArgumentException("Not enough stock!");
        }
    }

    private boolean isEnoughStock(int amount, Product product) {
        return product.getCount() >= amount;
    }

    private void validAmount(int amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount cannot be 0 or lower!");
        }
    }

    private void decreaseTotalInventory(int amount) {
        totalInventory -= amount;
    }

    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }

    public int getTotalInventory() {
        return totalInventory;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shop shop = (Shop) o;
        return totalInventory == shop.totalInventory && Objects.equals(products, shop.products);
    }

    @Override
    public int hashCode() {
        return hash(products, totalInventory);
    }

    @Override
    public String toString() {
        return "Shop{" +
                "products=" + products +
                ", totalInventory=" + totalInventory +
                '}';
    }
}
