package com.gsm.service.impl;

import com.gsm.dao.DemoDao;
import com.gsm.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DemoServiceImpl implements DemoService {
    @Autowired
    private DemoDao demoDao;

    @Override
    public String selectSomething(String name) {
        String s = demoDao.selectSth(name);
        System.out.println("传过来的参数name\t" + name);
        log.debug("debug等级的name\t" + name);
        return s;
    }
}
