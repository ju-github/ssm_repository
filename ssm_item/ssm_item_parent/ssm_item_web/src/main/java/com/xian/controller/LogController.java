package com.xian.controller;

import com.xian.domain.SysLog;
import com.xian.service.IsysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "/sysLog")
public class LogController {
    @Autowired
    private IsysLogService logService;

    @RequestMapping(value = "/findAll")
    public String findAll(Model model){
        List<SysLog> sysLog=logService.findAll();
        model.addAttribute("sysLogs",sysLog);

        return "syslog-list";
    }
}
