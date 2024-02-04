package model;

import base.model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)


public class Admin extends BaseEntity<Integer> {

    int id;
    String userName;
    String password;

}
