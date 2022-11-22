package com.example.crm.service.serviceImpl;

import com.example.crm.dao.wylProductDao;
import com.example.crm.pojo.wylProduct;
import com.example.crm.service.wylService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class wylServiceImpl implements wylService {
    @Autowired
    wylProductDao  wylProductDao;
    @Override
    public Integer findBuyNum(String pname) {
        return wylProductDao.findBuyNum(pname);
    }

    @Override
    public Integer findAllCus() {
        return wylProductDao.findAllCus();
    }

    @Override
    public List<String> proList() {
        return wylProductDao.proLists();
    }

    @Override
    public Integer findTwo(String pname, String pname1) {
        return wylProductDao.findTwo(pname,pname1);
    }


}
