package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Car {
    private  String CarName;
    private  String CarCard;
    private  String IsEdit;
    private  String OwnerId;

}
