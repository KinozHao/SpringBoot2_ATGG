package com.boot.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author kinoz
 * @Date 2023/2/20 19:44
 * @apiNote
 */
@Component
@ConfigurationProperties("pet")
@Data
@ToString
public class Pet {
    private String name;
    private Double weight;
}