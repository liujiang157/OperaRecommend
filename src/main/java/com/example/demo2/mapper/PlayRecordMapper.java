package com.example.demo2.mapper;

import com.example.demo2.model.PlayRecord;
import com.example.demo2.model.Song;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface PlayRecordMapper {

    @Insert("insert into play (songId,userId,playTime) values (#{playRecord.songId},#{playRecord.userId},#{playRecord.playTime})")
    void insert(@Param("playRecord")PlayRecord playRecord);

    @Select(" select  songId from play where userId = #{userId} GROUP BY songId")
    List<Integer> selectRecordById(int userId);

    @Select(" select  * from play")
    List<PlayRecord> selectAll();

    @Select("select songId  AS count from play  group by songId order by  count(*) DESC LIMIT 5")
    List<Integer> selectTopSongs();
}