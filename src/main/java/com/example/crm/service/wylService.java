package com.example.crm.service;

import com.example.crm.pojo.wylProduct;

import java.util.List;

public interface wylService {
    Integer findBuyNum(String pname);
    Integer findAllCus();
    List<String> proList();
    Integer findTwo(String pname,String pname1);
}
