package com.example.demo2.mapper;

import com.example.demo2.model.Song;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface NewTrackOnShelfMapper {

    @Select("select * from song order by songId desc limit 50")
    List<Song> selecNewSong();
}
