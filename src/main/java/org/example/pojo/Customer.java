package org.example.pojo;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    private String customerName;
    private String customerId;//id
//    private String gender;
    private String phoneNumber;

}
