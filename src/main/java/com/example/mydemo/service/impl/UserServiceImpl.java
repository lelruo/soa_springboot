package com.example.mydemo.service.impl;

import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.example.mydemo.controller.ExcelListener;
import com.example.mydemo.mapper.UserMapper;

import com.example.mydemo.pojo.BasicUser;
import com.example.mydemo.pojo.User;
import com.example.mydemo.pojo.Users;
import com.example.mydemo.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
//再网上看到 好像是 service和controller和compent 还有这个 都是没有本质区别的
@Repository
public class UserServiceImpl implements UserService {
    //这里就是需要把这个实现方法具体的写出来了,然后这里就需要加入注解了
    //这就是所谓的自动装配的功能吧
    @Autowired
    private UserMapper userMapper;
    /*@Override
    public List<User> getUserList() {
        //就是因为这些调用来调用去的，让我觉得很绕，我姑且认为是，需要提高系统的可调度性
        //所以要做各种分层的操作，减少耦合度，这里的话，相当于就是要用具体操作了，可是其实就是把mapper的方法调用一些
        try{
            List<User> users= userMapper.getUserList();
            return users;

        }catch (Exception e){
            //好像是 如果不throw的话，会报错。。。
            e.printStackTrace();
            throw e;
        }
    }*/

    //    @Override
//    public MyUsers regist(MyUsers myusers) {
//        //如果你mypper没有写sql，这里可以点出来他自带的方法，这里的save就是自带的新增方法
//        return userMapper.save(myusers);
//    }
    @Override
    public User test(String account) {
        return userMapper.gettest(account);
    }

    @Override
    public boolean login(String account, String password) {
        return userMapper.getExists(account, password);
    }

    @Override
    public boolean pushUserComment(String userEmail, String experimentID, String content) {
        return userMapper.pushComment(userEmail, experimentID, content);
    }

    @Override
    public void excelExport(HttpServletResponse response) throws IOException {
        List<Users> list = userMapper.selUserMapper();
        String fileName = "用户名单";
        response.setContentType("application/vnd.ms-excel;charset=utf-8");
        response.setCharacterEncoding("utf-8");
        response.setHeader("Content-disposition", "attachment;filename=" + new String(fileName.getBytes("gb2312"), "ISO8859-1") + ".xls");
        ServletOutputStream out = response.getOutputStream();
        ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLS, true);
        Sheet sheet = new Sheet(1, 0, Users.class);
        //设置自适应宽度
        sheet.setAutoWidth(Boolean.TRUE);
        sheet.setSheetName("用户名单");
        writer.write(list, sheet);
        writer.finish();
        out.flush();
        response.getOutputStream().close();
        out.close();
    }

    @Override
    public void excelImport(MultipartFile file) throws IOException {
        if(!file.getOriginalFilename().equals("用户名单.xls") && !file.getOriginalFilename().equals("用户名单.xlsx") ){
            return;
        }
        InputStream inputStream = new BufferedInputStream(file.getInputStream());
        //实例化实现了AnalysisEventListener接口的类
        ExcelListener excelListener = new ExcelListener(userMapper);
        ExcelReader reader = new ExcelReader(inputStream,null,excelListener);
        //读取信息
        reader.read(new Sheet(1,1,Users.class));

    }


}