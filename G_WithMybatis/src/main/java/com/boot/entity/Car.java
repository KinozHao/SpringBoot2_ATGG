package com.boot.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

/**
* 
* @TableName car
*/
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
public class Car implements Serializable {

    /**
    * 
    */
    @NotNull(message="[]不能为空")
    private Integer id;
    /**
    * 
    */
    @Size(max= 30,message="编码长度不能超过30")
    @Length(max= 30,message="编码长度不能超过30")
    private String brand;
    /**
    * 
    */
    @Size(max= 30,message="编码长度不能超过30")
    @Length(max= 30,message="编码长度不能超过30")
    private String country;

}
