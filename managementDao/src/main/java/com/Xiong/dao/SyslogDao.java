package com.Xiong.dao;

import com.Xiong.domain.Syslog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SyslogDao {
    @Insert("insert into syslog(id,visitTime,username,ip,url,executionTime,method) values(#{id},#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public void addSyslog(Syslog syslog);

    @Select("select * from syslog")
    public List<Syslog> findAll();

}
