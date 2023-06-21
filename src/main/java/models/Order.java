package models;



import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

//@Builder
@NoArgsConstructor
@Getter
@Setter
public class Order {
   // @JsonProperty("field_name")
    private int id;
   // @JsonProperty("field_name")
   //@JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;
   // @JsonProperty("field_name")
    private double cost;
     static ArrayList<Product> products=new ArrayList<>();


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
