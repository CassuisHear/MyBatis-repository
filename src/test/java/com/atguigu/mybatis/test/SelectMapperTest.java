package com.atguigu.mybatis.test;

import com.atguigu.mybatis.mapper.SelectMapper;
import com.atguigu.mybatis.pojo.User;
import com.atguigu.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class SelectMapperTest {

    /**
     * MyBatis的各种查询功能:
     * 1.若查询出的数据只有一条，
     * a>可以通过实体类对象接收;
     * b>可以通过List集合来接收
     * c>可以使用Map集合来接收，其中以字段为key，以字段值为value
     * <p>
     * 2.若查询出的数据有多条，
     * a>可以通过实体类型的List来接收;
     * b>可以通过Map类型的List来接收;
     * c>可以在mapper接口的方法上添加@MapKey注解的方式来设置map集合的键，
     * 键为某个字段值，值是每条数据所对应的map集合
     * 注意：一定不能通过实体类对象接收，此时会抛异常TooManyResultsException
     * <p>
     * MyBatis中设置了默认的类型别名
     * java.Lang.Integer-->int,integer
     * int-->_int,_integer
     * Map-->map
     * String-->string
     */

    @Test
    public void testGetUserById() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        User user = selectMapper.getUserById(4);
        System.out.println("user = " + user);
    }

    @Test
    public void testGetAllUsers() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        List<User> allUsers = selectMapper.getAllUsers();
        System.out.println("allUsers = " + allUsers);
    }

    @Test
    public void testGetCount() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Integer count = selectMapper.getCount();
        System.out.println("count = " + count);
    }

    @Test
    public void testGetUserByIdToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        Map<String, Object> userByIdToMap = selectMapper.getUserByIdToMap(4);
        System.out.println("userByIdToMap = " + userByIdToMap);
    }

    @Test
    public void testGetAllUsersToMap() {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        SelectMapper selectMapper = sqlSession.getMapper(SelectMapper.class);
        //List<Map<String, Object>> allUsersToMap = selectMapper.getAllUsersToMap();
        Map<String, Object> allUsersToMap = selectMapper.getAllUsersToMap();
        System.out.println("allUsersToMap = " + allUsersToMap);
    }
}
