package com.example.demo2.mapper;

import com.example.demo2.model.Song;
import com.example.demo2.model.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PersonalRecMapper {

    @Select("select * from reca,song where reca.userId=#{user.id} and reca.songId=song.songId")
    List<Song> selectPersonalRecFromA(@Param("user")User user);

    @Select("select * from recb,song where recb.userId=#{user.id} and recb.songId=song.songId")
    List<Song> selectPersonalRecFromB(@Param("user")User user);

    @Delete("delete from recb where userId=#{userId}")
    void deleteBByUserId(Integer userId);

    @Delete("delete from reca where userId=#{userId}")
    void deleteAByUserId(Integer userId);

    //批量插入
    @Insert({
            "<script>",
            "insert into reca(userId,songId) values ",
            "<foreach collection='initialRecListA' item='item' index='index' separator=','>",
            "(#{id}, #{item.songId})",
            "</foreach>",
            "</script>"
    })
    void insertListIntoRecA(List<Song> initialRecListA, Integer id);


    @Insert({
            "<script>",
            "insert into recb(userId,songId) values ",
            "<foreach collection='initialRecListB' item='item' index='index' separator=','>",
            "(#{id}, #{item.songId})",
            "</foreach>",
            "</script>"
    })
    void insertListIntoRecB(List<Song> initialRecListB, Integer id);


    @Insert({
            "<script>",
            "insert into recb(userId,songId) values ",
            "<foreach collection='recSongIds' item='songId' index='index' separator=','>",
            "(#{userId}, #{songId})",
            "</foreach>",
            "</script>"
    })
    void insertArrayIntoRecB(Integer[] recSongIds, Integer userId);

    @Insert({
            "<script>",
            "insert into reca(userId,songId) values ",
            "<foreach collection='recSongIds' item='songId' index='index' separator=','>",
            "(#{userId}, #{songId})",
            "</foreach>",
            "</script>"
    })
    void insertArrayIntoRecA(Integer[] recSongIds, Integer userId);
}
