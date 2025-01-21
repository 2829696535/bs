package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
@Data

public class User {
    private String id;
    private String username;
    private String password;
    private String role;
    private String createTime;
}
