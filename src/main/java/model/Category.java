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
public class Category extends BaseEntity<Integer> {

    String name;
    String description;


    public Category(int categoryId, String categoryName, String description) {
        super(categoryId);
        this.name = categoryName;
        this.description = description;
    }
}



