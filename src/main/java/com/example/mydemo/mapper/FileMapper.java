package com.example.mydemo.mapper;

import com.example.mydemo.pojo.MyUsers;
import com.example.mydemo.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Mapper
public interface FileMapper {
    @Insert("insert into file(userID,courseID,experimentID,fileName,fileURL) values (#{userID},#{courseID},#{experimentID},#{fileName},#{fileURL})")
    boolean pushFile(@Param("userID")String userID,@Param("courseID")String courseID,@Param("experimentID")String experimentID,@Param("fileName")String fileName,@Param("fileURL")String fileURL);

    @Select("select fileURL from file where courseID=#{courseID} and experimentID=#{experimentID}")
    String downloadFile(@Param("courseID")String courseID,@Param("experimentID")String experimentID);

}
