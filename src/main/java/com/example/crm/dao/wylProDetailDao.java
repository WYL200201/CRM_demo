package com.example.crm.dao;

import com.example.crm.pojo.wylProDetail;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface wylProDetailDao {
    wylProDetail findByName(String pname);
    //找到最大和最小差值
    Double findDis();
    //所有价格
    List<Double> pList();
    //id
    wylProDetail findById(Integer pid);
}
