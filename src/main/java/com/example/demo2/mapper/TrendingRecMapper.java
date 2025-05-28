package com.example.demo2.mapper;

import com.example.demo2.model.Like;
import com.example.demo2.model.Song;
import com.example.demo2.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TrendingRecMapper {

    @Select("select * from collect where userId=#{user.id}")
    List<Like> getCollection(@Param("user")User user);






}
