package com.example.demo2.mapper;

import com.example.demo2.model.Video;
import org.apache.ibatis.annotations.*;

import java.util.Date;
import java.util.List;

@Mapper
public interface VideoMapper {
    @Insert("insert into video(videoname,songAddress,description,date) values( #{video.videoname},#{video.songAddress},#{video.description},#{video.date} )")
    int insertVideo(@Param("video")Video video);

    @Select("select count(1) from video")
    int selectCount();

    @Select("select count(1) from video where videoname = #{search}")
    int selectCountByName(String search);

    @Select("select * from video limit #{offset},#{size}")
    List<Video> listByPage(int offset, Integer size);

    @Select("select * from video where videoname like CONCAT('%',#{search},'%') limit #{offset},#{size}")
    List<Video> SearchByPage(int offset, Integer size, String search);

    @Delete("delete from video where id = #{songid}")
    int deleteVideoByName(String songid);

    @Update("update video set isrec = 1,date = #{date}  where id = #{songid}")
    int addrecVideo(String songid, Date date);

    @Update("update video set isrec = 0,date = #{date} where id = #{songid}")
    int deleterecVideo(String songid, Date date);

    @Select("select * from video where isrec = 1 ORDER BY date desc limit 0,3 ")
    List<Video> listRec();

    @Select("select * from video where id = #{videoid}")
    Video slectVideoById(String videoid);
}
