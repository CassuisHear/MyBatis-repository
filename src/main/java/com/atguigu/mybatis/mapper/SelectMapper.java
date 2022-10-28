package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface SelectMapper {

    /**
     * 根据id查询用户信息
     */
    User getUserById(@Param("id") Integer id);

    /**
     * 查询所有用户信息
     */
    List<User> getAllUsers();

    /**
     * 查询总的记录条数
     */
    Integer getCount();

    /**
     * 根据id查询用户信息（转化为一个Map）
     */
    Map<String, Object> getUserByIdToMap(@Param("id") Integer id);

    /**
     * 查询所有用户信息（转化为一个Map）
     */
    //List<Map<String,Object>> getAllUsersToMap();
    @MapKey("id")
    Map<String,Object> getAllUsersToMap();
}
