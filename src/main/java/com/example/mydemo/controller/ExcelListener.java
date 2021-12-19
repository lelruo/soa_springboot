package com.example.mydemo.controller;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.example.mydemo.mapper.UserMapper;
import com.example.mydemo.pojo.Users;

import java.util.ArrayList;
import java.util.List;

/**
 * @author
 * @date 2020/11/14--17:15
 */
public class ExcelListener extends AnalysisEventListener<Users> {
    private List<Users> datas = new ArrayList<>();
    private static final int BATCH_COUNT = 3000;
    private UserMapper userDao;

    public ExcelListener(UserMapper userDao){
        this.userDao = userDao;
    }

    @Override
    public void invoke(Users user, AnalysisContext analysisContext) {
        //数据存储到datas，供批量处理，或后续自己业务逻辑处理。
        datas.add(user);
        //达到BATCH_COUNT了，需要去存储一次数据库，防止数据几万条数据在内存，容易OOM
        if(datas.size() >= BATCH_COUNT){
            saveData();
            // 存储完成清理datas
            datas.clear();
        }
    }

    private void saveData() {
        for(Users user : datas){
            userDao.addUser(user);
        }
    }

    public List<Users> getDatas() {
        return datas;
    }

    public void setDatas(List<Users> datas) {
        this.datas = datas;
    }

    /**
     * 所有数据解析完成了 都会来调用
     */
    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();//确保所有数据都能入库
    }
}