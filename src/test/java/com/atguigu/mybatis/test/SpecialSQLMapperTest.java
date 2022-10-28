package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SpecialSQLMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class SpecialSQLMapperTest {

    @Test
    public void testGetUserByLike() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper specialSQLMapper = sqlSession.getMapper(SpecialSQLMapper.class);
        List<User> userList = specialSQLMapper.getUserByLike("李");
        System.out.println("userList = " + userList);
    }

    @Test
    public void testDeleteMore() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper specialSQLMapper = sqlSession.getMapper(SpecialSQLMapper.class);
        int result = specialSQLMapper.deleteMore("1,5,6");
        System.out.println("result = " + result);
    }

    @Test
    public void testGetUsersByTableName() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper specialSQLMapper = sqlSession.getMapper(SpecialSQLMapper.class);
        //传入表名为 t_user
        List<User> users = specialSQLMapper.getUsersByTableName("t_user");
        System.out.println("users = " + users);
    }

    @Test
    public void testInsertUser() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SpecialSQLMapper specialSQLMapper = sqlSession.getMapper(SpecialSQLMapper.class);
        //此时 user 中的 id 属性为空
        User user = new User(null, "王五", "654321", 26, "男", "wangwu@163.com");
        specialSQLMapper.insertUser(user);
        //执行 sql 语句后 id 属性被表中自增的主键赋值了
        System.out.println("user = " + user);
    }
}
