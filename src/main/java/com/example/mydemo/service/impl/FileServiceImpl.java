package com.example.mydemo.service.impl;

import com.example.mydemo.mapper.FileMapper;
import com.example.mydemo.mapper.UserMapper;

import com.example.mydemo.pojo.BasicUser;
import com.example.mydemo.pojo.User;
import com.example.mydemo.service.FileService;
import com.example.mydemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class FileServiceImpl implements FileService {

    @Autowired
    private FileMapper fileMapper;

    @Override
    public boolean pushMyFile(String userID,String courseID,String experimentID,String fileName,String fileURL){
        return fileMapper.pushFile(userID,courseID,experimentID,fileName,fileURL);
    }

    @Override
    public String getFile(String courseID,String experimentID){
        return fileMapper.downloadFile(courseID,experimentID);
    }
}
