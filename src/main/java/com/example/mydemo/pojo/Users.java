package com.example.mydemo.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.metadata.BaseRowModel;
import lombok.Data;

import java.util.Objects;
@Data
public class Users extends BaseRowModel {
    @ExcelProperty(value = "ID", index = 0)
    private String uid;
    @ExcelProperty(value = "姓名", index = 1)
    private String uname;
    @ExcelProperty(value = "密码", index = 2)
    private Integer pwd;
}