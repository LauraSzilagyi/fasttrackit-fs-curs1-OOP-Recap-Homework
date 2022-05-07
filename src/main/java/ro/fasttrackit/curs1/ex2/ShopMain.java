package ro.fasttrackit.curs1.ex2;


import java.util.ArrayList;
import java.util.List;

public class ShopMain {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1, "product1", 200, 3));
        products.add(new Product(2, "product2", 150, 5));
        products.add(new Product(3, "product3", 400, 1));
        products.add(new Product(4, "product4", 1200, 1));
        products.add(new Product(5, "product5", 50, 7));

        System.out.println(products);
        Shop shop = new Shop(products);
        System.out.println(shop);

        shop.addProduct(new Product(6, "product6", 200, 3));
        System.out.println(shop);

        shop.addProductToInventory("produCt6", 20);
        System.out.println(shop);

        shop.buyProduct("Product6", 10);
        System.out.println(shop);
    }
}
