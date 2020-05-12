package com.Xiong.service;

import com.Xiong.domain.Syslog;

import java.util.List;

public interface SyslogService {
    public void addSyslog(Syslog syslog);

    public List<Syslog> findAll(Integer page, Integer pagesize);
}
