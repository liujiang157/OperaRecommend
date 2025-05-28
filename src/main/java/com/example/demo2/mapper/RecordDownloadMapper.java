package com.example.demo2.mapper;

import com.example.demo2.model.DownloadRecord;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RecordDownloadMapper {


    @Select("select * from download")
    List<DownloadRecord> selectAll();

    @Insert("insert into download (userId,songId,downloadTime) values(#{downloadRecord.userId},#{downloadRecord.songId},#{downloadRecord.downloadTime})")
    void insert( @Param("downloadRecord")DownloadRecord downloadRecord);



}
