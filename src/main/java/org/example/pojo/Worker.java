package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class Worker {
    private String workerName;
    private String workerId;
    private String isWorkking;
    private String phoneNumber;
}
