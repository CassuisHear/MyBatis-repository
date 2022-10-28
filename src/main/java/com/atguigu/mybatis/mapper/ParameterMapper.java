package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ParameterMapper {

    /**
     * 查询所有员工信息
     */
    List<User> getAllUsers();

    /**
     * 根据员工名获取员工信息
     */
    User getUserByUsername(String username);

    /**
     * 根据员工名和员工的密码来获取员工信息
     */
    User checkLogin(String username, String password);

    /**
     * 根据员工名和员工的密码来获取员工信息（以Map的形式传参）
     */
    User checkLoginByMap(Map<String, Object> map);

    /**
     * 添加一个员工的信息
     */
    int insertUser(User user);

    /**
     * 根据员工名和员工的密码来获取员工信息（使用注解的方式设定键）
     */
    User checkLoginByParam(@Param("username") String username, @Param("password") String password);
}
