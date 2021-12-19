package com.example.mydemo.service;
import com.example.mydemo.pojo.BasicUser;
import com.example.mydemo.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
//也是没有写对应的注解的，到时候可以改一下
@Service
public interface UserService {
    //和mapper相呼应，有一个对应的方法
    //List<User> getUserList();

    //MyUsers regist(MyUsers myusers);
    User test(String account);
    boolean login(String account,String password);
    boolean pushUserComment(String userEmail,String experimentID,String content);
    void excelExport(HttpServletResponse response) throws IOException;

    void excelImport(MultipartFile file) throws IOException;

}


