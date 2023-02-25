package com.boot.mapper;

import com.boot.entity.Car;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;

/**
 * @author kinoz
 * @Date 2023/2/25 17:17
 * @apiNote
 */
public interface CarMapper {

    Car CarInfoById(@Param("id") Integer id);

    //todo 插入数据存在中文乱码....
    @Insert("insert into springboot.car values (#{id},#{brand},#{country})")
    //使用自动id
    //@Options(useGeneratedKeys = true,keyProperty = "id")
    int insertCarInfo(Integer id, @Param("brand")String brand, @Param("country")String country);
}
