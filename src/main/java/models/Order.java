package models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;

@NoArgsConstructor
@Getter
@Setter
public class Order {
    private int id;
    private LocalDate date;
    private double cost;
    static ArrayList<Product> products = new ArrayList<>();

    public Order(int id, LocalDate date, double cost) {
        this.id = id;
        this.date = date;
        this.cost = cost;
        products.add(new Product(1, "Coffee", 50));
        products.add(new Product(2, "Tea", 35));
        products.add(new Product(3, "Juice", 40));
        products.add(new Product(4, "Beer", 30));
        products.add(new Product(5, "Water", 15));
    }
}
