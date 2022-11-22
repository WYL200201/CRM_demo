package com.example.crm.service.serviceImpl;


import com.example.crm.dao.wylProDetailDao;
import com.example.crm.pojo.wylProDetail;
import com.example.crm.service.wylProDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class wylProDetailServiceImpl implements wylProDetailService {
    @Autowired
    com.example.crm.dao.wylProDetailDao wylProDetailDao;
    @Override
    public wylProDetail findByName(String pname) {
        return wylProDetailDao.findByName(pname);
    }

    @Override
    public Double findDis() {
        return wylProDetailDao.findDis();
    }

    @Override
    public List<Double> allPrices() {
        return wylProDetailDao.pList();
    }

    @Override
    public wylProDetail findById(Integer pid) {
        return wylProDetailDao.findById(pid);
    }
}
