package com.example.mydemo.mapper;

import com.example.mydemo.pojo.MyUsers;
import com.example.mydemo.pojo.User;
import com.example.mydemo.pojo.Users;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@Mapper
public interface UserMapper {
    //然后做一些数据库的对应操作，这次是查询操作
    @Select("select * from usertable where userEmail=#{userEmail}")
    User gettest(@Param("userEmail")String account);

    //List<MyUsers> findUByUsernameAndPassword(String username,String password);

    @Select("select userEmail=#{userEmail} from usertable where password=#{password}")
    boolean getExists(@Param("userEmail")String account,@Param("password")String password);

    @Insert("insert into comment(userEmail,experimentID,content) values (#{userEmail},#{experimentID},#{content})")
    boolean pushComment(@Param("userEmail")String userEmail,@Param("experimentID")String experimentID,@Param("content")String content);

    //查询所有的用户信息
    @Select("select * from t_user")
    List<Users> selUserMapper();

    @Insert("insert into t_user (uid ,uname,pwd) values (#{uid},#{uname},#{pwd}) ")
    int addUser(Users user);

}


