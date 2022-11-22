package com.example.crm.controller;


import com.example.crm.pojo.wylProDetail;
import com.example.crm.service.wylProDetailService;
import com.example.crm.service.wylService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class wylController {
    @Autowired
    wylService wylService;
    @Autowired
    wylProDetailService wylProDetailService;
    @GetMapping("/toWyl")
    public String toWyl(){
        return "wyl/main";
    }
    @PostMapping("/find")
    public String find(String pname, Double price,Model model){
//关联算法
        Integer allCus = wylService.findAllCus();
        List<String> wylProducts = wylService.proList();
        //存放频繁项目集
        ArrayList<wylProDetail> pros=new ArrayList<>();
        //存放频繁项目集中支持度
        ArrayList<Double> zhichi=new ArrayList<>();
        //存放频繁项目集中商品名称
        ArrayList<String> pinName=new ArrayList<>();
        //最终的关联商品列表
        ArrayList<wylProDetail> fin=new ArrayList<>();
        //设最小支持度为0.3
        //1项目频繁项目集极其支持度
        for (int i = 0; i < wylProducts.size(); i++) {
            String name = wylProducts.get(i);
            Double zhi=(double)(wylService.findBuyNum(name))/allCus;
            if(zhi>=0.3){
                wylProDetail p1= wylProDetailService.findByName(name);
                pros.add(p1);
                zhichi.add(zhi);
                pinName.add(name);
            }
        }
//关联规则
        for (int j = 0; j < pinName.size(); j++) {
            String pname1=pinName.get(j);
            Integer tNum = wylService.findTwo(pname, pname1);
            //System.out.println(tNum);
            double both =(double) tNum / (double)allCus;
            //System.out.println(both);
           //知道到输入的商品的支持度，从表里面找？double a=zhichi.get(j);
            double a=Double.valueOf(wylService.findBuyNum(pname))/(double)allCus;
            //System.out.println(a);
            //System.out.println(both/a);
            //可信度大于0.5时关联规则有意义
            if((both/a)>0.5){
                //System.out.println(both/a);
                wylProDetail p= pros.get(j);
                fin.add(p);
            }
        }
        model.addAttribute("plist",fin);


//最近邻算法
        //商品价格归一化
        ArrayList<wylProDetail> arrayList=new ArrayList<>();
        Double dis = wylProDetailService.findDis();
        List<Double> doubles = wylProDetailService.allPrices();
        for(int k=0;k<doubles.size();k++){
            Double aDouble = doubles.get(k);
            double v = Math.abs((price - aDouble)) / dis;
            double v1 = Math.sqrt(Math.pow(v, 2));
            if(v1<0.5){
                wylProDetail byId = wylProDetailService.findById(k+1);
                arrayList.add(byId);
            }
        }
        model.addAttribute("plist1",arrayList);
        return "wyl/main";
    }
}

