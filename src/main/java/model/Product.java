package model;

import base.model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@ToString(callSuper = true)

public class Product extends BaseEntity<Integer> {

    String name;
    String description;
    String gender;
    String color;
    int siza;
    int price;
    int categoryId;

    public Product(int productId, String name, String description, String gender, String color, int size, int price, int categoryId) {
        super(productId);
        this.name = name;
        this.description = description;
        this.gender = gender;
        this.color = color;
        this.siza = size;
        this.price = price;
        this.categoryId = categoryId;
    }
}