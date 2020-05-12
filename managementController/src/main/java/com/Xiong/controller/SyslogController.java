package com.Xiong.controller;

import com.Xiong.domain.Syslog;
import com.Xiong.service.SyslogService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SyslogController {
    @Autowired
    private SyslogService syslogService;

    @RequestMapping("/findAll.do")
    public ModelAndView findAll(@RequestParam(name = "page", required = true, defaultValue = "1") Integer page,
                                @RequestParam(name = "pagesize", required = true, defaultValue = "4") Integer pagesize) throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Syslog> sysLogList = syslogService.findAll(page, pagesize);
        PageInfo pageInfo = new PageInfo(sysLogList);
        mv.addObject("pageInfo", pageInfo);
        mv.setViewName("syslog-list");
        return mv;
    }
}
