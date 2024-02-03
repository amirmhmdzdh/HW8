package model;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)

public class Customer {

  String name;
  String lastName;
  String username;
  String email;
  String password;
  String nationalCode;




}
