package com.example.crm.service;

import com.example.crm.pojo.wylProDetail;

import java.util.List;

public interface wylProDetailService {
    wylProDetail findByName(String pname);
    Double findDis();
    List<Double> allPrices();
    wylProDetail findById(Integer pid);
}
