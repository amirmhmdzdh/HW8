package model;

import base.model.BaseEntity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Customer extends BaseEntity<Integer> {

  String name;
  String lastName;
  String username;
  String email;
  String password;
  String nationalCode;




}
