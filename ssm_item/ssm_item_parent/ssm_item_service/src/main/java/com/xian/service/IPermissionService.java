package com.xian.service;

import com.xian.domain.Permission;

import java.util.List;

public interface IPermissionService {
    public List<Permission> findAll();

    void save(Permission permission);
}
