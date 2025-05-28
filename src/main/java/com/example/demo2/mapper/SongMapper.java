package com.example.demo2.mapper;

import com.example.demo2.model.Song;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SongMapper {

    @Insert("insert into song(songName,songAddress,songType,songartist,uptime) values( #{song.songName},#{song.songAddress},#{song.songType},#{song.songartist},#{song.upTime} )")
    Integer insertOnlySong(@Param("song")Song song);

    @Insert("insert into song(songName,songAddress,songCoverAddress,songType,songartist,uptime) values( #{song.songName},#{song.songAddress},#{song.songCoverAddress},#{song.songType},#{song.songartist},#{song.upTime} )")
    Integer insertSongWithCover(@Param("song")Song song);

    @Select("select count(1) from song")
    Integer selectCount();

    @Select("select count(1) from song where songName = #{search}")
    Integer selectCountByName(String search);

    @Select("select * from song limit #{offset},#{size}")
    List<Song> listByPage(int offset, Integer size);

    @Select("select * from song where songName like CONCAT('%',#{search},'%') limit #{offset},#{size}")
    List<Song> SearchByPage(int offset, Integer size, String search);

    @Delete("delete from song where songId = #{songid}")
    Integer deleteUserByName(String songid);

    @Select("select count(1) from song where songType like CONCAT('%',#{type},'%')")
    Integer selectCountByType(String type);

    @Select("select count(1) from song where  songName = #{search} and songType like CONCAT('%',#{type},'%')")
    Integer selectCountByTypeAndName(String search, String type);

    @Select("select * from song where songType like CONCAT('%',#{songType},'%') limit #{offset},#{size}")
    List<Song> listByTypeAndPage(int offset, Integer size, String songType);

    @Select("select songId from song where songName = #{title}")
    int selectIdByName(String title);

    @Select("select * from song where songId = #{id}")
    Song selectSongById(Integer id);

    @Select("select songId from song")
    List<Integer> selectAllSongId();

    @Select("select * from song ORDER BY upTime desc limit 0,8 ")
    List<Song> getNewSong();

    @Select("select * from song ORDER BY upTime desc")
    List<Song> getManyNewSong();
}
