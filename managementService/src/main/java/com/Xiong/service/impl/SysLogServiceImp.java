package com.Xiong.service.impl;

import com.Xiong.dao.SyslogDao;
import com.Xiong.domain.Syslog;
import com.Xiong.service.SyslogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImp implements SyslogService {
    @Autowired
    private SyslogDao syslogDao;

    @Override
    public void addSyslog(Syslog syslog) {
        syslogDao.addSyslog(syslog);
    }

    @Override
    public List<Syslog> findAll(Integer page, Integer pagesize) {
        PageHelper.startPage(page, pagesize);
        List<Syslog> all = syslogDao.findAll();
        return all;
    }
}
