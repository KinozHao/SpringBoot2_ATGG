package com.boot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author kinoz
 * @Date 2023/2/25 11:41
 * @apiNote
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {
    public String username;
    public String password;
}
