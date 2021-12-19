package com.example.mydemo.mapper;


import com.example.mydemo.pojo.Experiment;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ExperMapper {
    @Insert("insert into experiment(userEmail,price,fixedCost,variableCost,bep,conclusion) values (#{userEmail},#{price},#{fixedCost},#{variableCost},#{bep},#{conclusion})")
    void insertExper(Experiment exper1);


}
