package com.xian.service.impl;

import com.xian.dao.IsysLogDao;
import com.xian.domain.SysLog;
import com.xian.service.IsysLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements IsysLogService {
    @Autowired
    private IsysLogDao sysLogDao;

    @Override
    public void save(SysLog sysLog) {
        sysLogDao.save(sysLog);

    }

    @Override
    public List<SysLog> findAll() {
        return sysLogDao.findAll();
    }
}
