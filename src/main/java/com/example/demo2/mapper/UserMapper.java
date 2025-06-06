package com.example.demo2.mapper;


import com.example.demo2.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Insert("insert into user (username,password,email) values (#{username},#{password},#{email})")
    Integer insert(User user);

    @Select("select * from user where email=#{user.email} and password=#{user.password}")
    User selectByUser(@Param("user") User user);

    @Select("select * from user where email=#{email}")
    User selectByEmail(@Param("email") String email);

    @Select("select * from user where username = #{username}")
    User selectByName(@Param("username") String username);

    @Select("select * from user")
    List<User> selectAll();

    @Select("select id from user")
    List<Integer> selectAllUserId();

    @Select("select * from user limit #{offset},#{size}")
    List<User> listByPage(Integer offset, Integer size);

    @Select("select count(1) from user")
    Integer selectCount();

    @Delete("delete from user where username = #{username}")
    Integer deleteUserByName(String username);

    @Select("select count(1) from user where username = #{username}")
    int selectCountByName(String username);

    @Select("select * from user where username  CONCAT('%',#{search},'%') limit #{offset},#{size}")
    List<User> SearchByPage(int offset, Integer size, String search);

    @Select("select * from user where id=#{id}")
    User selecUsertById(Integer id);

    @Update("update user set username = #{user.username},email = #{user.email},password = #{user.password} where id =#{user.id}")
    Integer update(@Param("user")User user);
}
