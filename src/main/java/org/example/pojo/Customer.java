package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
    private String customerName;
    private String customerId;//身份证号
    private String gender;
    private String phoneNumber;

}
