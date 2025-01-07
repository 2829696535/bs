package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Order {
    private String uuid;
    private String orderName;
    private String customerName;
    private String orderPrice;
    private String workerName;
    private String orderDate;
    private  String dealDate;
    private String orderState;
}
