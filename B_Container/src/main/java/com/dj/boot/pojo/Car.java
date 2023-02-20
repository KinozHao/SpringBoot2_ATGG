package com.dj.boot.pojo;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author kinoz
 * @Date 2023/2/20 10:48
 * @apiNote 此实体类用于测试@ConfigurationProperties注解配置绑定
 */
//不写Component注解时候,需要在配置类中使用@EnableConfigurationProperties(Car.class)
//@Component
@ConfigurationProperties(prefix = "mycar")
public class Car {

    private String brand;
    private Integer price;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Car() {
    }

    public Car(String brand, Integer price) {
        this.brand = brand;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                '}';
    }
}
