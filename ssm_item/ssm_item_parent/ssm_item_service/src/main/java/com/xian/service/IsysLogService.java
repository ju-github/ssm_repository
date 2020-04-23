package com.xian.service;

import com.xian.domain.SysLog;

import java.util.List;

public interface IsysLogService {

    public void save(SysLog sysLog);

    List<SysLog> findAll();

}
