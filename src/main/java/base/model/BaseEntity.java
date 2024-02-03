package base.model;

import lombok.*;

import java.io.Serializable;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter


public class BaseEntity<ID extends Serializable> {

    private ID id;

}
