package com.example.demo2.mapper;


import com.example.demo2.model.Like;
import com.example.demo2.model.Song;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface LikeMapper {

    @Insert("insert into collect (userId,songId) values (#{like.userId},#{like.songId})")
    void insert(@Param("like") Like like);

    @Select("select * from collect where userId = #{like.userId} and songId = #{like.songId}")
    Like selectrepeat(@Param("like") Like like);

    @Delete("delete from collect where userId = #{like.userId} and songId = #{like.songId}")
    void delete(@Param("like") Like like);

    @Select("select songId from collect where userId = #{userId}")
    List<Integer> selectAllByUserId(int uerId);

    @Select("select * from collect")
    List<Like> selectAll();
}
