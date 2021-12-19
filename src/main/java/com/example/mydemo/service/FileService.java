package com.example.mydemo.service;
import org.springframework.stereotype.Service;

@Service
public interface FileService {

    boolean pushMyFile(String userID,String courseID,String experimentID,String fileName,String fileURL);
    String getFile(String courseID,String experimentID);
}
