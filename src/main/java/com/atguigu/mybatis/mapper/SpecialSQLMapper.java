package com.atguigu.mybatis.mapper;

import com.atguigu.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SpecialSQLMapper {

    /**
     * 通过模糊查询获取用户信息
     */
    List<User> getUserByLike(@Param("username") String username);

    /**
     * 在一定范围内批量删除
     */
    int deleteMore(@Param("ids") String ids);

    /**
     * 根据表明获取用户信息
     */
    List<User> getUsersByTableName(@Param("tableName") String tableName);

    /**
     * 添加一条用户的信息
     */
    void insertUser(User user);
}
