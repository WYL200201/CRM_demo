package com.example.crm.dao;

import com.example.crm.pojo.wylProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface wylProductDao {
    Integer findBuyNum(String pname);
    //找到顾客总数
    Integer findAllCus();
    //找到所有商品名称
    List<String> proLists();
    //相关联的两件商品
    Integer findTwo(String pname,String pname1);

}
